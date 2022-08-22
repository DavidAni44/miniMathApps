package com.company;

public class Main {

    public static java.util.Scanner in=new java.util.Scanner(System.in);


    public static void main(String[] args) {
        menu();
    }

    // I created this method and now I am able to call this method after the completion of a game.
    public static void menu() {

        java.util.Scanner in = new java.util.Scanner(System.in);
        //This is to tell the user that they are currently in the menu and they are given options which lead to different games and they have also been given the option to leave the menu and close the app
        System.out.println("P4CS Mini Applications");
        System.out.println("-----------------------");
        System.out.println("Please select an option");
        System.out.println("1) Keep Counting\n2) Check Digit Generator\n3) Check Digit Checker\n4) Square Root Calculator\n9) Exit");
        //this is to input the number the user wants to choose
        int option = in.nextInt();
        // I used an if statement to limit the integers the user can enter to only 1,2,3,4 or 9
        if (option == 5 || option == 6 || option == 7 || option == 8){
            System.out.println("Error , please select one of the options available");
            menu();
        }
        // Here I used multiple if statements that will run the game when the user selects the specific applications number
        if (option == 1) {
            game1();
        }

        if (option == 2) {
            game2();
        }

        if (option == 3) {
            game3();
        }

        if (option == 4) {
            game4();
        }
        // I set 9 to return so that if the user selects it the code will terminate and no longer display a menu of any sort
        if (option == 9) {
            return;
        }
    }

    private static void game1() {
        java.util.Scanner in=new java.util.Scanner(System.in);
        //This just displays the game and tells the user about one of the features which uses the answer as the left operand of the next question.
        System.out.println("Keep Counting");
        System.out.println("---------------");
        System.out.println("You will be presented with 10 addition questions. After the first question, the left-hand operand is the result of the previous addition.");
        int random = (int) (Math.random() * 10);
        long start = System.nanoTime();
        for (int counter = 1; counter <= 10; counter++) {

            //This generates random num between 1 and 10 which will be used in the equation. As you can see I called int random outside the for loop I did this, so I can use the previous answer as the next questions left operand.
            // Additionally, I called the variable "pos,neg" and set the value to int Math.random * 2 to call an if statement that will decide if question was addition or subtraction
            int random2 = (int) (Math.random() * 10);
            int posneg = (int) (Math.random() * 2);

            //This calls the equation and also uses if statements to decide which type of question will be asked, it does this because I set posneg to generate a random number between 1 and 2 and if it is equal to 1 it will display an addition question and if it's 2 it will display a subtraction question additionally the code in this section also calls the variable int answer with the ability to input nums
            if (posneg == 1) {
                System.out.println("Question " + counter + " : " + random + " + " + random2 + " = ");
                random = random;
            } else {
                System.out.println("Question " + counter + " : " + random + " - " + random2 + " = ");
            }
            // This if statement is to change the value of correctans to a subtraction answer if it is a subtraction question t
            int answer = in.nextInt();
            int correctans = random + random2;
            if (posneg == 0) {
                correctans = random - random2;
            }

            //Here I created an if statement that will check the value entered into the program if correct the program will move onto the next question however if not it will display that the user is wrong and will show the correct answer.
            if (answer != correctans) {
                System.out.println("Incorrect. The answer is " + correctans);
                break;
            }
            //This is to calculate how fast the user completes the game and then displays after the user completes the game and sends them back to the menu.
            random = correctans;
            long end = System.nanoTime();
            long elapsedTime = end - start;
            double seconds = (double) elapsedTime / 1_000_000_000.0;
            if (counter == 10)
                System.out.println("Questions complete in " + Math.round(seconds) + " seconds");
        }
        menu();
    }


    /* Test plan for Check digit Checker
     *  Expected Input          Expected Output         Actual Output
     *  25687                   256876                  256876
     *  12345                   123459                  123459
     *  24682                   246824                  246824
     *  54321                   543219                  543219
     *  31153                   311533                  311533
     *  21212                   212122                  212122
     *  45678                   456788                  456788
     */

    private static void game2() {

        //This shows the name of the game and a small description of how to use it and also asks you to input a 5-digit number to generate a 6th digit
        System.out.println("Check-Digit Calculator");
        System.out.println("------------------------");
        System.out.println("This calculator will take a 5-digit num and generate a trailing 6th check digit");
        System.out.println("Please enter 5-digit number to generate final code:");
        //This variable allows the user to input a 5-digit number
        int num = in.nextInt();
        //I created the variable length and used String.valueOf(num).length() so I can see how long input is. This is because I want it to display an error if the user enters more than 5 digits
        int length = String.valueOf(num).length();
        //This determines the place value of the digits
        int digit1 = num / 10000;
        int digit2 = num / 1000;
        int digit3 = num / 100;
        int digit4 = num / 10;
        int digit5 = num - digit4 * 10;
        // This is to calculate the modulo to help determine the digit 6
        digit1 = (digit1 % 10);
        digit2 = (digit2 % 10);
        digit3 = (digit3 % 10);
        digit4 = (digit4 % 10);
        digit5 = (digit5 % 10);
        //This part of the code is to calculate the 6th digit using the equation given
        int sum = (7 * (digit1 + digit3 + digit5) + 3 * (digit2 + digit4));
        int ans = 10 - (sum % 10);

        // I used multiple if statements so the code follows rules such as the input can not be less than 1 and there can not be more than 5 digits
        if (digit1 == 0 || digit2 == 0 || digit3 == 0 || digit4 == 0 || digit5 == 0) {
            System.out.println("Error. Please input an integer more than 0");
            menu();
        }
        if (length > 5) {
            System.out.println("Error, please only enter a 5 digit number");
            menu();
        }
        //This prints the final answer which is digit 6
        System.out.println("The 6-digit final number is: " + digit1 + digit2 + digit3 + digit4 + digit5 + ans);
        menu();
    }


