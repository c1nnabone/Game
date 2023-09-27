import java.util.Random;

public abstract class Creature {

    private int defense;
    private int attack;
    private int health;
    private int[] damage;

    public Creature(int def, int att, int health, int[] damage) {
        if (def > 1 && def < 30) {
            this.defense = def;
        } else {
            throw new IllegalArgumentException("Защита может быть равна значениям от 1 до 30");
        }
        if (att > 1 && att < 30) {
            this.attack = att;
        } else {
            throw new IllegalArgumentException("Атака может быть равна значениям от 1 до 30");
        }
        if (health > 0) {
            this.health = health;
        } else {
            throw new IllegalArgumentException("Здоровье может быть равно значениям от 0 до N");
        }
        this.damage = damage;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public static void enemyAttack(Creature creature1, Creature creature2) {
        StringBuilder string = new StringBuilder();
        Random rn = new Random();
        int max = 0;
        int attmodifier = creature1.getAttack() - creature2.getDefense() + 1;
        System.out.println("Модификатор атаки:  " + attmodifier);
        if (attmodifier > 0) {
            for (int i = 0; i < attmodifier; i++) {
                int everythrow = cubeThrow();
                if (everythrow > max) {
                    max = everythrow;
                }
                string.append("Выполняется бросок №");
                string.append(i);
                string.append("\n");
                string.append("Результат броска: ");
                string.append(everythrow);
                string.append("\n");
                System.out.println(string);
            }
        }
        if (max >= 5) {
            System.out.println("Успех! Наносим урон противнику!");
            creature2.setHealth(creature2.getHealth() - creature1.dealDamage());
        } else {
            System.out.println("Неудача! Никто не получает урон!");
        }
        System.out.println("У противника осталось " + creature2.getHealth() + " здоровья.");
    }

    public int dealDamage() {
        Random rn = new Random();
        int randomDmg = rn.nextInt(this.damage[1] - this.damage[0] + 1) + this.damage[0];
        return randomDmg;
    }

    protected static int cubeThrow() {
        Random rn = new Random();
        int randomNum = rn.nextInt(6 - 1 + 1) + 1;
        return randomNum;
    }

}
