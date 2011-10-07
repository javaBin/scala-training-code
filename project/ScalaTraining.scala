import sbt._
import Keys._

object BuildSettings {
  val junit = "junit" % "junit" % "4.8.1"
  val junitInterface = "com.novocode" % "junit-interface" % "0.7" % "test->default"
  
  val globalSettings = Seq(
    organization := "no.scalabin.scala-examples",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.9.1",
    scalacOptions += "-deprecation",
    libraryDependencies ++= Seq(junit, junitInterface)
  )
  val projectSettings = Defaults.defaultSettings ++ globalSettings
}

object ScalaTraining extends Build {
  import BuildSettings._

  lazy val root = Project("root", file(".")) aggregate (common, intro, first_class_functions, higher_order_functions, oo_traits, pattern_matching, quiz)
  
  lazy val common = Project("common", file("common"), settings = projectSettings)
  lazy val intro = Project("intro", file("intro"), settings = projectSettings) dependsOn (common)
  lazy val first_class_functions = Project("first_class_functions", file("first-class-functions"), settings = projectSettings) dependsOn (common)
  lazy val higher_order_functions = Project("higher_order_functions", file("higher-order-functions"), settings = projectSettings) dependsOn (common)
  lazy val oo_traits = Project("oo_traits", file("oo-traits"), settings = projectSettings) dependsOn (common)
  lazy val pattern_matching = Project("pattern_matching", file("pattern-matching"), settings = projectSettings) dependsOn (common)

  lazy val quiz = Project("quiz", file("quiz"),
    settings = projectSettings ++ Seq(libraryDependencies += "org.scala-lang" % "scala-swing" % "2.9.1")
  )
}