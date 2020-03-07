import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class LaptopTest : StringSpec ({
    "a laptop should have a description" {
        Laptop().description shouldBe "A laptop"
    }

    "a laptop should have a price" {
        Laptop().price shouldBe 40000
    }
})