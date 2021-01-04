class Alien {
    var skill: String = ""

    fun printSkill() {
        println(this.skill)
    }
}

fun main() {
    var a1 = createAlien("Java")
    var a2 = createAlien("SQL")
    var a3 = createAlien("")
    a3.skill = a1.addMySkill(a2)
    a3.printSkill()
}

fun Alien.addMySkill(alien: Alien): String {
    return "${this.skill} ${alien.skill}"
}

fun createAlien(skill: String): Alien {
    var alien = Alien()
    alien.skill = skill
    alien.printSkill()

    return alien
}