fun Double.formatPounds() = "£" + this.padZeros()

private fun Double.padZeros() = this.toString().let {
    when (it.substringAfterLast(".").length) {
        1 -> it + "0"
        else -> it
    }
}