import java.util.List;

public class Robot {
    private Coordinate pos;
    private Orientation orientation;
    private boolean lost;

    Robot(Coordinate start, Orientation orientation) {
        this.pos = start;
        this.orientation = orientation;
        this.lost = false;
    }

    public void execute(List<Command> commands, MarsSurface surface) {
        for (Command cmd : commands) {
            if (lost) break;
            switch (cmd) {
                case L -> orientation = orientation.left();
                case R -> orientation = orientation.right();
                case F -> {
                    Coordinate next = orientation.move(pos);
                    if (surface.isOutOfBounds(next)) {
                        if (!surface.hasScent(pos, orientation)) {
                            lost = true;
                            surface.leaveScent(pos, orientation);
                        }
                    } else {
                        pos = next;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return pos.x() + " " + pos.y() + " " + orientation + (lost ? " LOST" : "");
    }


}