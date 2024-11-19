package heroes

import general.GameEntity
import general.HavingSuperAbility
import general.SuperAbility

abstract class Hero(health: Int, damage: Int, val ability: SuperAbility, name: String) :
    GameEntity(health, damage, name), HavingSuperAbility {

    fun attack(boss: Boss) {
        boss.health -= this.damage
    }
}