interface Laptop {
    val description: String
    val price: Double
}

class SimpleLaptop : Laptop {
    private val itemPrice = 399.99
    override val description = "Simple laptop @ £$itemPrice" // TODO pad zeroes! need test?!
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

private fun Double.padZeros() = this.toString().let {
    when (it.substringAfterLast(".").length) {
        0 -> it + "00"
        1 -> it + "0"
        else -> it
    }
}