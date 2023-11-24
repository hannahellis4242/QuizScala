package quiz

case class Review(questions:Seq[Question], correct:Seq[Question]) {
  lazy val percentage: Option[Double] = {
    try {
    Some(correct.length * 100.0 / questions.length)
  } catch
    case e => None
  }
}