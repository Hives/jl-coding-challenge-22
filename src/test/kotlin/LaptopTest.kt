import io.kotlintest.matchers.string.shouldInclude
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class LaptopTest : StringSpec({
    "a laptop should have a description" {
        SimpleLaptop().description shouldBe "Simple laptop (£399.99)"
    }

    "a laptop should have a price" {
        SimpleLaptop().price shouldBe 399.99
    }

    "a laptop can have its processor upgraded" {
        val upgradedLaptop = SimpleLaptop().upgrade(Processor.GIGAWATTS)
        upgradedLaptop.description shouldInclude "Simple laptop (£399.99)"
        upgradedLaptop.description shouldInclude "1.21 GigaWatts processor (£80.00)"
        upgradedLaptop.price shouldBe 479.99
    }

    "a laptop can have its memory upgraded" {
        val upgradedLaptop = SimpleLaptop().upgrade(Memory.MEDIUM)
        upgradedLaptop.description shouldInclude "Simple laptop (£399.99)"
        upgradedLaptop.description shouldInclude "16Gb RAM (£40.00)"
        upgradedLaptop.price shouldBe 439.99
    }

    "a laptop can have its memory and processor upgraded" {
        val upgradedLaptop = SimpleLaptop().upgrade(Processor.GIGAWATTS).upgrade(Memory.MEDIUM)
        upgradedLaptop.description shouldInclude "Simple laptop (£399.99)"
        upgradedLaptop.description shouldInclude "1.21 GigaWatts processor (£80.00)"
        upgradedLaptop.description shouldInclude "16Gb RAM (£40.00)"
        upgradedLaptop.price shouldBe 519.99
    }

    "a laptop can have its storage upgraded" {
        val upgradedLaptop = SimpleLaptop().upgrade(Storage.SSD)
        upgradedLaptop.description shouldInclude "Simple laptop (£399.99)"
        upgradedLaptop.description shouldInclude "1Tb SSD (£99.98)"
        upgradedLaptop.price shouldBe 499.97
    }

    "a laptop can have its graphics upgraded" {
        val upgradedLaptop = SimpleLaptop().upgrade(Graphics.TECHNICOLOR)
        upgradedLaptop.description shouldInclude "Simple laptop (£399.99)"
        upgradedLaptop.description shouldInclude "Technicolor (£47.77)"
        upgradedLaptop.price shouldBe 447.76
    }

    "a laptop can have its battery upgraded" {
        val upgradedLaptop = SimpleLaptop().upgrade(Battery.AAA)
        upgradedLaptop.description shouldInclude "Simple laptop (£399.99)"
        upgradedLaptop.description shouldInclude "4 * AAA included (£3.99)"
        upgradedLaptop.price shouldBe 403.98
    }

    "a laptop can have its case upgraded" {
        val upgradedLaptop = SimpleLaptop().upgrade(Case.SHINY)
        upgradedLaptop.description shouldInclude "Simple laptop (£399.99)"
        upgradedLaptop.description shouldInclude "Teh Shinies (£300.00)"
        upgradedLaptop.price shouldBe 699.99
    }

    "a laptop can have everything upgraded" {
        val dreamMachine =
            SimpleLaptop()
                .upgrade(Processor.KILOHORTZ)
                .upgrade(Memory.MEDIUM)
                .upgrade(Storage.FLOPPY)
                .upgrade(Graphics.MEGAPIXELS)
                .upgrade(Battery.NICKELCADMIUM)
                .upgrade(Case.SHINY)
        dreamMachine.price shouldBe 1684.97
        dreamMachine.description shouldBe "Simple laptop (£399.99), 99 Kilohortz processor (£120.00), 16Gb RAM (£40.00), 5.25\" floppy drive (£24.99), 1,000,000 megapixels (£739.99), nickel-cadmium battery (£60.00), Teh Shinies (£300.00)"
    }
})