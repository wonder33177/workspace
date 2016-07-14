package main.scala.test

/**
  * Created by Administrator on 2016/4/13.
  */
object TestImplicit {
  def main(args: Array[String]) {
    val list = MyList(List(5, 4, 3, 9, 1, 5))
    println(list.sortby1(i => i))
    println(list sortby2 (i => -i))
    val list2 = List(45,68,25,911,125)
    println(list2.sortBy(x => x.toString))
  }
}

case class MyList[A](list: List[A]) {
  def sortby1[B](f: A => B)(implicit ord: Ordering[B]): List[A] = list.sortBy(f)(ord)

  def sortby2[B: Ordering](f: A => B): List[A] = list.sortBy(f)(implicitly[Ordering[B]])

}
