import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(10, 10, 30, new int[]{2, 5});
        Monster monster = new Monster(10, 10, 1, new int[]{2, 5});
        System.out.println("Добро пожаловать в подземелье!");
        System.out.println("На Вашем пути стоит монстр!");
        System.out.println("Выберите действие. (Введите (1)\"в атаку\" или (2)\"монстр атакует\" или (3)\"лечение\" и нажмите Enter)");
        Scanner turn = new Scanner(System.in);
        while (turn.hasNext()) {
            switch (Integer.parseInt(turn.next())) {
                case 1:
                    Creature.enemyAttack(player, monster);
                    break;
                case 2:
                    Creature.enemyAttack(monster, player);
                    break;
                case 3:
                    player.heal();
                    break;
            }
        }
    }
}