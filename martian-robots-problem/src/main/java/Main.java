import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide input...");
        // Read upper-right coordinates of Mars surface
        int maxX = sc.nextInt();
        int maxY = sc.nextInt();
        MarsSurface surface = new MarsSurface(maxX, maxY);

        List<String> outputs = new ArrayList<>();

        while (sc.hasNext()) {
            // Read robot starting position
            if (!sc.hasNextInt()) break; // no more robots
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            String orientationStr = sc.next();
            Orientation orientation = Orientation.valueOf(orientationStr);

            Robot robot = new Robot(new Coordinate(startX, startY), orientation);

            // Read instruction string
            String instructions = sc.next();
            List<Command> commands = instructions.chars()
                    .mapToObj(c -> Command.valueOf(Character.toString((char) c)))
                    .collect(Collectors.toList());

            // Execute
            robot.execute(commands, surface);

            outputs.add(robot.toString());
        }

        // Print outputs
        outputs.forEach(System.out::println);
    }
}