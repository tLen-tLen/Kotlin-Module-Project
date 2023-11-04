import screens.ArchiveList

class Control {
    fun start() {
        val screen = ArchiveList()

        while (true) {
            screen.showMenu()

            when (InputHelper.readInput()) {
                0 -> screen.createArchive()
                1 -> screen.showArchives()
                2 -> break
                else -> println("Некорректный выбор. Попробуйте еще раз.")
            }
        }
    }
}