package general

import heroes.Boss
import heroes.Hero

interface HavingSuperAbility {
    fun applySuperPower(boss: Boss, heroes: Array<Hero>)
}