package quiz

trait QuestionTrait {
  val question:String
  val answers:Seq[Answer]
  override def toString: String = question.concat("\n\n") +
    answers
      .zipWithIndex
      .map((answer,index)=>s"${index + 1}) ${answer}")
      .mkString("\n");
}

case class Question(question: String,
                    answers: Seq[Answer]) extends QuestionTrait {
  def mark(selected:Set[Int]):Boolean =
    answers
      .map(x=>x.correct)
      .zipWithIndex.map((correct,index)=>(correct,selected(index)))
        .map((correct,wasSelected)=>wasSelected==correct)
        .forall(x=>x)
}