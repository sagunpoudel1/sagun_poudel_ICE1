import java.util.Scanner;

public class CardTrick {

    public static void main(String[] args) {
        Card[] magicHand = new Card[7];

        // Generate random cards and add them to magicHand
        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue((int) (Math.random() * 13) + 1); // Random value between 1 and 13
            c.setSuit(Card.SUITS[(int) (Math.random() * 4)]); // Random suit from the suits array
            magicHand[i] = c;
        }

        // Add one luck card hardcoded (2, clubs)
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        magicHand[0] = luckyCard;

        // Ask user for card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your card value (1-13): ");
        int userValue = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter your card suit (Hearts, Diamonds, Clubs, Spades): ");
        String userSuit = scanner.nextLine();

        // Search for user's card in magicHand
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userValue && card.getSuit().equalsIgnoreCase(userSuit)) {
                found = true;
                break;
            }
        }

        // Report the result
        if (found) {
            System.out.println("Congratulations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
    }
}
