import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class UtilTest : StringSpec({
    "a double with two decimal places should have a pound sign added" {
        val double = 10.99
        double.formatPounds() shouldBe "£10.99"
    }

    "a double with one decimal place should have a zero and a pound sign added" {
        val double = 10.9
        double.formatPounds() shouldBe "£10.90"
    }
})