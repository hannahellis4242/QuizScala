package quiz

trait AnswerTrait{
  val text:String
  override def toString: String = text;
}

case class Answer(text:String,correct:Boolean) extends  AnswerTrait

/*

[ ] thing
[*] other things

 */
