package models

import scala.collection.mutable.Map

case class Task(id: Long, label: String)

object Task {
  private final val tasks = Map(0L -> Task(0, "first task"), 1L -> Task(1, "second task"))

  def all(): List[Task] = {
    tasks.values.toList
  }

  def create(label: String): Unit = {
    val maxId = tasks.keys.max
    tasks += (maxId + 1) -> Task(maxId + 1, label)
  }

  def delete(id: Long): Unit = {
    tasks.remove(id)
  }
}
