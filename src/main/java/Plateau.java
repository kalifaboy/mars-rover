import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<Rover> rovers;
    private int xMax;
    private int yMax;

    public Plateau(int xMax, int yMax) {
        rovers = new ArrayList<>();
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public void addRover(Rover rover) {
        rover.registerPlateau(this);
        rovers.add(rover);
    }

    public void start() {
        rovers.forEach(Rover::startDiscovery);
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }
}
