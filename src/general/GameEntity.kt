package general

abstract class GameEntity(health: Int, damage: Int, val name: String) {

    var health: Int = health
        set(value) {
            field = if (value < 0) 0 else value
        }

    var damage: Int = damage
        set(value) {
            field = value
        }

    override fun toString(): String {
        return "$name health: $health damage: $damage"
    }
}