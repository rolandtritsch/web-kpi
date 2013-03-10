package models

import org.scala_tools.time.Imports._

import scalax.chart._
import scalax.chart.Charting._

case class KPIValue(timestamp: DateTime, value: Double)

case class KPIHeader(
  id: Long,
  name: String,
  description: String,
  owner: String,
  target: Double,
  deadline: DateTime
)

case class KPI(
  header: KPIHeader,
  values: List[KPIValue],
  chart: XYChart
)

object KPI {
  val kpis = init(
    List(
      KPIHeader(
        0,
        "TicketsRaised",
        "Number of Tickets raised in the last 4 weeks",
        "Galactica",
        40.0,
        DateTime.now + 6.month
      ),
      KPIHeader(
        1,
        "ConsolidationIndex",
        "How consolidated the stores are",
        "Stores",
        100.0,
        DateTime.now + 6.month
      )
    ),
    List(
      List(
        KPIValue(DateTime.now - 6.month, 80.0),
        KPIValue(DateTime.now - 5.month, 70.0),
        KPIValue(DateTime.now - 4.month, 60.0),
        KPIValue(DateTime.now - 3.month, 65.0),
        KPIValue(DateTime.now - 2.month, 55.0),
        KPIValue(DateTime.now - 1.month, 50.0),
        KPIValue(DateTime.now - 0.month, 40.0)
      ),
      List(
        KPIValue(DateTime.now - 6.month, 80.0),
        KPIValue(DateTime.now - 4.month, 90.0)
      )
    )
  )

  def init(headers: List[KPIHeader], values: List[List[KPIValue]]): List[KPI] = {
    val rightNow = DateTime.now
    for(i <- (0 until headers.size).toList; h = headers(i); vs = values(i)) yield {
       val data = vs.map(v => {
         val daysAgo = (v.timestamp to rightNow).toDuration.toStandardDays.getDays
         (daysAgo, v.value)
       })
       val dataset = data.toXYSeriesCollection("")
       val chart = XYLineChart(dataset)
       KPI(h, vs, chart)
    }
  }

  def all(): List[KPI] = {
    kpis
  }

  def get(id: Int): KPI = {
    kpis(id)
  }
}
