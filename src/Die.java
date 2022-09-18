import java.util.Random;

public class Die {

    // instance variables

    private int faceValue;

    // constructors

    public Die() {
        faceValue = 1;

    }

    // methods

    public int getFaceValue() {
        return faceValue;
    }


    public void roll() {
        Random generator = new Random();
        faceValue = generator.nextInt(6) + 1;

    }

    @Override
    public String toString() {
        String starface = new String("");
        int count = faceValue;
        while (count != 0) {
            starface = starface + " *";
            count = count - 1;
        }
        return starface;
    }

}
