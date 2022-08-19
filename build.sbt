/**version := "0.1"

 scalaVersion := "2.11.8"


      name := "Scala_Week_1"

      libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core_2.11" % "2.3.1",
      "org.apache.spark" %% "spark-sql_2.11" % "2.3.1",
      "org.apache.spark" %% "spark-avro" % "3.2.1"

)
**/

/**

val sparkVersion="2.3.1"

libraryDependencies ++= Seq(
     "org.apache.spark"                       %% "spark-core"                    % sparkVersion    % "provided",
     "org.apache.spark"                       %% "spark-sql"                     % sparkVersion    % "provided",
     "org.apache.spark"                       %% "spark-hive"                    % sparkVersion    % "provided",
     "org.scalatest"                          %% "scalatest"                     % "3.1.0"          % Test,
     "gst-engagement-common"                  %% "gst-engagement-common"         % "2.1.6"
)
 **/

name := "Scala_Week_1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.13.8"
lazy val root = (project in file("."))
  .settings(
       name := "Scala_Week_1",
       libraryDependencies ++= Seq(
            "org.apache.spark" %% "spark-sql" % "3.3.0",
            "org.apache.spark" %% "spark-avro" % "3.3.0",
            "org.apache.spark" %% "spark-core" % "3.3.0",
            "org.apache.spark" %% "spark-avro" % "3.2.1"
       )
  )

/**
name := "Scala_Week_1"
version := "0.1"
val sparkVersion = "2.3.1"
scalaVersion := "2.11.8"

resolvers ++= Seq(
  "BigRed Artifactory Repo" at "https://binrepo.target.com/artifactory/bigRED",
  "repo1-cache Artifactory Repo" at "https://binrepo.target.com/artifactory/repo1-cache",
  "Kelsa" at "https://binrepo.target.com/artifactory/kelsa",
  "gst-engagement" at "https://binrepo.target.com/artifactory/dse-gst-engagement"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-hive" % sparkVersion % "provided",
  "org.scalatest" %% "scalatest" % "3.1.0" % Test,
  "gst-engagement-common" %% "gst-engagement-common" % "2.1.6"
)
**/