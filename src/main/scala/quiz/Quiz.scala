package quiz

class Quiz private (val questions: Seq[Question],private val answers:Seq[Set[Int]]) {
  lazy val question: Option[Question] = questions unapply answers.length

  lazy val complete: Boolean = answers.length == questions.length

  def answer(selected: Set[Int]): Quiz = if(complete) this else new Quiz(questions, answers.appended(selected))

  lazy val review: Option[Review] =
    if (!complete) None else {
      val correct = questions
        .zip(answers)
        .filter((question,answer)=>question.mark(answer))
        .map((question,x)=>question)
      Some(Review(questions, correct))
    }
}

object Quiz{
  def apply(questions: Seq[Question])=new Quiz(questions,List())
}
