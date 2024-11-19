package general

import heroes.*
import kotlin.random.Random

object RpgGame {
    val random = Random
    private var roundNumber = 0

    @JvmStatic
    fun startGame() {
        val boss = Boss(2500, 50, "Skeleton")
        val warrior1 = Warrior(280, 10, "Rick")
        val warrior2 = Warrior(290, 15, "Ahiles")
        val magic = Magic(270, 10, "Skymag", 2)
        val doc = Medic(250, 5, "Dumbledor", 15)
        val assistant = Medic(300, 5, "Shaman", 5)
        val berserk = Berserk(260, 10, "Guts")
        val avrora = Aurora(240, 10, "Avrora")
        val hacker = Hacker(230, 15, "Hacker")
        val ronaldo = Ronaldo(270, 10, "Ronaldo")

        val heroes = arrayOf(warrior1, doc, warrior2, magic, berserk, assistant, avrora, hacker, ronaldo)

        showStatistics(boss, heroes)
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes)
        }
    }

    private fun playRound(boss: Boss, heroes: Array<Hero>) {
        roundNumber++
        boss.chooseDefence()
        boss.attack(heroes)
        for (hero in heroes) {
            if (hero.health > 0 && boss.health > 0 && hero.ability != boss.defence) {
                hero.attack(boss)
                hero.applySuperPower(boss, heroes)
            }
        }
        showStatistics(boss, heroes)
    }

    private fun isGameOver(boss: Boss, heroes: Array<Hero>): Boolean {
        if (boss.health <= 0) {
            println("Heroes won!!!")
            return true
        }
        val allHeroesDead = heroes.all { it.health <= 0 }
        if (allHeroesDead) {
            println("Boss won!!!")
            return true
        }
        return false
    }

    private fun showStatistics(boss: Boss, heroes: Array<Hero>) {
        println("ROUND $roundNumber -------------")
        println(boss)
        heroes.forEach { println(it) }
    }
}