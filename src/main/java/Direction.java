public enum Direction {
    NORTH("N") {
        @Override
        public Direction toLeft() {
            return WEST;
        }

        @Override
        public Direction toRight() {
            return EAST;
        }
    },
    EAST("E") {
        @Override
        public Direction toLeft() {
            return NORTH;
        }

        @Override
        public Direction toRight() {
            return SOUTH;
        }
    },
    SOUTH("S") {
        @Override
        public Direction toLeft() {
            return EAST;
        }

        @Override
        public Direction toRight() {
            return WEST;
        }
    },
    WEST("W") {
        @Override
        public Direction toLeft() {
            return SOUTH;
        }

        @Override
        public Direction toRight() {
            return NORTH;
        }
    };

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public abstract Direction toLeft();

    public abstract Direction toRight();

    public static Direction getDirection(String dir) {
        switch (dir) {
            case "N":
                return NORTH;
            case "E":
                return EAST;
            case "S":
                return SOUTH;
            case "W":
                return WEST;
            default:
                throw new IllegalStateException("Unknown literal " + dir);
        }
    }

    @Override
    public String toString() {
        return direction;
    }
}
