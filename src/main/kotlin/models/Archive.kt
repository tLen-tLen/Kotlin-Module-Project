package models

class Archive(val name: String) {
    var notes: MutableList<Note> = mutableListOf<Note>()

}