import java.util.ArrayList;

public class TenziGame {

    // instance variables

    private int turns;

    private long startTime;

    private long endTime;

    private ArrayList<Die> theDice;

    // constructors

    public TenziGame() {
        theDice = new ArrayList<Die>();
        int rollCount = 0;

        while (rollCount < 10) {
            Die die = new Die();
            die.roll();
            theDice.add(die);
            rollCount = rollCount + 1;
        }

        startTime = System.currentTimeMillis();
    }

    // methods

    public boolean isOver() {
        int count = 0;

        while (count < 9) {
            if (theDice.get(count).getFaceValue() != theDice.get(count + 1).getFaceValue()) {
                return false;
            }
            count = count + 1;
        }
        return true;
    }

    public void roll(int[] diceToReroll) {
        int count = 0;

        while (count < diceToReroll.length) {
            theDice.get(diceToReroll[count]).roll();
            count = count + 1;
        }

        if (this.isOver()) {
            endTime = System.currentTimeMillis();
        }

        turns = turns + 1;
    }

    public long getTimeElapsed() {
        return endTime - startTime;
    }

    public int getTurns() {
        return turns;

    }

    @Override
    public String toString() {
        int dieNumber = 0;
        String resultString = new String();

        while (dieNumber < 10) {
            resultString =
                    resultString + dieNumber + ":" + theDice.get(dieNumber).toString() + "\n";
            dieNumber = dieNumber + 1;
        }
        return resultString;
    }

}


