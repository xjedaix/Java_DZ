import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        int i = generateRandomNumber(0, 2000);
        int n = calculateMostSignificantBit(i);

        System.out.println("Случайное целое число i: " + i);
        System.out.println("Номер старшего значащего бита n: " + n);
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int calculateMostSignificantBit(int number) {
        if (number == 0) {
            return 0;
        }

        int bit = 0;
        while (number > 0) {
            number >>= 1;
            bit++;
        }

        return bit;
    }
}
