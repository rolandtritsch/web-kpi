package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import models._

import scala.io.Source

object Application extends Controller {

  val kpiForm = Form(
    "name" -> nonEmptyText
  )

  def index = Action {
    Redirect(routes.Application.kpis)
  }

  def kpis = Action {
    Ok(views.html.list(KPI.all(), kpiForm))
  }

  def kpi(id: Int) = Action {
    Ok(views.html.detail(KPI.get(id), kpiForm))
  }
}
