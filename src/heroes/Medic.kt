package heroes

import general.SuperAbility

class Medic(health: Int, damage: Int, name: String, private val healPoints: Int) :
    Hero(health, damage, SuperAbility.HEAL, name) {

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0 && this != hero) {
                hero.health += this.healPoints
                println("Медик ${this.name} вылечил ${hero.name} на $healPoints здоровья.")
            }
        }
    }
}