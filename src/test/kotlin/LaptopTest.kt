import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class LaptopTest : StringSpec({
    "a laptop should have a description" {
        SimpleLaptop().description shouldBe "A laptop"
    }

    "a laptop should have a price" {
        SimpleLaptop().price shouldBe 40000
    }

    "a laptop can have its processor upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = ProcessorUpgrade(laptop)
        upgradedLaptop.description shouldBe "A laptop, 1.21 GigaWatts processor"
        upgradedLaptop.price shouldBe 45000
    }
})