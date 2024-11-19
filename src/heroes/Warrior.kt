package heroes

import general.RpgGame
import general.SuperAbility

class Warrior(health: Int, damage: Int, name: String) :
    Hero(health, damage, SuperAbility.CRITICAL_DAMAGE, name) {

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        val coefficient = RpgGame.random.nextInt(4) + 2
        boss.health -= coefficient * this.damage
        println("Воин ${this.name} нанес критический удар с уроном ${coefficient * this.damage}")
    }
}