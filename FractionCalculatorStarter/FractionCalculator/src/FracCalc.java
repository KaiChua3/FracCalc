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
    public static String firstFrac(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals(" ")) {
                count++;
            }
            if (count == 1) {
                input = input.substring(0,i);
            }
        }
        return input;
    }
    public static String secondFrac(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals(" ")) {
                count++;
            }
            if (count == 2) {
                input = input.substring(i+1);
                i = input.length() - 1;
            }
        }
        return input;
    }
    public static String returnOperator(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals(" ")) {
                count++;
            }
            if (count == 1) {
                input = input.substring(i+1,i+2);
            }
        }
        return input;
    }
    public static String breakFrac(String input) {
        String whole = "0";
        String numerator = "0";
        String denominator = "0";
        int backslashCount = 0;
        int underscoreCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.substring(i,i+1).equals("_")) {
                whole = input.substring(0,input.indexOf("_"));
                numerator = input.substring(input.indexOf("_") + 1,input.indexOf("/"));
                denominator = input.substring(input.indexOf("/") + 1);
                underscoreCount++;
            }
            if (input.substring(i,i+1).equals("/") && underscoreCount == 0) {
                numerator = input.substring(0,i);
                denominator = input.substring(i+1);
                backslashCount++;
            }
        }
        if (underscoreCount == 0 && backslashCount == 0) {
            whole = input;
            denominator = "1";
        }
        if (Integer.parseInt(whole) < 0) {
            numerator = "-" + numerator;
        }

        return whole + "," + numerator  + "," + denominator;
    }
    public static String computeFrac(String input) {
        String returnValue = "";
        String firstWhole;
        String firstNumer;
        String firstDenom;
        String secondWhole;
        String secondNumer;
        String secondDenom;
        String firstFrac = breakFrac(firstFrac(input));
        Scanner scan = new Scanner(firstFrac);
        scan.useDelimiter(",");
        firstWhole = scan.next();
        firstNumer = scan.next();
        firstDenom = scan.next();
        String secondFrac = breakFrac(secondFrac(input));
        scan = new Scanner(secondFrac);
        scan.useDelimiter(",");
        secondWhole = scan.next();
        secondNumer = scan.next();
        secondDenom = scan.next();
        String operator = returnOperator(input);
        firstNumer = Integer.toString(Integer.parseInt(firstNumer) + (Integer.parseInt(firstWhole)*Integer.parseInt(firstDenom)));
        secondNumer = Integer.toString(Integer.parseInt(secondNumer) + (Integer.parseInt(secondWhole)*Integer.parseInt(secondDenom)));

        firstNumer = Integer.toString(Integer.parseInt(firstNumer)*Integer.parseInt(secondDenom));
        secondNumer = Integer.toString(Integer.parseInt(secondNumer)*Integer.parseInt(firstDenom));
        firstDenom = Integer.toString(Integer.parseInt(firstDenom)*Integer.parseInt(secondDenom));
        secondDenom = firstDenom;
        if (operator.equals("+")) {
            returnValue = Integer.toString(Integer.parseInt(firstNumer) + Integer.parseInt(secondNumer));
            returnValue = returnValue  + "/" + firstDenom;
        } else if (operator.equals("-")) {
            returnValue = Integer.toString(Integer.parseInt(firstNumer) - Integer.parseInt(secondNumer));
            returnValue = returnValue  + "/" + firstDenom;
        } else if (operator.equals("*")) {
            returnValue = Integer.toString(Integer.parseInt(firstNumer) * Integer.parseInt(secondNumer));
            firstDenom = Integer.toString(Integer.parseInt(firstDenom) * Integer.parseInt(firstDenom));
            returnValue = returnValue  + "/" + firstDenom;
        } else {
            returnValue = Integer.toString(Integer.parseInt(firstNumer)*Integer.parseInt(secondDenom));
            secondDenom = Integer.toString(Integer.parseInt(secondNumer) * Integer.parseInt(firstDenom));
            returnValue = returnValue + "/" + secondDenom;
        }
        return returnValue;
    }
    public static String reduceFrac(String frac) {
        Scanner input = new Scanner(frac);
        input.useDelimiter("/");
        String numer = input.next();
        String denom = input.next();
        if (Integer.parseInt(numer) % Integer.parseInt(denom) == 0) {
            frac = Integer.toString(Integer.parseInt(numer) / Integer.parseInt(denom));
        }
        if () {

        }
        return frac;
    }
    public static String produceAnswer(String input)
    {
        // TODO: Implement this function to produce the solution to the input
        String returnValue = "";
        returnValue = computeFrac(input);
        return returnValue;

    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
