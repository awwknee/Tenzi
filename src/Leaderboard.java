import java.util.ArrayList;

public class Leaderboard {

    // instance variables

    private ArrayList<Long> bestTimes;


    // constructors
    public Leaderboard() {
        bestTimes = new ArrayList<Long>();


    }

    // methods
    public void update(long timeMilliseconds) {
        long temporaryValue = 0;

        bestTimes.add(timeMilliseconds);

        for (int i = 0; i < bestTimes.size(); i++) {
            for (int j = 1; j < (bestTimes.size() - i); j++) {
                if (bestTimes.get(j - 1) > bestTimes.get(j)) {
                    // swap elements
                    temporaryValue = bestTimes.get(j - 1);
                    bestTimes.set((j - 1), bestTimes.get(j));
                    bestTimes.set(j, temporaryValue);
                }

            }
        }
    }

    @Override
    public String toString() {
        int rank = 0;
        String boardString = new String();

        boardString = "\n--Current Leaderboard (in seconds)--\n";

        while (rank < bestTimes.size()) {
            boardString = boardString + rank + 1 + ". "
                    + String.format("%.3f", (float) (bestTimes.get(rank) / 1000)) + "\n";
            rank = rank + 1;
        }
        return boardString;
    }

}
