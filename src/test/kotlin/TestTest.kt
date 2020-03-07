import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class TestTest : StringSpec ({
    "Just a test to test the tests" {
        1 + 1 shouldBe 2
    }
})