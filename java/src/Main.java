import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            ArrayList<Double> nums = new ArrayList<>();

            boolean stillInputting = true;
            while(stillInputting){
                System.out.print("=> ");
                String data = in.nextLine();
                if(data.length() == 0){ // no data
                    continue; // another input
                }
                switch(Character.toLowerCase(data.charAt(0))){ // switch for the lowercase of the first character
                    // i would have used an if statement but used a switch to show a skill
                    case 'c': // if char is c
                        stillInputting = false; // break the loop
                        break;

                    default:
                        try {
                            nums.add(Double.parseDouble(data));
                        }catch(NumberFormatException e){ // string is invalid number
                            continue; // restart the loop
                        }
                        break;
                }
            }

            System.out.println("Done!");

            double total = nums.stream().mapToDouble(Double::doubleValue).sum();
            double len = nums.size();
            double avg = total/len;

            System.out.printf("Average Is %f%n", avg);

            System.out.print("Again? [y/n]"); // prompt to ask user to go again
            String answer = in.nextLine(); // get the next line of input
            if(answer.length() == 0 || Character.toLowerCase(answer.charAt(0)) == 'n'){ // if there is no input or the first char is 'n'
                break; // stop the loop
            }
            // otherwise go restart the loop
        }
    }

    public static void main(String args[]){
        new Main(args);
    }
}
