package heroes

import general.RpgGame
import general.SuperAbility

class Ronaldo(health: Int, damage: Int, name: String) :
    Hero(health, damage, SuperAbility.SHOOT_BALL, name) {
    private var roundCounter = 0
    private val ballDamage = 100
    private val chanceToMiss = 30

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        roundCounter++
        if (roundCounter % 2 == 0) {
            if (RpgGame.random.nextInt(100) >= chanceToMiss) {
                boss.health -= ballDamage
                println("$name ударил мячом по боссу и нанес $ballDamage урона.")
            } else {
                println("$name промахнулся.")
            }
        }
    }
}