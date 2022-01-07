package streams

import zio.{ App, Schedule }
import zio.console.putStrLn
import zio.stream._
import zio.duration._


object App0_Streams_Simple extends App {
  def run(args: List[String]) = program.exitCode

  val program = for {
    sum <- Stream(1,2,3).run(Sink.foldLeft(0)((acc, ele) => acc + ele))
    _ <- putStrLn(s"sum of Stream(1,2,3) is ${sum.toString}")
    merged <- Stream(1,2,3).merge(Stream(4,5,6)).runCollect.run
    _ <- putStrLn("merged Stream(1,2,3) with Stream(4,5,6) is ${sum.toString}")
    _ <- putStrLn("exponential backoff ending...").repeat(Schedule.exponential(1.second) <* Schedule.recurs(3))
  } yield () 

}
