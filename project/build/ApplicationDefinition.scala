import sbt._
import sbt.BasicScalaProject._
import java.io.File

class ApplicationProject(info: ProjectInfo) extends ParentProject(info) {
  val mavenLocal = "Local Maven Repository" at "file://" + Path.userHome + "/.m2/repository"

  trait MavenFriendly extends DefaultProject {
    val junitInterface = "com.novocode" %% "junit-interface" % "0.4.0" from "http://github.com/downloads/bryanjswift/junit-interface/junit-interface-0.4.0.jar"

    override def testFrameworks = super.testFrameworks ++ List(new TestFramework("com.novocode.junit.JUnitFrameworkNoMarker"))
    override val mainCompilePath = "target" / "classes"
    override val testCompilePath = "target" / "test-classes"
  }
                                                                                               
  lazy val common = project("common", "common", new DefaultProject(_) {val junit = "junit" % "junit" % "4.8.1"})
  lazy val intro = project("intro", "intro", new DefaultProject(_) with MavenFriendly, common)
  lazy val first_class_functions = project("first-class-functions", "first-class-functions", new DefaultProject(_) with MavenFriendly, common)
  lazy val higher_order_functions = project("higher-order-functions", "higher-order-functions", new DefaultProject(_) with MavenFriendly, common)
  lazy val oo_traits = project("oo-traits", "oo-traits", new DefaultProject(_) with MavenFriendly, common)
  lazy val pattern_matching = project("pattern-matching", "pattern-matching", new DefaultProject(_) with MavenFriendly, common)
  lazy val quiz = project("quiz", "quiz", new DefaultProject(_) with MavenFriendly {
	val scala_swing = "org.scala-lang" % "scala-swing" % "2.8.0"
  }, common)

}
