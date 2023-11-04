package screens

import InputHelper

abstract class Screen {
    protected val inputHelper = InputHelper()
    abstract fun showMenu()
}