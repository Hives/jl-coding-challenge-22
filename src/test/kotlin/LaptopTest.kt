import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class LaptopTest : StringSpec({
    "a laptop should have a description" {
        SimpleLaptop().description shouldBe "A laptop"
    }

    "a laptop should have a price" {
        SimpleLaptop().price shouldBe 399.99
    }

    "a laptop can have its processor upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = ProcessorUpgrade(laptop)
        upgradedLaptop.description shouldBe "A laptop, 1.21 GigaWatts processor"
        upgradedLaptop.price shouldBe 479.99
    }

    "a laptop can have its memory upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = MemoryUpgrade(laptop)
        upgradedLaptop.description shouldBe "A laptop, extra 16Gb RAM"
        upgradedLaptop.price shouldBe 449.99
    }
})