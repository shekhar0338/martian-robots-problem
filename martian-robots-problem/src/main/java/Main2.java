import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    /*
    This main class reads input from console. I was facing  some issue while running on the mac
    so created a new class Main to take input from file : input.txt
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide input...");
        // Read upper-right coordinates of Mars surface
        String[] bounds = sc.nextLine().trim().split("\\s+");
        int maxX = Integer.parseInt(bounds[0]);
        int maxY = Integer.parseInt(bounds[1]);
        MarsSurface surface = new MarsSurface(maxX, maxY);

        List<String> outputs = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            // robot position
            String[] pos = line.split("\\s+");
            int startX = Integer.parseInt(pos[0]);
            int startY = Integer.parseInt(pos[1]);
            Orientation orientation = Orientation.valueOf(pos[2]);
            Robot robot = new Robot(new Coordinate(startX, startY), orientation);

            // instructions (always next line if input is valid)
            if (!sc.hasNextLine()) break;
            String instructions = sc.nextLine().trim();

            List<Command> commands = instructions.chars()
                    .mapToObj(c -> Command.valueOf(Character.toString((char) c)))
                    .toList();

            robot.execute(commands, surface);
            outputs.add(robot.toString());
        }
        sc.close();
        // Print results
        outputs.forEach(System.out::println);

    }
}