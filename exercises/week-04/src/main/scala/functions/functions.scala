package functions

object Funcs {

  // FUNCTIONAL BASICS:

  /**
    * tail that takes a list and removes the first element, returning the rest
    * of the list.
    * Calling tail on an empty list throws an IllegalArgumentException.
    *
    * @param ls : List[A] the list to process
    * @return A list containing all but the first element of ls
    */
  def tail[A](ls: List[A]): List[A] = 
    ls match {
        case _ :: tl => tl
        case Nil => throw new IllegalArgumentException
    }

  /**
    * setHead replaces the first value in a list with a given value. If the
    * list is empty, it adds the value to the front of the list.
    *
    * @param ls : List[A] the list to be changed
    * @param a  : A the value that will replace the head of ls
    * @return a list whose head is `a' and whose tail is all but the first
    *         element of ls.
    **/
  def setHead[A](ls: List[A], a: A): List[A] = 
    ls match {
        case hd :: tl => a :: tl
        case Nil => List(a)
    }

  /**
    * drop removes n elements from the given list. If n is greater than the
    * length of the list, the function returns an empty list.
    *
    * @param ls : List[A] the list to be changed
    * @param n  : Int the number of elements to drop.
    * @return a list with the first n elements of ls removed, or an empty list.
    */
  def drop[A](ls: List[A], n: Int): List[A] = ls match {
    case Nil => Nil
    case _ :: tl => n match {
        case 1 => tl
        case _ => drop(tl, n - 1)
    }
  }

  /**
    * init takes a list and removes the last element.
    * Like tail, init(Nil) throws an IllegalArgumentException.
    * Implement this function recursively, preferably using match.
    *
    * @param ls : List[A] the list to be changed.
    * @return a list with the last element of ls removed.
    */
  def init[A](ls: List[A]): List[A] = ls match {
    case Nil => throw new IllegalArgumentException
    case _ :: Nil => Nil 
    case hd :: tl => hd :: init(tl)
  }

  // LIST FOLDING

  /*
   * foldLeft reduces a list down to a single value by iteratively applying a
   * function over the elements of the list and carrying the cumulative result
   * along.
   * @param ls: List[A] the list to be reduced.
   * @param z: B the initial value
   * @param f: (B, A) => B the binary function applied to the elements of the
   * list and the cumulative value.
   * @return the final valued.
   */
  def foldLeft[A, B](ls: List[A], z: B)(f: (B, A) => B): B = ls match {
    case hd :: tl => foldLeft(tl, f(z,hd))(f)
    case Nil => z
  }

  /**
    * Use your implementation of foldLeft to implement these functions:
    * - sum: Takes a List[Double] and produces the sum of all elements
    * - product: Takes a List[Double] and produces the product of all elements
    * - length: Takes a List[A] and finds the length of the list.
    * - reverse: Takes a List[A] and produces a new list with the elements of
    * the first list in reverse order. That is, reverse(List(1,2,3)) =
    * List(3,2,1).
    * - flatten: Takes a List[List[A]] and produces a List[A] by joining all
    * the sublists into one long list. For example, flatten(List(List(1,2,3),
    * List(4,5,6))) produces List(1,2,3,4,5,6).
    */
  def sum(ls: List[Double]): Double = ls match {
    case Nil => 0
    case hd :: tl => hd + sum(tl)
  }

  def product(ls: List[Double]): Double = ls match {
    case Nil => 1
    case hd :: tl => hd * product(tl)
  }

  def length[A](ls: List[A]): Int = ls match {
    case Nil => 0
    case hd :: tl => 1 + length(tl)
  }

  def reverse[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case hd :: tl => reverse(tl) ::: List(hd)
  }

  def flatten[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case (head: List[A]) :: tail => flatten(head) ::: flatten(tail)
    case head :: tail => head :: flatten(tail)
  }

  // MAP AND FILTER

  /**
    * map applies a function to a list, producing a new list of the functions'
    * values.
    * As with the other functions, implement this recursively.
    *
    * @param ls : List[A] the list to be changed.
    * @param f  : A => B the function to be applied to each element of the input.
    * @return the resulting list from applying f to each element of ls.
    */
  def map[A, B](ls: List[A])(f: A => B): List[B] = ls match {
    case Nil => Nil
    case hd :: tl => f(hd) :: map(tl)(f)
  }

  /**
    * filter removes all elements from a list for which a given predicate
    * returns false.
    * As usual, this should be recursive.
    *
    * @param ls : List[A] the list to be filtered.
    * @param f  : A => Boolean the predicate
    * @return the filtered list.
    */
  def filter[A](ls: List[A])(f: A => Boolean): List[A] = ls match {
    case Nil => Nil
    case hd :: tl => if (f(hd)) hd :: filter(tl)(f) else filter(tl)(f)
  }

  /**
    * flatMap is very similar to map. However, the function returns a List,
    * and flatMap flattens all of the resulting lists into one.
    *
    * @param ls : List[A] the list to be changed.
    * @param f  : A => List[B] the function to be applied.
    * @return a List[B] containing the flattened results of applying f to all
    *         elements of ls.
    */
    
    // Two versions - one using pattern matching and recursion
    // The second version also uses pm and recursion but in this case it is "tail recursion"

  // def flatMap[A, B](ls: List[A])(f: A => List[B]): List[B] = ls match {
  //   case (x::xs) => f(x) ++ flatMap(xs)(f)
  //   case _ => Nil
  // }

  import scala.annotation.tailrec

  def flatMap[A, B](ls: List[A])(f: A => List[B]): List[B] = {
    @tailrec
    def helper(result: List[B])(input: List[A])(f: A => List[B]): List[B] = input match {
      case (x::xs) => helper(result ++ f(x))(xs)(f)
      case _ => result
    }
    helper(List[B]())(ls)(f)
  }


  // COMBINING FUNCTIONS

  /**
    * maxAverage takes a List[(Double,Double)] (a list of pairs of real
    * numbers) and returns the average value of the largest value in each pair.
    * For example, the maxAverage of List((1,4), (8, 0)) is (8 + 4)/2 = 6.0.
    * You must use the methods you wrote above, particularly map and foldLeft.
    *
    * @param ls : List[(Double,Double)] a list of pairs of real numbers, whose
    *           length is greater than 0.
    * @return the average value of the largest values in the pairs.
    */
  def maxAverage(ls: List[(Double, Double)]): Double = {
    val resultList = map(ls){case (x,y) => if (x < y) y else x}
    sum(resultList) / length(resultList)
  }

  /**
    * variance takes a List[Double] and calculates the squared distance
    * of each value from the mean. This is the *variance*, as used in
    * statistics.
    * 1) Find the mean M of the input.
    *
    * 2) For each value V in the input, calculate (V - M)^2.
    * 3) Find the variance.
    * Which methods that we've already defined can you use? (At least one!)
    * @param ls     : List[Double] a list of values, whose length is greater than 0.
    * @param return the variance of the input.
    */
  import scala.math.pow

  def variance(ls: List[Double]): Double = {
    val mean = sum(ls) / length(ls)
    val lst = map(ls)(v => pow((v - mean),2))
    sum(lst) / length(lst)
  }
}
