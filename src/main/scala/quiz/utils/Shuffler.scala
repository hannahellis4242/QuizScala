package quiz.utils

trait Shuffler {
  def shuffle[T](xs: Seq[T]): Seq[T]
}