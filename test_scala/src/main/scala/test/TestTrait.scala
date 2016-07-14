package main.scala.test

/**
  * 测试trait用法
  * Created by Administrator on 2016/4/12.
  */
class TestTrait(name: String) {
  def work(i: Int): Int = {
    println(s"TestTrait : is working on $i")
    i + 1
  }
}

/**
  * 日志接口
  */
trait Logging {
  def info(message: String): Unit

  def warning(message: String): Unit

  def error(message: String): Unit
}

/**
  * 日志实现
  */
trait StdoutLogging extends Logging {
  def info(message: String) = println(s"INFO:  $message")

  def warning(message: String) = println(s"WARNING:  $message")

  def error(message: String) = println(s"ERROR:  $message")
}

object TestTrait {
  def main(args: Array[String]) {
    val tt = new TestTrait("test trait") with StdoutLogging {
      override def work(i: Int): Int = {
        info(s"Starting work: $i")
        val res = super.work(i)
        info(s"Ending work: $i")
        res
      }
    }

    (1 to 3) foreach (tt.work)

    println(1 :: 2 :: Nil)

    val langs = Seq(
      ("scala", "martin", "odersky"),
      ("clojure", "rich", "hickey"),
      ("lisp", "john", "mccarthy")
    )

    for (tuple <- langs) {
      tuple match {
        case ("scala", _, _) => println("found scala")
        case (lang, first, last) => println(s"$lang $first $last")
      }
    }

    val l = List(1,2,3,4,5)
    println(l.sliding(3,2).toList)
  }
}
