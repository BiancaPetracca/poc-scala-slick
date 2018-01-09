package slickpoc.model

import com.fasterxml.jackson.core.`type`.TypeReference
import slick.jdbc.MySQLProfile.api.{stringColumnType, _}
import slickpoc.utils.Utils.EnumMapper


/**
  * Created by biancapetracca on 1/8/18.
  */


case class User(name: String, surname: String)

case class Item(id: Int, name: String, ageRange: AgeRange, species: Species.Species, user: User)

object Species extends Enumeration with EnumMapper {
  type Species = Value
  val SIMPLE, DOUBLE = Value
}

class SpeciesType extends TypeReference[Species.type]

sealed trait AgeRange {

  implicit def ageRangeMapper = MappedColumnType.base[AgeRange, String](_.toString, name => this.valueOf(name).get)

  val values = Seq(CHILDREN, ADULT)

  def valueOf(name: String) = values.find(_.toString == name)

}

object AgeRange extends AgeRange

case object CHILDREN extends AgeRange

case object ADULT extends AgeRange
