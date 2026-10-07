import java.util.Scanner;

class CircularSinglyLinkedList {

    class Node {
        String player;
        Node next;

        Node(String player) {
            this.player = player;
            this.next = null;
        }
    }

    Node last = null;

    // Insert a player
    void insert(String player) {
        Node newNode = new Node(player);

        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }

        System.out.println(player + " added to the game.");
    }

    // Delete a player
    void delete(String player) {
        if (last == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node current = last.next;
        Node previous = last;

        do {
            if (current.player.equalsIgnoreCase(player)) {

                if (current == last && current.next == last) {
                    last = null;
                } else if (current == last) {
                    previous.next = current.next;
                    last = previous;
                } else {
                    previous.next = current.next;
                }

                System.out.println(player + " removed from the game.");
                return;
            }

            previous = current;
            current = current.next;

        } while (current != last.next);

        System.out.println("Player not found.");
    }

    // Display players
    void display() {
        if (last == null) {
            System.out.println("No players in the game.");
            return;
        }

        Node current = last.next;

        System.out.println("\nPlayers and their turns:");

        do {
            System.out.print(current.player + " -> ");
            current = current.next;
        } while (current != last.next);

        System.out.println("(Back to " + last.next.player + ")");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CircularSinglyLinkedList game = new CircularSinglyLinkedList();

        int choice;

        do {
            System.out.println("\n===== CIRCULAR PLAYER GAME =====");
            System.out.println("1. Insert Player");
            System.out.println("2. Delete Player");
            System.out.println("3. Display Players");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String name = sc.nextLine();
                    game.insert(name);
                    break;

                case 2:
                    System.out.print("Enter player name to delete: ");
                    String deleteName = sc.nextLine();
                    game.delete(deleteName);
                    break;

                case 3:
                    game.display();
                    break;

                case 4:
                    System.out.println("Game ended.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
