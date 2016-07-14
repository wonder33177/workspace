package main.scala.test

/**
  * Created by Administrator on 2016/4/13.
  */
object TestFun {
  def main(args: Array[String]) {
    println(m1(m2()))

    //import scala.collection.Map
    var map = Map("a" -> "aaa")
    map += ("b" -> "bbb")
    //map - ("a")
    println(map.get("b").get)
    val list = List("this","is ","a","scala","program")
    val res = list.foldLeft(List.empty[String]){(list,s)=>{
      (s+"|") :: list
    }}
    println(res)
  }

  def m1(mm: Int => Int) = {
    (1 to 10) filter (_ % 2 == 0) map mm reduce (_ + _)
  }

  def m2(): Int => Int = {
    val factor = 1
    val mm = (i: Int) => i * factor
    mm
  }
}
