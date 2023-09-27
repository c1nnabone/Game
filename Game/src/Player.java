public class Player extends Creature {
    private int maxhealth;
    private int healcounter = 0;

    public Player(int def, int att, int health, int[] damage) {
        super(def, att, health, damage);
        this.maxhealth = health;
    }

    public void heal() {
        if (this.healcounter < 4) {
            double d = this.getHealth() * 1.3;
            if (d > maxhealth) {
                setHealth(maxhealth);
                System.out.println("Игрок был исцелен! Сейчас егo здоровье равно: " + getHealth());
            } else {
                setHealth((int) d);
                System.out.println("Игрок был исцелен! Сейчас егo здоровье равно: " + getHealth());
            }
        } else {
            System.out.println("Превышен лимит лечения (Максимум 4 раза)");
        }
        this.healcounter++;
    }
}
