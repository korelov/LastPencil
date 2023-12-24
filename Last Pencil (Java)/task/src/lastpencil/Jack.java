package lastpencil;

public class Jack extends Player {
    public Jack() {
        super("Jack");
    }

    @Override
    public int takePencils(int countPencils) {
        int numberPencils;
        if (countPencils == 1) {
            numberPencils = 1;
        } else if (countPencils % 4 == 0) {
            numberPencils = 3;
        } else if (countPencils % 2 == 0) {
            numberPencils = 1;
        } else {
            numberPencils = 2;
        }
        System.out.println(numberPencils);
        return numberPencils;
    }
}
