import java.util.Scanner;

// By: Isabella Guimet 

// Fully funtional simulation option
// Game play - user only allowed to enter numbers, program inserts "buzz" when needed 

public class Buzz {

    /**
     * Checks that the user's input is the next num expected i.e. one more than the previous num
     * 
     * @param previous_num   the number before the number the user will enter
     * @param user_num       the number the user will enter
     * @return               returns true if user_num is the next number expected. Otherwise, returns false.
     * 
     */

    public static Boolean check(int previous_num, int user_num) {
    
        if (user_num == previous_num + 1) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This simulation automatically generates all numbers with the correct pattern specified.
     * 
     * @param max            the maximum number this simulation goes up to 
     * @param rule_pattern   the integer number this simulation says buzz for
     * @return               returns "End of Simulation" when done
     * 
     */

    public static String Simulation (int max, int rule_pattern) {
        
        // number is divisible by 7 OR number has a '7' in it
        int num = 1;

        String str2 = Integer.toString(rule_pattern);

        while (num <= max) {

            String str1 = Integer.toString(num); 

            if (num % rule_pattern == 0 || str1.indexOf(str2) != -1) {
                System.out.println("Buzz");
            }
    
            else {
                System.out.println(num);
            }
    
            num = num + 1;
        }
        
        return "End of Simulation"; 
    }

    /**
     * Main execution of program. The user can choose to play the simulation option or the game play
     * option.
     * 
     * @param args
     */

    public static void main(String[] args) {
        int num = 0;
        boolean input = true;

        Scanner scn3 = new Scanner(System.in);
        System.out.println("Would you like to play through the game or run a simulation?");
        System.out.println("Type 'play' to play through the game or type 'run' to run a simulation.");
        
        String program_type = scn3.next();
        String s_run = "run";
        String s_play = "play";
        System.out.println("");

        if (program_type.compareToIgnoreCase(s_run) == 0) {
            Scanner scner = new Scanner(System.in);
            System.out.println("Enter the rule pattern - the integer number it says buzz for and the max number (with a space): ");
            int rule_pattern = scner.nextInt();
            int max_number = scner.nextInt();
            String end_program = Simulation(max_number, rule_pattern);
            System.out.println(end_program);  
            scner.close();          
        }

        if (program_type.compareToIgnoreCase(s_play) == 0) {

            Scanner scn = new Scanner(System.in);
            System.out.println("Note: You won't be allowed to enter the word \"Buzz\", only the numbers");     
            System.out.println("");
            System.out.println("Enter your number starting from 1: ");   
            
            int user_input = scn.nextInt();
            input = check(num, user_input);
            

            while (input == true) {         

                String str1 = Integer.toString(user_input);

                // number is divisible by 7 OR number has a '7' in it
                if (user_input % 7 == 0 || str1.indexOf('7') != -1) {
                    System.out.println("Buzz");
                }

                num = num + 1;

                Scanner scn1 = new Scanner(System.in);
                user_input = scn1.nextInt();
                input = check(num, user_input);
                
            }

            scn.close();
            scn3.close();

            if (input == false) {
                System.out.println("Wrong number. End of game.");
            }
        }
    }
}


