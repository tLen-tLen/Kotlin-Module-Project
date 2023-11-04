object InputHelper {
    fun readInput(): Int {
        val input = readLine()
        return try {
            input?.toInt() ?: -1
        } catch (e: NumberFormatException) {
            -1
        }
    }
}