package ar.edu.unlam.kmm.clima

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}