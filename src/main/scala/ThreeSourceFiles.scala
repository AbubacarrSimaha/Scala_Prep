import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions.col

/************************************************************************
 * This is program, ingesst three different files types
 * CSV, JSON, CSV files
 * These files are combined and stored in DataFrame
 * And the following made based on the following questions.
 * What is the count of all rows?
 * What is the city with the largest population?
 * What is the total population of all cities in Japan (CountryCode == jpn)
 ****************************************************************************/
object ThreeSourceFiles {

  def main(args: Array[String]): Unit = {

    //Starting Spark Session
    val spark=SparkSession
      .builder()
      .appName("sparkSql")
      .master("local[*]")
      .getOrCreate()

    //Loading the CSV File
    val CityList= spark.read.format("csv").option("header","true").load("Source/CityList.csv")
      .select(col("Name"), col("CountryCode"), col("Population"))
    //Print Schema
       CityList.printSchema()

    //Create DataFrame using Temp view
     CityList.createOrReplaceTempView("CityListC")
    val result=spark.sql("select * from CityListC")
     result.show(10)

    //Loading the Json File
    val CityListA= spark.read.format("json").load("Source/CityListA.json")
      .select(col("Name"), col("CountryCode"), col("Population"))

      //Print Schema
      CityListA.printSchema()

    //Create DataFrame using Temp view
    CityListA.createOrReplaceTempView("CityListA1")
    val result1=spark.sql("select * from CityListA1")
    result1.show(10)

    //Loading the Avro File
    val CityListB= spark.read.format("avro").option("header","true").load("Source/CityListB.avro")
       .select(col("Name"), col("CountryCode"), col("Population"))
       //Print Schema
       CityListB.printSchema()

    //Create DataFrame using Temp view
    CityListB.createOrReplaceTempView("CityListB1")
    val result2=spark.sql("select * from CityListB1")
    result2.show(10)

    /*** for troubleshooting purpose
    CityList.printSchema()
    CityListA.printSchema()
    CityListB.printSchema()
    ****/
    //combine the dataframes and write result into csv file
    val combinedDataFrames= CityList.union(CityListA).union(CityListB).distinct().sort("Name")
    combinedDataFrames.createOrReplaceTempView("CityListCombined")
    val result3=spark.sql("select * from CityListCombined")

    //New dataset stored in a new CSV file
    result3.write.mode(SaveMode.Overwrite).csv("Results/output")
    result3.show(100)

    // Analysis of the combined DataSets
    print("What is the count of all rows?")
    val result4=spark.sql("select count(*) Number_of_Rows from CityListCombined")
    result4.show(100)
    print("What is the city with the largest population?")
    val result5=spark.sql("select Name, max(Population) from CityListCombined ")
    result5.show(100)
    print("What is the total population of all cities in Japan (CountryCode == jpn)")
    val result6=spark.sql("select Name, max(Population)  where CountryCode == jpn from CityListCombined ")
    result6.show(100)

  }

}