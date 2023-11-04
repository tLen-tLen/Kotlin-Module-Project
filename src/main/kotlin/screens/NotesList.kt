package screens

import models.Archive
import models.Note

class NotesList(val archive: Archive): Screen {

     override fun showMenu() {
        println("Архив '${archive.name}':")
        println("1. Создать заметку")
        println("2. Просмотр заметок")
        println("3. Назад")
        print("Выберите опцию: ")
    }

     fun viewArchive() {
        while (true) {
            showMenu()

            when (InputHelper.readInput()) {
                1 -> createNote()
                2 -> viewNotes()
                3 -> return
                else -> println("Некорректный выбор. Попробуйте еще раз.")
            }
        }
    }

    private fun createNote() {
        println("Введите название заметки:")
        val name = readLine() ?: ""
        if (! name.isBlank()) {
            print("Введите текст заметки: ")
            val text = readLine() ?: ""
            if (! text.isBlank()) {
                val note = Note(name, text)
                archive.notes.add(note)
                println("Заметка '$name' создана")
            } else {
                println("Текст заметки не может быть пустым")
            }
        } else {
            println("Имя заметки не может быть пустым")
        }
    }

    private fun viewNotes() {
        println("Заметки в архиве '${archive.name}':")
        for (i in 0 until archive.notes.size) {
            println("${i + 1}. ${archive.notes[i].name}")
        }
        println("${archive.notes.size + 1}. Назад")

        print("Выберите номер заметки для просмотра или введите ${archive.notes.size + 1} для выхода: ")
        val input = InputHelper.readInput()

        if (input in 1..archive.notes.size) {
            val note = archive.notes[input - 1]
            println("Заметка '${note.name}':")
            println(note.text)
            println("Нажмите Enter, чтобы вернуться")
            readLine()
        } else if (input == archive.notes.size + 1) {
            return
        } else {
            println("Некорректный выбор. Попробуйте еще раз.")
        }
    }
}