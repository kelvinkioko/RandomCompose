package com.graph.randomcompose

open class Person constructor(val age: Int) {
    open fun talk() {
        val message = "I am a simple person, aged $age"
        println(message)
    }
}

class AndroidEngineer constructor(age: Int): Person(age) {
    override fun talk() {
        val message = "I am a software developer, aged $age"
        println(message)
    }

    fun develop() {
        val message = "I develop android applications"
        println(message)
    }
}

fun main(args: Array<String>) {
    val person = Person(age = 30)
    person.talk()

    val androidEngineer = AndroidEngineer(age = 27)
    androidEngineer.talk()
    androidEngineer.develop()
}