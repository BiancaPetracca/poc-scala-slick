package slickpoc.model

import com.fasterxml.jackson.core.`type`.TypeReference

/**
  * Created by biancapetracca on 1/8/18.
  */


case class User(name: String, surname: String)

case class Item(id: Int, name: String, ageRange: AgeRange, user: User)

object Species extends Enumeration {
  implicit val enumMapper = MappedColumnType.base[Value, String](_.toString, this.withName)
  type Species = Value
  val SIMPLE, DOUBLE = Value
}

class SpeciesType extends TypeReference[Species.type]

sealed trait AgeRange

case object Children extends AgeRange

case object Adult extends AgeRange
