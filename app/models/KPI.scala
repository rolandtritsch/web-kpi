package models

import org.scala_tools.time.Imports._
import play.api.libs.json.Json
import scala.io.Source
import com.codahale.jerkson.Json._

case class KPIValue(timestamp: String, value: String)

case class KPIHeader(
  id: String,
  name: String,
  description: String,
  owner: String,
  target: String,
  deadline: String,
  historicalValues: List[KPIValue]
)

object KPI {

  val kpis = List(
    getOneKpi
    // KPIHeader(
    //   0,
    //   "TicketsRaised",
    //   "Number of Tickets raised in the last 4 weeks",
    //   "Galactica",
    //   40.0,
    //   new DateTime(2013, 7, 1, 0, 0, 0, 0),
    //   List(
    //     KPIValue(new DateTime(2012, 6, 1, 0, 0, 0, 0), 80.0),
    //     KPIValue(new DateTime(2012, 7, 1, 0, 0, 0, 0), 50.0),
    //     KPIValue(new DateTime(2012, 8, 1, 0, 0, 0, 0), 60.0),
    //     KPIValue(new DateTime(2012, 9, 1, 0, 0, 0, 0), 90.0),
    //     KPIValue(new DateTime(2012, 10, 1, 0, 0, 0, 0), 80.0),
    //     KPIValue(new DateTime(2012, 11, 1, 0, 0, 0, 0), 90.0),
    //     KPIValue(new DateTime(2012, 12, 1, 0, 0, 0, 0), 60.0),
    //     KPIValue(new DateTime(2013, 1, 1, 0, 0, 0, 0), 80.0)
    //   )
    // ),
    // KPIHeader(
    //   1,
    //   "ConsolidationIndex",
    //   "How consolidated the stores are",
    //   "Stores",
    //   100.0,
    //   new DateTime(2013, 7, 1, 0, 0, 0, 0),
    //   List(
    //     KPIValue(new DateTime(2012, 12, 1, 0, 0, 0, 0), 50.0),
    //     KPIValue(new DateTime(2013, 1, 1, 0, 0, 0, 0), 60.0)
    //   )
    // )
  )

  def all(): List[KPIHeader] = {
    kpis
  }

  def get(id: Int): KPIHeader = {
    kpis(id)
  }

  def getOneKpi(): KPIHeader = {
    val jsonString = Source.fromFile("data/sample.json").mkString
    parse[KPIHeader](jsonString)
  }
}
