import sbt._

object Dependencies {

  val jeneticsVersion = "4.3.0"
  val catsVersion     = "2.0.0"

  val jeneticsDeps: Seq[ModuleID] = Seq(
    "jenetics",
    "jenetics.prog",
    "jenetics.ext"
  ).map("io.jenetics" % _ % jeneticsVersion)

  val kindProjector: ModuleID = "org.typelevel"              %% "kind-projector"            % "0.11.0"
  val shapeless               = "com.chuusai"                %% "shapeless"                 % "2.3.3"
  val java8compat             = "org.scala-lang.modules"     %% "scala-java8-compat"        % "0.9.0"
  val catsCore                = "org.typelevel"              %% "cats-core"                 % catsVersion
  val alleycatsCore           = "org.typelevel"              %% "alleycats-core"            % catsVersion
  val akka                    = "com.typesafe.akka"          %% "akka-stream"               % "2.5.25"
  val fs2                     = "co.fs2"                     %% "fs2-core"                  % "2.0.1"
  val scalatest               = "org.scalatest"              %% "scalatest"                 % "3.0.8"
  val scalacheck              = "org.scalacheck"             %% "scalacheck"                % "1.14.0"
  val scalacheckShapeless     = "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % "1.2.3"

}
