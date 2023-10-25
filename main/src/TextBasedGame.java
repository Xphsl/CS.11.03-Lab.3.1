import java.util.Scanner;

public class TextBasedGame {

    // Player's variables
    private static int playerHealth = 100;
    private static int playerGold = 0;
    private static String playerName = "";

    // Game state
    private static boolean gameOver = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Text-Based Adventure Game!");

        // Get the player's name
        getPlayerName(scanner);

        // Start the game
        System.out.println("Hello, " + playerName + ". Your adventure begins!");
        while (!gameOver) {
            displayOptions();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            handleChoice(choice, scanner);
        }

        // Game over
        System.out.println("Game over! Thanks for playing, " + playerName + ".");
        scanner.close();
    }

    // Method to get the player's name
    private static void getPlayerName(Scanner scanner) {
        System.out.print("Enter your name: ");
        playerName = scanner.nextLine();
    }

    // Method to display game options
    private static void displayOptions() {
        System.out.println("Options:");
        System.out.println("1. Explore a cave");
        System.out.println("2. Fight a monster");
        System.out.println("3. Collect treasure");
        System.out.println("4. Quit the game");
        System.out.print("Enter your choice: ");
    }

    // Method to handle player's choice
    private static void handleChoice(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                exploreCave();
                break;
            case 2:
                fightMonster();
                break;
            case 3:
                collectTreasure();
                break;
            case 4:
                quitGame();
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }

    // Method to explore a cave
    private static void exploreCave() {
        System.out.println("You enter a dark cave...");
        int randomDamage = (int) (Math.random() * 20) + 10;
        playerHealth -= randomDamage;
        System.out.println("Oh no! You took " + randomDamage + " damage.");

        if (playerHealth <= 0) {
            System.out.println("You lost the game! Your adventure ends here.");
            gameOver = true;
        }
    }

    // Method to fight a monster
    private static void fightMonster() {
        System.out.println("You encounter a fearsome monster!");
        boolean playerWins = (Math.random() < 0.5); // 50% chance of winning
        if (playerWins) {
            System.out.println("You defeated the monster and gained 20 gold!");
            playerGold += 20;
        } else {
            System.out.println("The monster defeated you! You lose the game.");
            gameOver = true;
        }
    }
    // Method to collect treasure
    private static void collectTreasure() {
        int randomTreasure = (int) (Math.random() * 30) + 10;
        System.out.println("You found " + randomTreasure + " gold!");
        playerGold += randomTreasure;
    }

    // Method to quit the game
    private static void quitGame() {
        System.out.println("Are you sure you want to quit? (yes/no): ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            gameOver = true;
        }
    }

}
