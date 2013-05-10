package models

import org.scala_tools.time.Imports._

case class KPIValue(timestamp: DateTime, value: Double)

case class KPI(
  id: Long,
  name: String,
  description: String,
  owner: String,
  target: Double,
  deadline: DateTime,
  unit: String,
  values: List[KPIValue]
)

object KPI {
  val kpis = List(
    KPI(
      0,
      "TicketsRaised",
      "Number of Tickets raised in the last 4 weeks",
      "Galactica",
      40.0,
      DateTime.now + 6.month,
      "Number of Tickets raised",
      List(
        KPIValue(DateTime.now - 6.month, 80.0),
        KPIValue(DateTime.now - 5.month, 70.0),
        KPIValue(DateTime.now - 4.month, 60.0),
        KPIValue(DateTime.now - 3.month, 65.0),
        KPIValue(DateTime.now - 2.month, 55.0),
        KPIValue(DateTime.now - 1.month, 50.0),
        KPIValue(DateTime.now - 0.month, 40.0)
      )
    ),
    KPI(
      1,
      "TestKpi",
      "Lots of numbers to test the graph",
      "Team",
      100.0,
      DateTime.now + 12.month,
      "Percentage improvement",
      List(
        KPIValue(DateTime.now - 12.month, 50.0),
        KPIValue(DateTime.now - 11.month, 80.0),
        KPIValue(DateTime.now - 10.month, 70.0),
        KPIValue(DateTime.now - 9.month, 85.0),
        KPIValue(DateTime.now - 8.month, 90.0),
        KPIValue(DateTime.now - 7.month, 100.0),
        KPIValue(DateTime.now - 6.month, 110.0),
        KPIValue(DateTime.now - 5.month, 80.0),
        KPIValue(DateTime.now - 4.month, 85.0),
        KPIValue(DateTime.now - 3.month, 100.0),
        KPIValue(DateTime.now - 2.month, 90.0)
      )
    )
  )

  def all(): List[KPI] = {
    kpis
  }

  def get(id: Int): KPI = {
    kpis(id)
  }
}
