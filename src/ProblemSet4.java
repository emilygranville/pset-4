/**
 * Problem Set 4.
 * 
 * It's time to put your skills to the test. This problem set focuses on using
 * iterative control structures. The `main` method is done for you. Lines 30-39
 * trigger each of the predefined methods, which you can think of as self-contained
 * executable pieces of logic. Write your code for each exercise in the
 * corresponding method.
 * 
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Each exercise requires that
 * you ask the user to enter one or more values. Your code must meet the
 * requirements set forth in this section (as well as the *Deliverables* section).
 * 
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

import java.util.Scanner;

public class ProblemSet4 {
    
    private static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        ProblemSet4 ps = new ProblemSet4();
        
        // comment out or uncomment as needed
        
        ps.sum();
        ps.reverse();
        ps.digits();
        ps.average();
        ps.prime();
        ps.fibonacci();
        ps.factors();
        ps.mario();
        ps.luigi();
        ps.credit();
                
        in.close();
    }
    
    /*
     * Exercise 1.
     * 
     * Prompt the user to enter two integers. The first integer is a lower bound, and
     * the second integer is an upper bound.
     * 
     * Compute the sum of all even integers between the lower and upper bounds,
     * including the bounds themselves.
     */
    
    public void sum() {
        int lowerBound = -1;
        int upperBound = 1;
        long total = 0;
        System.out.println("");

        do {
            System.out.print("Lower bound: ");
            lowerBound = in.nextInt();
            in.nextLine();
            System.out.print("Upper bound: ");
            upperBound = in.nextInt();
            in.nextLine();
        } while (upperBound < lowerBound);

        int i = lowerBound;
        while (i <= upperBound) {
            if (i % 2 == 0) {
                total += i;
            }
            i++;
        }
        System.out.printf("\n%,d\n", total);
    }
    
    /*
     * Exercise 2.
     * 
     * Prompt the user to enter a positive integer. Print the digits of this integer
     * in reverse order.
     */
    
    public void reverse() {
        int positiveNumber = 0;
        System.out.println("");
        do {
            System.out.print("Positive integer: ");
            positiveNumber = in.nextInt();
            in.nextLine();
        } while (positiveNumber <= 0);
        
        System.out.println("");
        while (positiveNumber > 0) {
            if (positiveNumber >= 10) {
                System.out.print((positiveNumber % 10) + ", ");
            } else {
                System.out.println((positiveNumber % 10) + ".");
            }
            positiveNumber /= 10;
        }

    }
    
    /*
     * Exercise 3.
     * 
     * Prompt the user to enter a positive integer. Compute the sum of all of the odd
     * digits in the integer.
     */
    
    public void digits() {
        int positiveNumber = 0;
        long total = 0;
        System.out.println("");
        do {
            System.out.print("Positive integer: ");
            positiveNumber = in.nextInt();
            in.nextLine();
        } while (positiveNumber <= 0);

        System.out.println("");
        while (positiveNumber > 0) {
            if (positiveNumber % 2 != 0) {
                total += (positiveNumber % 10);
            }
            positiveNumber /= 10;
        }
        System.out.println(total + ".");
    }
    
    /*
     * Exercise 4.
     * 
     * Prompt the user to enter a series of non-negative integers. When the user
     * enters a negative integer, you can assume he or she is done entering values.
     * What is the average of the values entered?
     */
    
    public void average() {
        int positiveNumber = 0;
        double total = 0;
        int numberCount = 0;
        System.out.println("");
        do {
            System.out.print("Non-negative integer: ");
            positiveNumber = in.nextInt();
            if (positiveNumber >= 0) {
                total += positiveNumber;
                numberCount++;
            }
        } while (positiveNumber >= 0);
        double average = (double) (total/numberCount);
        System.out.printf("\n%,.2f.", average);
        System.out.println("");
    }
    
    /*
     * Exercise 5.
     * 
     * Prompt the user to enter a non-negative integer. Is this number prime?
     */
    
    public void prime() {
        int positiveNumber = 0;
        boolean isPrime = true;
        System.out.println("");
        do {
            System.out.print("Non-negative integer: ");
            positiveNumber = in.nextInt();
        } while (positiveNumber < 0);

        if (positiveNumber == 2 || positiveNumber == 3 || positiveNumber == 5) {
            isPrime = true;
        } else if (positiveNumber <= 1) {
            isPrime = false;
        } else {
            int counter = 0;
            for (int i = 2; i < positiveNumber; i++) {
                if (positiveNumber % i == 0) {
                    counter++;
                }
            }
        
            if (counter == 0) {
                isPrime = true;
            } else {
                isPrime = false;
            }
        }

        if (isPrime) {
            System.out.println("\nPrime.");
        } else {
            System.out.println("\nNot prime.");
        }
    }
    
    /*
     * Exercise 6.
     * 
     * Prompt the user to enter a positive integer in the range [1, 92]. If the
     * integer the user enters is called n, what is the nth Fibonacci number?
     */
    
    public void fibonacci() {
        int positiveNumber = 0;
        System.out.println("");
        do {
            System.out.print("Positive integer: ");
            positiveNumber = in.nextInt();
        } while (positiveNumber < 1 || positiveNumber > 92);
        positiveNumber += 1;
        
        int lowerFibNum = 0;
        int higherFibNum = 1;

        //issue: higher and lower one switches over and over
        for (int i = 0; i < positiveNumber - 1; i++) {
            int placeHolder;
            int firstFibNum = lowerFibNum;
            int secFibNum = higherFibNum;
            
            placeHolder = firstFibNum;
            firstFibNum = secFibNum;
            secFibNum = placeHolder + firstFibNum;
            
            if (firstFibNum > secFibNum) {
                higherFibNum = firstFibNum;
                lowerFibNum = secFibNum;
            } else {
                lowerFibNum = firstFibNum;
                higherFibNum = secFibNum;
            }
        }

        System.out.println("\n" + lowerFibNum + ".");
    }
    
    /*
     * Exercise 7.
     * 
     * Prompt the user to enter a positive integer. What are its factors?
     */
    
    public void factors() {
        int positiveNumber = 0;
        System.out.println("");
        do {
            System.out.print("Positive integer: ");
            positiveNumber = in.nextInt();
        } while (positiveNumber <= 0);

        String message = "";
        for (int i = 1; i < positiveNumber + 1; i++) {
            if (positiveNumber % i == 0) {
                message += i;
                message += ", ";
                int otherFactor = positiveNumber / i;
                message += otherFactor;
                message += ", ";
            }
        }

        message = message.substring(0, ((message.length() - 1) / 2));
        message = message.substring(0, message.length() - 1);
        message += ".";
        System.out.println("\n" + message);
    }
    
    /*
     * Exercise 8.
     * 
     * Prompt the user to enter an integer between 1 and 24 (inclusive). Print a Super
     * Mario-style half-pyramid of the specified height.
     */
    
    public void mario() {
        int height = 0;
        System.out.println("");
        do {
            System.out.print("Height: ");
            height = in.nextInt();
        } while (height < 1 || height > 24);

        String pyramid = "";
        int blockNum = 2;
        height++;

        while (height >= blockNum) {
            pyramid += "\n";
            for (int i = 0; i < height - blockNum; i++) {
                pyramid += " ";
            }
            
            for (int i = 0; i < blockNum; i++) {
                pyramid += "#";
            }
            blockNum++;
        }

        System.out.println(pyramid);
    }
    
    /*
     * Exercise 9.
     * 
     * Prompt the user to enter an odd integer between 1 and 24 (inclusive). Print a
     * Super Mario-style full pyramid of the specified height.
     */
    
    public void luigi() {
        int height = 0;
        System.out.println("");
        do {
            System.out.print("Height: ");
            height = in.nextInt();
        } while (height < 1 || height > 24);

        String pyramid = "";
        int blockNum = 2;
        height++;

        while (height >= blockNum) {
            pyramid += "\n";
            for (int i = 0; i < height - blockNum; i++) {
                pyramid += " ";
            }
            
            for (int i = 0; i < blockNum; i++) {
                pyramid += "#";
            }
            
            pyramid += " ";
            pyramid += " ";

            for (int i = 0; i < blockNum; i++) {
                pyramid += "#";
            }

            blockNum++;
        }

        System.out.println(pyramid);
    }
    
    /*
     * Exercise 10.
     * 
     * Prompt the user to enter a credit card number (not a real one!). According to
     * Luhn's algorithm, is the credit card number valid?
     */
    
    public void credit() {
        System.out.print("\nNumber: ");
        long cardNumber = in.nextLong();
        long cardNumCounter = cardNumber;
        int total = 0;
        int counter = 1;
        while (cardNumCounter > 0) {
            int lastDigit = (int) (cardNumCounter % 10);
            int currentAdded;
            //checks if it is an even point
            if (counter % 2 == 0) {
                /* checks if the multiplication is greater than 10
                 * and if so it adds the digits seperately
                 */
                if((lastDigit * 2) >= 10) {
                    currentAdded = ((lastDigit * 2) % 10);
                    currentAdded += ((lastDigit * 2) / 10);
                } else {
                    currentAdded = (lastDigit * 2);
                }
            } else {
                currentAdded = lastDigit;
            }
            total += currentAdded;
            counter++;
            cardNumCounter /= 10;
        }

        String bankType = "";

        String cardNumTester = String.valueOf(cardNumber);
        String firstTwoNum = cardNumTester.substring(0, 2);
        if (total % 10 == 0) {
            if (firstTwoNum.equals("34") || firstTwoNum.equals("37")) {
                if (cardNumTester.length() == 15) {
                    bankType = "Amex.";
                }
            } else if (firstTwoNum.equals("51") || firstTwoNum.equals("52") || firstTwoNum.equals("53")
            || firstTwoNum.equals("54") || firstTwoNum.equals("55")) {
                if (cardNumTester.length() == 16) {
                    bankType = "Mastercard.";
                }
            } else if (cardNumTester.substring(0, 1).equals("4")) {
                if (cardNumTester.length() == 16 || cardNumTester.length() == 13) {
                    bankType = "Visa.";
                }
            }
        }

        if (bankType.equals("")) {
            bankType = "Invalid.";
        }

        System.out.println("\n" + bankType);
    }
}