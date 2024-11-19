package heroes

import general.SuperAbility

class Magic(
    health: Int, damage: Int, name: String, private val increaseDamage: Int) : Hero(health, damage, SuperAbility.BOOST, name) {

    private var rounds = 0

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        if (rounds < 4) {
            for (hero in heroes) {
                hero.damage += increaseDamage
            }
            println("Маг $name увеличил урон всех героев на $increaseDamage в раунде ${rounds + 1}.")
            rounds++
        } else {
            println("Маг $name больше не может увеличить урон, прошло 4 раунда.")
        }
    }
}