package heroes

import general.RpgGame
import general.SuperAbility

class Hacker(health: Int, damage: Int, name: String) :
    Hero(health, damage, SuperAbility.HACK, name) {

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        val stolenHealth = RpgGame.random.nextInt(30) + 20
        boss.health -= stolenHealth

        val randomHero = heroes[RpgGame.random.nextInt(heroes.size)]
        if (randomHero.health > 0) {
            randomHero.health += stolenHealth
            println("$name забрал $stolenHealth здоровья у босса и передал герою ${randomHero.name}.")
        }
    }
}