package lastpencil;

public abstract class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int takePencils(int countPencils) {
        while (true) {
            try {
                String playerNumberString = Game.scanner.next();
                int number = Integer.parseInt(playerNumberString);
                if (number > 3 || number == 0 || number < 0) {
                    System.out.println("Possible values: '1', '2' or '3'");
                } else if (countPencils - number < 0) {
                    System.out.println("Too many pencils were taken");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }

    public void turn() {
        System.out.println(name + "'s turn!");
    }
}
