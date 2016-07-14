package main.scala.test

import java.io.{FileInputStream, BufferedInputStream, File}

/**
  * Created by Administrator on 2016/4/11.
  */
object Test {
  def main(args: Array[String]) {
    println("test")
    //countTo(10)
    //println(hello("scala"))
    //getMap()
    println(new StringBulkReader("hello scala!").read)
    println(new FileBulkReader(new File("D:\\develop\\idea_projects\\test_scala\\src\\main\\scala\\test\\Test.scala")) read)
  }

  def countTo(n: Int): Unit = {
    def count(i: Int): Unit = {
      if (i <= n) {
        println(i)
        count(i + 1)
      }
    }
    count(1)
  }

  def hello(name: String) =
    s"""Welcome!
        Hello,$name
       *(Gratuitous Star!!)
        |We're glad you're here.
     """.stripMargin

  def getMap() = {
    val map = Map("a" -> "aaa", "b" -> "bbb")
    println(map.get("a"))
    println(map.get("a").get)
    println(map.get("c").getOrElse("else"))
  }

  abstract class BulkReader[Input] {
    val source: Input

    def read: String
  }

  class StringBulkReader(val source: String) extends BulkReader[String] {
    def read: String = source
  }

  class FileBulkReader(val source: File) extends BulkReader[File] {
    def read: String = {
      val in = new BufferedInputStream(new FileInputStream(source))
      val numBytes = in.available()
      val bytes = new Array[Byte](numBytes)
      in.read(bytes, 0, numBytes)
      new String(bytes)
    }
  }

}
