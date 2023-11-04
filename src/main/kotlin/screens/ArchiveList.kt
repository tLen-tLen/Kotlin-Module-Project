package screens

import models.Archive

class ArchiveList : Screen() {
    private var list: MutableList<Archive> = mutableListOf<Archive>()

    override fun showMenu() {
        println("Меню:")
        println("0. Создать архив")
        println("1. Просмотр архивов")
        println("2. Выход")
    }

    fun createArchive() {
        println("Введите название архива:")

        var name: String? = ""

        while (name!!.isEmpty()) {
            name = readLine()
            if (name == "" || name == null) {
                println("Название архива не может быть пустым")
            }
        }

        list.add(Archive(name))
    }

    fun showArchives() {
        while (true) {
            printArchivesMenu()
            val input = inputHelper.readInput()
            if (input in 1..list.size) {
                val archive = list[input - 1]
                val screen = NotesList(archive)
                screen.viewArchive()
            } else if (input == list.size + 1) {
                return
            } else {
                println("Некорректный выбор. Попробуйте еще раз.")
            }
        }
    }

    private fun printArchivesMenu() {
        var index = 1
        for (i in list) {
            println("$index. ${i.name}")
            index++
        }
        println("${list.size + 1}. Выход")
        print("Выберите архив или введите ${list.size + 1} для выхода: ")
    }
}