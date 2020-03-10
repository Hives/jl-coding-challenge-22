interface Laptop {
    val description: String
    val price: Double
}

class SimpleLaptop : Laptop {
    private val itemPrice = 399.99

    override val description = "Simple laptop (${itemPrice.formatPounds()})"
    override val price = itemPrice
}

abstract class LaptopDecorator(laptop: Laptop, option: Option) : Laptop {
    override val description = "${laptop.description}, ${option.description} (${option.price.formatPounds()})"
    override val price = laptop.price + option.price
}

class ProcessorUpgrade(laptop: Laptop, option: Processor) : LaptopDecorator(laptop, option)
class MemoryUpgrade(laptop: Laptop, option: Memory) : LaptopDecorator(laptop, option)
class StorageUpgrade(laptop: Laptop, option: Storage) : LaptopDecorator(laptop, option)
class GraphicsUpgrade(laptop: Laptop, option: Graphics) : LaptopDecorator(laptop, option)
class BatteryUpgrade(laptop: Laptop, option: Battery) : LaptopDecorator(laptop, option)
class CaseUpgrade(laptop: Laptop, option: Case) : LaptopDecorator(laptop, option)

sealed class Option(val description: String, val price: Double)

sealed class Processor(description: String, price: Double): Option(description, price) {
    object GIGAWATTS : Processor("1.21 GigaWatts processor", 80.0)
    object KILOHORTZ : Processor("99 Kilohortz processor", 120.0)
}

sealed class Memory(description: String, price: Double): Option(description, price) {
    object SMALL : Memory("8Mb RAM", 0.50)
    object MEDIUM : Memory("16Gb RAM", 40.00)
    object LARGE : Memory("64Gb RAM", 100.00)
}

sealed class Storage(description: String, price: Double): Option(description, price) {
    object CARDBOARD : Storage("A cardboard box", 1.20)
    object FLOPPY : Storage("5.25\" floppy drive", 24.99)
    object SSD : Storage("1Tb SSD", 99.98)
}

sealed class Graphics(description: String, price: Double): Option(description, price) {
    object TECHNICOLOR : Graphics("Technicolor", 47.77)
    object MEGAPIXELS : Graphics("1,000,000 megapixels", 739.99)
}

sealed class Battery(description: String, price: Double): Option(description, price) {
    object AAA : Battery("4 * AAA included", 3.99)
    object NICKELCADMIUM : Battery("nickel-cadmium battery", 60.00)
}

sealed class Case(description: String, price: Double): Option(description, price) {
    object SHINY : Case("Teh Shinies", 300.00)
}