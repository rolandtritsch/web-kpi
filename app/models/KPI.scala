package models

import scala.io.Source
import com.codahale.jerkson.Json._
import org.joda.time.format.DateTimeFormat
import com.codahale.jerkson.JsonSnakeCase

case class KPIValue(timestamp: String, value: Double) {
  lazy val date = KPI.formatter.parseDateTime(timestamp)
}

@JsonSnakeCase
case class KPIHeader(
  id: Long,
  name: String,
  description: String,
  owner: String,
  target: Double,
  deadline: String,
  historicalValues: List[KPIValue]
) {
    lazy val date = KPI.formatter.parseDateTime(deadline)
}

object KPI {

  val formatter = DateTimeFormat.forPattern("MM/dd/yyyy");

  val kpis = all

  def all(): List[KPIHeader] = {
    val files = new java.io.File("data").listFiles.filter(_.getName.endsWith(".json"))

    files.map  { file =>
      parse[KPIHeader](Source.fromFile(file).mkString)
    }.toList

  }

  def get(id: Int): KPIHeader = {
    kpis(id)
  }
}
