package slickpoc.model

/**
  * Created by biancapetracca on 1/8/18.
  */


case class User(name: String, surname: String)

case class Item(id: Int, name: String, user: User)