    private static void game3() {

        //This shows the name of the game and a small description of how to use it and also asks you to input a 5-digit number to generate a 6th digit
        System.out.println("Check-Digit Checker");
        System.out.println("------------------------");
        System.out.println("Please enter 6-digit number to check:");
        //This variable allows the user to input a 5-digit number
        int num = in.nextInt();
        //I created the variable length and used String.valueOf(num).length() so I can see how long input is. This is because I want it to display an error if the user enters more than 5 digits
        int length = String.valueOf(num).length();
        //This determines the place value of the digits
        int digit1 = num / 100000;
        int digit2 = num / 10000;
        int digit3 = num / 1000;
        int digit4 = num / 100;
        int digit5 = num / 10;
        int digit6 = num * 1;

        //This is to calculate the modulo to help determine the digit 6
        digit1 = (digit1 % 10);
        digit2 = (digit2 % 10);
        digit3 = (digit3 % 10);
        digit4 = (digit4 % 10);
        digit5 = (digit5 % 10);
        digit6 = (digit6 % 10);
        //This part of the code is to calculate the 6th digit using the equation given
        int sum = (7 * (digit1 + digit3 + digit5) + 3 * (digit2 + digit4));
        int ans = 10 - (sum % 10);

        // I used multiple if statements so the code follows rules such as the input can not be less than 1 and there can not be more than 5 digits
        if (digit1 == 0 || digit2 == 0 || digit3 == 0 || digit4 == 0 || digit5 == 0) {
            System.out.println("Error. Please input an integer more than 0");
            menu();
        }
        if (num < 1) {
            System.out.println("Error. Please input an integer more than 0");
            menu();
        }
        if (length < 6 || length > 6) {
            System.out.println("Error, please only enter a 6 digit number");
            menu();
        }
        //This checks the 6 digit and compares it to the correct answer and then will tell the user if the number is valid or invalid.
        if (digit6 == ans) {
            System.out.println("\nThe number is valid");
            menu();
        } else if (digit6 != ans) {
            System.out.println("\nThe number is invalid");
            menu();
        }
    }

    //I was not able to adjust the upper and lower bound due to some circumstances and miscommunication however I have used methods to attempt this and hope it I will still obtain marks
    private static void game4() {

        //This displays the game and asks the user to enter a positive number and the decimal places the user wants the number displayed to.
        System.out.println("Square Root Calculator");
        System.out.println("----------------------");
        System.out.println("Please enter a positive number:");
        //This si the input for the number we want to square root
        int positive = in.nextInt();
        System.out.println("How many decimal places do you want the solution calculated to");
        //This is the input to determine where we want the decimal place
        int decimal = in.nextInt();
        //I created all the variables here that i will use in my while loop and if statements
        // Here I created if statements that will keep decimal places between 1 and 7
        if (decimal < 1) {
            System.out.println("Error please enter a number more than 0");
            menu();
        }

        if (decimal > 7) {
            System.out.println("Error, please enter a number less than 7");
            menu();
        }
        /// This was my attempt at tackling the problem however I was unable to get the code to update the bounds and apply that to the square root additionally i had a problem comparing the difference to the decimal place then allowing it to update.
        double upperbound = positive;
        double lowerbound = 1;
        double average = (lowerbound + upperbound) / 2;
        double averageSquared = 1;
        double bounddifference = upperbound - lowerbound;
        double answer = average;
        while (averageSquared != positive) {
            averageSquared = average * average;
            if (averageSquared > positive) {
                upperbound = average;
            } else if (averageSquared < positive) {
                lowerbound = average;
            }
            if (bounddifference != decimal) {
                bounddifference--;
                if (bounddifference == decimal) {
                    lowerbound  =  1;
                    upperbound = positive;
                    average = (lowerbound + upperbound) / 2;
                    averageSquared = average * average;
                }

                if (bounddifference < decimal) {
                    averageSquared = average;
                }
            }

        }
        //This is to format the decimal place the user selected via input through using System.printf(); and will input the decimal place between 1 & 7 I obtained this solution from https://www.baeldung.com/java-printstream-printf ;
        System.out.printf("The square root of " + positive + " is " + "%." + decimal + "f", answer);
        System.out.println("\n");
        //This is the menu method that was supposed to take the user back to the main menu if they wanted to attempt a different game
        menu();

    }
}
