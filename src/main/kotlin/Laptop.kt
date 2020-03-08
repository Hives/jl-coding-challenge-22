interface Laptop {
    val description: String
    val price: Double
}

class SimpleLaptop : Laptop {
    private val itemPrice = 399.99
    override val description = "Simple laptop @ £${itemPrice.padZeros()}"
    override val price = itemPrice
}

abstract class LaptopDecorator(decoratedLaptop: Laptop) : Laptop {
    override val description = decoratedLaptop.description
    override val price = decoratedLaptop.price
}

class ProcessorUpgrade(laptop: Laptop) : LaptopDecorator(laptop) {
    private val upgradePrice = 80.0
    override val description = super.description + ", 1.21 GigaWatts processor @ £${upgradePrice.padZeros()}"
    override val price = super.price + upgradePrice
}

class MemoryUpgrade(laptop: Laptop) : LaptopDecorator(laptop) {
    private val upgradePrice = 50.0
    override val description = super.description + ", extra 16Gb RAM @ £${upgradePrice.padZeros()}"
    override val price = super.price + upgradePrice
}

class StorageUpgrade(laptop: Laptop) : LaptopDecorator(laptop) {
    private val upgradePrice = 99.98
    override val description = super.description + ", 1Tb SSD @ £${upgradePrice.padZeros()}"
    override val price = super.price + upgradePrice
}

class GraphicsUpgrade(laptop: Laptop) : LaptopDecorator(laptop) {
    private val upgradePrice = 47.77
    override val description = super.description + ", Technicolor @ £${upgradePrice.padZeros()}"
    override val price = super.price + upgradePrice
}

class BatteryUpgrade(laptop: Laptop) : LaptopDecorator(laptop) {
    private val upgradePrice = 3.99
    override val description = super.description + ", 4 * AAA included @ £${upgradePrice.padZeros()}"
    override val price = super.price + upgradePrice
}

class ShinyCaseUpgrade(laptop: Laptop) : LaptopDecorator(laptop) {
    private val upgradePrice = 300.00
    override val description = super.description + ", Teh Shinies @ £${upgradePrice.padZeros()}"
    override val price = super.price + upgradePrice
}