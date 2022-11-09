import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        //while (true) {
            Scanner scanner = new Scanner(System.in);
            boolean inputCondition = false;
            String userInput = scanner.nextLine();
           /** if (userInput.equals("quit")) {
                break;
            } */
            System.out.println(produceAnswer(userInput));
        }
  //  }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
        Scanner scan = new Scanner(System.in);
        // TODO: Implement this function to produce the solution to the input
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals(" ")) {
                count++;
            }
            if (count == 2) {
                input = input.substring(i+1);
            }
        }
        String whole = "0";
        String numerator = "0";
        String denominator = "0";
        int backslashCount = 0;
        int underscoreCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals("_")) {
                whole = input.substring(0,i);
                numerator = input.substring(i+1,input.indexOf("/"));
                denominator = input.substring(input.indexOf("/") + 1);
                underscoreCount++;
                i = input.length() - 1;
            }
            if (input.substring(i,i+1).equals("/")) {
                numerator = input.substring(0,i);
                denominator = input.substring(i+1);
                backslashCount++;
            }
        }
        if (underscoreCount == 0 && backslashCount == 0) {
            whole = input;
            denominator = "1";
    }
        return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
