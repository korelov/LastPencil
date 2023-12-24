package lastpencil;

import java.util.Scanner;

public class Game {
    public static Scanner scanner = new Scanner(System.in);
    private static final String START_GAME = "How many pencils would you like to use:";
    private static final String NAME_PLAYERS = "Who will be the first (John, Jack):";
    private final Player[] players = {new John(), new Jack()};
    private int pencil;

    private int getPencil() {
        return pencil;
    }

    private void setPencil(int pencil) {
        this.pencil -= pencil;
    }

    private void printPencils() {
        System.out.println("|".repeat(getPencil()));
    }

    public void init() {
        System.out.println(START_GAME);
        while (true) {
            String pencilString = scanner.nextLine();
            if (pencilString.matches("^\\d+$")) {
                this.pencil = Integer.parseInt(pencilString);
                if (pencil > 0) {
                    break;
                } else {
                    System.out.println("The number of pencils should be positive");
                }
            } else {
                System.out.println("The number of pencils should be numeric");
            }
        }
    }

    private int firstPlayer() {
        System.out.println(NAME_PLAYERS);
        while (true) {
            String name = scanner.next();
            if (name.equalsIgnoreCase(players[0].getName())
                    || name.equalsIgnoreCase(players[1].getName())) {
                int result = 0;
                for (int i = 0; i < players.length; i++) {
                    if (name.equalsIgnoreCase(players[i].getName())) {
                        result = i;
                    }
                }
                return result;
            } else {
                System.out.println("Choose between John and Jack.");
            }
        }
    }

    public void playGame() {
        int first = firstPlayer();
        boolean result = true;
        while (result) {
            printPencils();
            players[first].turn();
            setPencil(players[first].takePencils(getPencil()));
            if (first == 0) {
                first++;
            } else {
                first--;
            }
            if (getPencil() == 0) {
                System.out.println(players[first].getName() + " won!");
                result = false;
            }
        }
    }
}
