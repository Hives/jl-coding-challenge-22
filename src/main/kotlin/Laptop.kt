interface Laptop {
    val description: String
    val price: Double
}

class SimpleLaptop : Laptop {
    override val description = "A laptop"
    override val price = 399.99
}

abstract class LaptopDecorator(decoratedLaptop: Laptop) : Laptop {
    override val description = decoratedLaptop.description
    override val price = decoratedLaptop.price
}

class ProcessorUpgrade(laptop: Laptop) : LaptopDecorator(laptop) {
    override val description = super.description + ", 1.21 GigaWatts processor"
    override val price = super.price + 80.00
}

class MemoryUpgrade(laptop: Laptop) : LaptopDecorator(laptop) {
    override val description = super.description + ", extra 16Gb RAM"
    override val price = super.price + 50.00
}