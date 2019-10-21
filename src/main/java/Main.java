import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length > 0) {
            String skipPattern = "(\r\n|[\n\r\u2028\u2029\u0085])?";
            Scanner scanner = new Scanner(new File(args[0]));
            String[] upperRightCoordinates = scanner.nextLine().split(" ");
            scanner.skip(skipPattern);
            int xMax = Integer.parseInt(upperRightCoordinates[0]);
            int yMax = Integer.parseInt(upperRightCoordinates[1]);

            Plateau plateau = new Plateau(xMax, yMax);

            while (scanner.hasNextLine()) {
                String[] position = scanner.nextLine().split(" ");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                scanner.skip(skipPattern);
                String instructions = scanner.nextLine();
                Rover rover = new Rover(new Position(x, y, Direction.getDirection(position[2])), instructions);
                scanner.skip(skipPattern);

                plateau.addRover(rover);
            }

            plateau.start();
        } else {
            System.out.println("No command line args found !");
        }

    }
}
