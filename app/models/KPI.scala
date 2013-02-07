package models

import scala.io.Source
import com.codahale.jerkson.Json._
import play.api.libs.json._
import java.util.Date

case class KPIValue (timestamp: String, //Date,
	 				 value: Double)

case class KPI (name: String,
	            description: String,
	            owner: String,
	            target: Double,
	            deadline: String) //, Date,
	            // historicalValues: Array[KPIValue])

case class KPIS (kpis: Array[KPI])

object KPI {

	/*
	*  Retrieve the KPIs
	*/
	def getKPIs(jsonString : String) : Array[KPI] = {
		// parse[KPIS](jsonString).kpis

		val json: JsValue = Json.parse(jsonString)
		val kpis = (json \ "kpis").as[Array[JsObject]] // must return a list to iterate on

    	kpis.map { kpi =>
      		KPI(name = (kpi \ "name").as[String],
	            description = (kpi \ "description").as[String],
	            owner = (kpi \ "owner").as[String],
	            target = (kpi \ "target").as[Double],
	            deadline = (kpi \ "deadline").as[String]) //,
	            // historicalValues = (kpi \ "historical_values").as[Array[KPIValue]])
   		}
	}
}


