public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void rotate(char instruction) {
        switch (instruction) {
            case 'L':
                direction = direction.toLeft();
                break;
            case 'R':
                direction = direction.toRight();
                break;
            default:
                throw new IllegalStateException("Unknown instruction " + instruction);
        }
    }

    public void move() {
        switch (direction) {
            case EAST:
                x += 1;
                break;
            case NORTH:
                y += 1;
                break;
            case SOUTH:
                y -= 1;
                break;
            case WEST:
                x -= 1;
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}
