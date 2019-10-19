import java.security.SecureRandom;
import java.util.Scanner;

public class Main {


    public static void genNegFeedback() {
        SecureRandom switchGen = new SecureRandom();
        int switchVal = switchGen.nextInt(4);
        switch (switchVal) {
            case 1:
                System.out.println("Sorry, that's not correct. Try again.");
                break;
            case 2:
                System.out.println("Incorrect, but perseverance is the key to success!");
                break;
            case 3:
                System.out.println("No, please try again.");
                break;
            default:
                System.out.println("Don't give up!");
                break;
        }


    }

    public static void genPosFeedback() {
        SecureRandom switchGen = new SecureRandom();
        int switchVal = switchGen.nextInt(4);
        switch (switchVal) {
            case 1:
                System.out.println("Good job!");
                break;
            case 2:
                System.out.println("Keep it up!");
                break;
            case 3:
                System.out.println("That's correct!");
                break;
            default:
                System.out.println("Dead on!");
                break;
        }


    }

    public static double generateQuestion(int diff, int type) {
        SecureRandom randGen = new SecureRandom();
        int qType = type;
        if (qType == 5) {
            qType = randGen.nextInt(4);
        }
        int randVal1 = 0;
        int randVal2 = 0;
        double trueAns = 0;
        switch (diff) {
            case 1:
                randVal1 = randGen.nextInt(10);
                randVal2 = randGen.nextInt(10);
                break;
            case 2:
                randVal1 = randGen.nextInt(90) + 9;
                randVal2 = randGen.nextInt(90) + 9;
                break;
            case 3:
                randVal1 = randGen.nextInt(900) + 99;
                randVal2 = randGen.nextInt(900) + 99;
                break;
            default:
                randVal1 = randGen.nextInt(9000) + 999;
                randVal2 = randGen.nextInt(9000) + 999;
                break;
        }
        switch (qType) {
            case 1:
                System.out.println("What is " + randVal1 + " plus " + randVal2 + "?");
                trueAns = randVal1 + randVal2;
                break;
            case 2:
                System.out.println("What is " + randVal1 + " times " + randVal2 + "?");
                trueAns = randVal1 * randVal2;
                break;
            case 3:
                System.out.println("What is " + randVal1 + " minus " + randVal2 + "?");
                trueAns = randVal1 - randVal2;
                break;
            default:
                System.out.println("What is " + randVal1 + " divided by " + randVal2 + "?");
                trueAns = randVal1 / randVal2;
                break;

        }


        return trueAns;
    }

    public static void main(String[] args) {
        double userAns = 0;
        double trueAns;
        int difficulty = 0;
        int type = 0;
        int wrongAns = 0;
        int rightAns = 0;
        int tryAgain = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please select difficulty between 1 and 4: with 1 being a single digit and being a 4 digit number");
        difficulty = input.nextInt();
        System.out.println("Please select the type of problem to practice by inputting 1-5: ");
        System.out.println("1 for Addition, 2 for Multiplication, 3 for Subtraction, 4 for Division, 5 for Random.");
        type = input.nextInt();


        while (tryAgain != -1) {
            for (int i = 0; i < 10; i++) {
                trueAns = generateQuestion(difficulty, type);

                userAns = input.nextDouble();
                if (Double.compare(userAns, trueAns) == 0)//replace with an if statement for higher level sections of the code.
                {
                    genPosFeedback();//  System.out.println("No, please try again.");//replace with negative prompt function call
                    rightAns++;
                    // userAns = input.nextDouble();

                } else {
                    genNegFeedback();
                    wrongAns++;
                }

                //System.out.println("Very good!");//replace with positive prompt function call

            }
            System.out.println("Your total is: " + rightAns * 10 + "%");
            if (wrongAns >= 3) {
                System.out.println("Please ask your teacher for help.");
            } else if (rightAns > 7) {
                System.out.println("Congratulations! You are ready to go to the next level!");
            }
            System.out.println("Type 0 to start a new session, -1 to exit");
            tryAgain = input.nextInt();
            wrongAns = 0;
            rightAns = 0;

        }
    }
}



