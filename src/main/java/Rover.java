public class Rover {
    private Position position;
    private String instructions;

    private Plateau plateau;

    public Rover(Position position, String instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    public void startDiscovery() {
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'M') {
                position.move();
                if (!isValidMove(position.getX(), position.getY()))
                    throw new IllegalStateException("Rover is out of Plateau --> (x, y) = (" + position.getX() + ", " + position.getY() + ")");
            } else {
                position.rotate(instruction);
            }
        }

        System.out.println(position);
    }

    public void registerPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    private boolean isValidMove(int x, int y) {
        return x > -1 &&
                y > -1 &&
                x < plateau.getxMax() + 1 &&
                y < plateau.getyMax() + 1;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "position=" + position +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
