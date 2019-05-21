import sbt._

object Dependencies {

  object v {
    val nscala_time = "2.22.0"
    val config = "1.3.4"

    val scalacheck = "1.14.0"
    val scalatest = "3.0.5"

    val logback_classic = "1.2.3"
    val scala_logging = "3.9.2"
  }

  // 常用配置
  val nscala_time = "com.github.nscala-time" %% "nscala-time" % v.nscala_time
  val config = "com.typesafe" % "config" % v.config

  // 测试
  val scalacheck = "org.scalacheck" %% "scalacheck" % v.scalacheck % "test"
  val scalatest = "org.scalatest" %% "scalatest" % v.scalatest % "test"

  // 日志
  val logback_classic = "ch.qos.logback" % "logback-classic" % v.logback_classic
  val scala_logging = "com.typesafe.scala-logging" %% "scala-logging" % v.scala_logging

  lazy val common = Seq(
    nscala_time,
    config,
    scalacheck,
    scalatest,
    logback_classic,
    scala_logging
  )
}