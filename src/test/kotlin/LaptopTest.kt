import io.kotlintest.should
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class LaptopTest : StringSpec({
    "a laptop should have a description" {
        SimpleLaptop().description shouldBe "Simple laptop @ £399.99"
    }

    "a laptop should have a price" {
        SimpleLaptop().price shouldBe 399.99
    }

    "a laptop can have its processor upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = ProcessorUpgrade(laptop)
        upgradedLaptop.description shouldBe "Simple laptop @ £399.99, 1.21 GigaWatts processor @ £80.00"
        upgradedLaptop.price shouldBe 479.99
    }

    "a laptop can have its memory upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = MemoryUpgrade(laptop)
        upgradedLaptop.description shouldBe "Simple laptop @ £399.99, extra 16Gb RAM @ £50.00"
        upgradedLaptop.price shouldBe 449.99
    }

    "a laptop can have its memory and processor upgraded" {
        val upgradedLaptop = MemoryUpgrade(ProcessorUpgrade(SimpleLaptop()))
        upgradedLaptop.description shouldBe "Simple laptop @ £399.99, 1.21 GigaWatts processor @ £80.00, extra 16Gb RAM @ £50.00"
        upgradedLaptop.price shouldBe 529.99
    }
})