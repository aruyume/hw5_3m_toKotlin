package heroes

import general.SuperAbility

class Berserk(health: Int, damage: Int, name: String) :
    Hero(health, damage, SuperAbility.BLOCK_DAMAGE_REVERT, name) {

    var blockedDamage: Int = 0

    override fun applySuperPower(boss: Boss, heroes: Array<Hero>) {
        boss.health -= blockedDamage
        println("Берсерк $name вернул $blockedDamage урона боссу.")
    }
}