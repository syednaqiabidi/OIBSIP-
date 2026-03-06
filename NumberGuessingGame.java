import javax.swing.JOptionPane;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;

        while (guess != number) {

            String input = JOptionPane.showInputDialog(null,
                    "Guess a number between 1 and 100:");

            guess = Integer.parseInt(input);
            attempts++;

            if (guess < number) {
                JOptionPane.showMessageDialog(null,
                        "Too Low! Try a higher number.");
            }
            else if (guess > number) {
                JOptionPane.showMessageDialog(null,
                        "Too High! Try a lower number.");
            }
            else {
                JOptionPane.showMessageDialog(null,
                        "Correct! You guessed the number in "
                                + attempts + " attempts.");
            }
        }
    }
}