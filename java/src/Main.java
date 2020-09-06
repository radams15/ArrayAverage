import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private final Scanner in;

    private double calculateAverage(ArrayList<Double> list){
        double sum = list.stream().mapToDouble(Double::doubleValue).sum(); // sum all the data using a stream
        double len = list.size(); // get the length of the list

        return sum/len; // find the average by dividing the sum by the len
    }

    private ArrayList<Double> getNums(String prompt){
        ArrayList<Double> nums = new ArrayList<>();

        boolean stillInputting = true;
        while( stillInputting ){
            System.out.print(prompt);

            String data = in.nextLine(); // get the next line of input

            if(data.length() == 0){ // no data
                continue; // another input
            }

            switch( Character.toLowerCase(data.charAt(0)) ){ // switch for the lowercase of the first character
                // i would have used an if statement but used a switch to show a skill
                case 'c': // if char is c
                    stillInputting = false; // break the loop
                    break;

                default:
                    try {
                        double doubleData = Double.parseDouble(data); // parse the double
                        nums.add(doubleData);
                    }catch(NumberFormatException e){ // string is invalid number
                        continue; // restart the loop
                    }
                    break;
            }
        }

        return nums;
    }

    public Main(String args[]){
        in = new Scanner(System.in); // initialise the scanner for data input

        System.out.println("Simply Enter Numbers After Each Prompt, And Enter The Letter 'c' To Calculate The Average");

        while( true ){
            ArrayList<Double> nums = getNums("=> "); // use the helper method to get the numbers into a nice ArrayList

            double avg = calculateAverage(nums); // calculate the average of all the numbers

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
        new Main(args); // initialise the class and run the initialiser method
    }
}
