interface Laptop {
    val description: String
    val price: Int
}

class SimpleLaptop : Laptop {
    override val description = "A laptop"
    override val price = 40000
}

abstract class LaptopDecorator(private val decoratedLaptop: Laptop) : Laptop {
    override val description = decoratedLaptop.description
    override val price = decoratedLaptop.price
}

class ProcessorUpgrade(private val laptop: Laptop) : LaptopDecorator(laptop) {
    override val description = super.description + ", 1.21 GigaWatts processor"
    override val price = super.price + 5000
}