public enum Orientation {
    N, E, S, W;

    public Orientation left() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }

    public Orientation right() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }

    public Coordinate move(Coordinate c) {
        return switch (this) {
            case N -> new Coordinate(c.x(), c.y() + 1);
            case S -> new Coordinate(c.x(), c.y() - 1);
            case E -> new Coordinate(c.x() + 1, c.y());
            case W -> new Coordinate(c.x() - 1, c.y());
        };
    }
}

