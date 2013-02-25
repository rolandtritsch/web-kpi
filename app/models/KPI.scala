package models

import org.scala_tools.time.Imports._
import play.api.libs.json.Json
import scala.io.Source
import play.api.libs.json._
import scala.collection.mutable.ListBuffer

case class KPIValue(timestamp: String /*DateTime*/, value: Double)

case class KPIHeader(
  id: Long,
  name: String,
  description: String,
  owner: String,
  target: Double,
  deadline: String, // DateTime
  historicalValues: List[KPIValue]
)

object KPI {

  val kpis = all

  def all(): List[KPIHeader] = {
    val files = new java.io.File("data").listFiles.filter(_.getName.endsWith(".json"))

    var kpiHeader = new ListBuffer[KPIHeader]

    for(file <- files) { 
      val jsonString = Source.fromFile(file).mkString
      val json: JsValue = Json.parse(jsonString mkString)

      // Build list of historical values
      val histValues = (json \ "historicalValues").as[List[JsObject]]
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
  }

  def get(id: Int): KPIHeader = {
    kpis(id)
  }
}
