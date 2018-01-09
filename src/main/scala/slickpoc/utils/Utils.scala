package slickpoc.utils

import slick.jdbc.MySQLProfile.api._


/**
  * Created by biancapetracca on 1/9/18.
  */
object Utils {

  trait EnumMapper {
    this: Enumeration =>
    implicit val enumMapper: BaseColumnType[Value] = MappedColumnType.base[Value, Int](_.id, this.apply)
  }


}