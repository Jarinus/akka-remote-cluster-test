package net.atos.remotecluster

import com.typesafe.config.{Config, ConfigFactory}

object ConfigParser {
  def parse(args: Array[String]): Config = {


    val configString = (parseArguments(args) map toKeyValuePairString)
      .mkString("\n")

    ConfigFactory
      .parseString(configString)
      .withFallback(ConfigFactory.load)
  }

  private def toKeyValuePairString(keyValuePair: (String, String)) = keyValuePair match {
    case (key, value) => s"$key=$value"
  }

  private def parseArguments(args: Array[String]): List[(String, String)] = {
    def loop(args: Array[String], acc: List[(String, String)]): List[(String, String)] = args.headOption match {
      case None => acc
      case Some(arg) =>
        val (values, remainder) = args.drop(1) span (!isArgument(_))

        val valuesAsValue =
          if (values.length > 1) values.mkString("[\"\"\"", "\"\"\", \"\"\"", "\"\"\"]")
          else values.headOption match {
            case Some(value) => value
            case None => ""
          }

        loop(
          remainder,
          acc :+ (arg.substring(1) -> valuesAsValue))
    }

    loop(args, Nil)
  }

  private def isArgument(arg: String) = arg.charAt(0) == '-'
}
