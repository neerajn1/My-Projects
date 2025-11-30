public class Monster {
    private String name;
    private int health;
    public Monster(String name, int health) {
        this.name = name;
        this.health = health;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
    public void attack(Player player, int damage) {
        player.takeDamage(damage);
    }
}

