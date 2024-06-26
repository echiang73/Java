/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private Map<String, String> vocabulary = new HashMap<String, String>();

    public Main() {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));
        
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("QUIT", "Q");
    }
    
    public void command() {
        Scanner scanner = new Scanner(System.in);
        int currLocation = 1;
        while(true) {
            System.out.println(locations.get(currLocation).getDescription());
            if(currLocation == 0) {
                break;
            }
            Map<String, Integer> currExits = locations.get(currLocation).getExits();

            String exits = "";
            for(String exit: currExits.keySet()) {
                exits += exit + ", ";
            }
            System.out.println("Available exits are " + exits);
           
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] inputs = direction.split(" ");
                for(String input: inputs) {
                    if(vocabulary.containsKey(input)) {
                        direction = vocabulary.get(input);
                        break;
                    }
                }
            }
           
            if (currExits.containsKey(direction)) {
                currLocation = currExits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}


// Alternative code to print each exit per iteration of the loop instead of using concatenation:            
            System.out.print("Available exits are ");
            for(String exit: currExits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();


// Alternative code using functional programming stream (won't pass Udemy checker with extra lambda method):
            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                // String[] inputs = direction.split(" ");
                // for(String input: inputs) {
                //     if(vocabulary.containsKey(input)) {
                //         direction = vocabulary.get(input);
                //         break;
                //     }
                // }
 
                direction = List.of(direction.split(" ")).stream().filter(i -> vocabulary.containsKey(i)).findFirst().get();
           }