package models

import org.scala_tools.time.Imports._
import play.api.libs.json._
import scala.io.Source
import com.codahale.jerkson.Json._
import org.joda.time.format.DateTimeFormat
import com.codahale.jerkson.JsonSnakeCase
import collection.mutable.ListBuffer

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

    // ******** not using jerkson. remove me when ClassCastException is fixed ******* \\
    var kpiHeader = new ListBuffer[KPIHeader]

    for(file <- files) { 
      val jsonString = Source.fromFile(file).mkString
      val json: JsValue = Json.parse(jsonString mkString)

      // Build list of historical values
      val histValues = (json \ "historical_values").as[List[JsObject]]
      val historicalValues = histValues.map { histValue => 
         KPIValue(timestamp = (histValue \ "timestamp").as[String],
                 value = (histValue \ "value").as[Double])
      }

      // Create KPIHeader object
      kpiHeader += KPIHeader(id = (json \ "id").as[Long],
                             name = (json \ "name").as[String],
                             description = (json \ "description").as[String],
                             owner = (json \ "owner").as[String],
                             target = (json \ "target").as[Double],
                             deadline = (json \ "deadline").as[String],
                             historicalValues)
    }
    kpiHeader.toList
    // ******** not using jerkson. remove me when ClassCastException is fixed ******* \\

     /**
      Uncomment the code below and remove code above for parsing with Jerkson.
      Currently, this will compile, but throws a ClassCastException
      when editing a template and reloading the page. 
     */
    // files.map  { file =>
    //   parse[KPIHeader](Source.fromFile(file).mkString)
    // }.toList
  }

  def get(id: Int): KPIHeader = {
    kpis(id)
  }
}
