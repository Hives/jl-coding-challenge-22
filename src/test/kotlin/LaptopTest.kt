import io.kotlintest.matchers.string.shouldInclude
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
        upgradedLaptop.description shouldInclude "Simple laptop @ £399.99"
        upgradedLaptop.description shouldInclude "1.21 GigaWatts processor @ £80.00"
        upgradedLaptop.price shouldBe 479.99
    }

    "a laptop can have its memory upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = MemoryUpgrade(laptop)
        upgradedLaptop.description shouldInclude "Simple laptop @ £399.99"
        upgradedLaptop.description shouldInclude "extra 16Gb RAM @ £50.00"
        upgradedLaptop.price shouldBe 449.99
    }

    "a laptop can have its memory and processor upgraded" {
        val upgradedLaptop = MemoryUpgrade(ProcessorUpgrade(SimpleLaptop()))
        upgradedLaptop.description shouldInclude "Simple laptop @ £399.99"
        upgradedLaptop.description shouldInclude "1.21 GigaWatts processor @ £80.00"
        upgradedLaptop.description shouldInclude "extra 16Gb RAM @ £50.00"
        upgradedLaptop.price shouldBe 529.99
    }

    "a laptop can have its storage upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = StorageUpgrade(laptop)
        upgradedLaptop.description shouldInclude "Simple laptop @ £399.99"
        upgradedLaptop.description shouldInclude "1Tb SSD @ £99.98"
        upgradedLaptop.price shouldBe 499.97
    }

    "a laptop can have its graphics upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = GraphicsUpgrade(laptop)
        upgradedLaptop.description shouldInclude "Simple laptop @ £399.99"
        upgradedLaptop.description shouldInclude "Technicolor @ £47.77"
        upgradedLaptop.price shouldBe 447.76
    }

    "a laptop can have its battery upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = BatteryUpgrade(laptop)
        upgradedLaptop.description shouldInclude "Simple laptop @ £399.99"
        upgradedLaptop.description shouldInclude "4 * AAA included @ £3.99"
        upgradedLaptop.price shouldBe 403.98
    }

    "a laptop can have its case upgraded" {
        val laptop = SimpleLaptop()
        val upgradedLaptop = ShinyCaseUpgrade(laptop)
        upgradedLaptop.description shouldInclude "Simple laptop @ £399.99"
        upgradedLaptop.description shouldInclude "Teh Shinies @ £300.00"
        upgradedLaptop.price shouldBe 699.99
    }

    "a laptop can have everything upgraded" {
        val dreamMachine = ShinyCaseUpgrade(BatteryUpgrade(GraphicsUpgrade(StorageUpgrade(MemoryUpgrade(ProcessorUpgrade(SimpleLaptop()))))))
        dreamMachine.price shouldBe 981.73
        dreamMachine.description shouldBe "Simple laptop @ £399.99, 1.21 GigaWatts processor @ £80.00, extra 16Gb RAM @ £50.00, 1Tb SSD @ £99.98, Technicolor @ £47.77, 4 * AAA included @ £3.99, Teh Shinies @ £300.00"
    }
})