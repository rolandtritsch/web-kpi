package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import models._

import scala.io.Source

object Application extends Controller {

  def index = Action{
    val jsonString = Source.fromFile("/web/web-kpi/resources/kpi.json").mkString
    val kpis = KPI.getKPIs(jsonString)

    println(kpis)
    Ok(views.html.index(kpis))
  }

}