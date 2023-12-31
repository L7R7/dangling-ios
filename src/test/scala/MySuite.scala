import weaver.SimpleIOSuite
import cats.effect._

object MySuite extends SimpleIOSuite {

  private val random = IO(java.util.UUID.randomUUID())

  test("test with side-effects") {
    for {
      x <- random
      y <- random
      _ = expect.same(false, true).failFast // <- this should use `<-` instead of `=`
      _ = IO.println("foo")
    } yield expect(x != y)
  }
}