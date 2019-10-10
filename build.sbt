import sbt.url
import Dependencies._

lazy val scala212               = "2.12.10"
lazy val scala213               = "2.13.1"
lazy val supportedScalaVersions = List(scala212, scala213)

ThisBuild / name := "helisa"
ThisBuild / organization := "com.softwaremill"
ThisBuild / scalaVersion := scala212

crossScalaVersions := supportedScalaVersions

lazy val repoUrl = "https://github.com/softwaremill/helisa"

addCompilerPlugin(kindProjector cross CrossVersion.full)

scalacOptions ++= {
  CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, scalaMajor)) if scalaMajor == 12 =>
      Seq("-feature", "-Ypartial-unification")
    case _ => Seq()
  }
}

val coreDeps = Seq(shapeless, java8compat, catsCore, alleycatsCore)
val apiDeps  = Seq(akka, fs2).map(_ % Optional)
val testDeps = Seq(scalatest, scalacheck, scalacheckShapeless).map(_ % Test)

libraryDependencies ++= jeneticsDeps ++ coreDeps ++ apiDeps ++ testDeps

//ScalaDoc
enablePlugins(SiteScaladocPlugin, GhpagesPlugin)

siteSubdirName in SiteScaladoc := "latest/api"
scalacOptions in (Compile, doc) ++= Seq("-groups") ++ Opts.doc.title("Helisa")

scmInfo := Some(ScmInfo(url(repoUrl), s"$repoUrl.git"))
git.remoteRepo := scmInfo.value.get.connection

//Sonatype OSS stuff (based on https://github.com/xerial/sbt-sonatype )
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

publishMavenStyle := true

licenses := Seq("APL2" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))
homepage := Some(url(repoUrl))
scmInfo := Some(
  ScmInfo(
    url(repoUrl),
    "scm:git@github.com:softwaremill/helisa.git"
  )
)
developers := List(
  Developer(id = "mikolak-net", name = "Mikołaj Koziarkiewicz", email = "", url = url("https://softwaremill.com"))
)
