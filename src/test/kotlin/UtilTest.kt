import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class UtilTest : StringSpec({
    "a double with two decimal places should be unchanged" {
        val double = 10.99
        double.padZeros() shouldBe "10.99"
    }

    "a double with one decimal place should have a zero added" {
        val double = 10.9
        double.padZeros() shouldBe "10.90"
    }

    "a double with three decimal places should be unchanged" {
        val double = 10.999
        double.padZeros() shouldBe "10.999"
    }
})