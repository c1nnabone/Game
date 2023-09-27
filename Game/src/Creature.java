import java.util.Random;

public abstract class Creature {

    private int defense;
    private int attack;
    private int health;
    private int[] damage;
    private boolean isAlive;

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
        if (damage[1] > damage[0]) {
            this.damage = damage;
        } else {
            throw new IllegalArgumentException("Урон может быть равен M-N (Например 1-6)");
        }
        this.isAlive = true;
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

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public static void enemyAttack(Creature creature1, Creature creature2) {
        if (creature1.isAlive) {
            if (creature2.isAlive) {
                StringBuilder string = new StringBuilder();
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
                        string.append(i + 1);
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
                    if (creature2.getHealth() <= 0) {
                        creature2.setAlive(false);
                        System.out.println("Противник повержен!");
                    } else {
                        System.out.println("У противника осталось " + creature2.getHealth() + " здоровья.");
                    }
                } else {
                    System.out.println("Неудача! Никто не получает урон!");
                }
            } else {
                System.out.println("Вы атакуете труп...");
            }
        } else {
            System.out.println("Трупы не могут атаковать...");
        }
    }

    private int dealDamage() {
        return new Random().nextInt(this.damage[1] - this.damage[0] + 1) + this.damage[0];
    }

    private static int cubeThrow() {
        return new Random().nextInt(6 - 1 + 1) + 1;
    }
}
