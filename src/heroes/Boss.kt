package heroes

import general.GameEntity
import general.RpgGame
import general.SuperAbility

class Boss(health: Int, damage: Int, name: String) : GameEntity(health, damage, name) {
    var defence: SuperAbility? = null

    fun attack(heroes: Array<Hero>) {
        for (hero in heroes) {
            if (hero.health > 0) {
                if (hero is Berserk && this.defence != SuperAbility.BLOCK_DAMAGE_REVERT) {
                    val blocked = (RpgGame.random.nextInt(2) + 1) * 5
                    hero.blockedDamage = blocked
                    hero.health -= (damage - blocked)
                } else {
                    hero.health -= this.damage
                }
            }
        }
    }

    fun chooseDefence() {
        val variants = SuperAbility.values()
        val randomIndex = RpgGame.random.nextInt(variants.size)
        this.defence = variants[randomIndex]
    }

    override fun toString(): String {
        return "BOSS ${super.toString()} defence: $defence"
    }
}