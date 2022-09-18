import java.util.Scanner;

public class TenziDriver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Leaderboard board = new Leaderboard();

        while (true) {
            TenziGame game = new TenziGame();

            while (!game.isOver()) {
                System.out.print(game);
                System.out.print("\nWhich to roll: ");
                game.roll(splitToInts(keyboard.next()));
            }
            System.out.print(game);

            board.update(game.getTimeElapsed());

            System.out.print("\nGame over.  You used " + game.getTurns() + " turns and "
                    + game.getTimeElapsed() + " seconds.\n");

            System.out.print(board);

            System.out.print("\nPlay again? (Y/N) ");
            if (!keyboard.next().equals("Y")) {
                return;
            }
        }
    }

    public static int[] splitToInts(String intstoroll) {
        String[] stringList = intstoroll.split(",");
        int[] intList = new int[stringList.length];
        int count = 0;

        while (count < stringList.length) {
            intList[count] = Integer.parseInt(stringList[count]);
            count = count + 1;
        }
        return intList;
    }



}

