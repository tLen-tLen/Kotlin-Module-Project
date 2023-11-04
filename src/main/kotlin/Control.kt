import screens.ArchiveList

class Control {
    private val inputHelper = InputHelper()
    fun start() {
        val screen = ArchiveList()

        while (true) {
            screen.showMenu()

            when (inputHelper.readInput()) {
                0 -> screen.createArchive()
                1 -> screen.showArchives()
                2 -> break
                else -> println("Некорректный выбор. Попробуйте еще раз.")
            }
        }
    }
}