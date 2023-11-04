package screens

import models.Archive

class ArchiveList : Screen {
    private var list: MutableList<Archive> = mutableListOf<Archive>()

    override fun showMenu() {
        println("Меню:")
        println("0. Создать архив")
        println("1. Просмотр архивов")
        println("2. Выход")
    }

    fun createArchive() {
        println("Введите название архива:")

        var name: String = ""

        while (name.isBlank()) {
            name = readLine().toString()
            if (name.isBlank()) {
                println("Название архива не может быть пустым")
            }
        }

        list.add(Archive(name))
    }

    fun showArchives() {
        while (true) {
            printArchivesMenu()
            val input = InputHelper.readInput()
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
        list.forEachIndexed { index, element ->
            println("${index + 1}. ${element.name}")
        }
        println("${list.size + 1}. Назад")
        print("Выберите архив или введите ${list.size + 1} для выхода: ")
    }
}