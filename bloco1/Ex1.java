import java.util.Scanner;


public class Ex1 {

    public static void main(String[] args) {
        int count = 0;
        double num1 = 0.0, num2 = 0.0;
        String operator = null;

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Usage: <Number> <Operator> <Number>");

        String input = myObj.nextLine();  // Read user input

        if(input.split(" ").length == 3){
            String[] data = input.split(" ");
            num1 = Double.parseDouble(data[0]);
            num2 = Double.parseDouble(data[2]);
            operator = data[1];
        }else if(input.split(" ").length == 1){

            while(count < 3){
                switch (count) {
                    case 0:
                        num1 = Double.parseDouble(input);
                        input = myObj.nextLine();
                        break;
                    case 1:
                        operator = input;
                        input = myObj.nextLine();
                        break;
                    case 2:
                        num2 = Double.parseDouble(input);
                        break;
                    default:
                        
                        break;
                }
                count++;
            }
        }else{
            System.err.println("Error!");
            System.exit(1);
        }

        myObj.close();
      
        double valor = calculator(num1, operator, num2);
        System.out.println("Result: " + valor);
    }

    private static double calculator(double num1, String operator, double num2) {
        double result = 0.0;
        System.out.println("Calculator Input: " + num1 + " " + operator + " " + num2);
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = (double)num1 / (double)num2;
                break;
        
            default:
                System.err.println("Invalid Operator");
                System.exit(1);
                break;
        }

        return result;
    }
}

