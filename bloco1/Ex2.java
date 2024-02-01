/**
 * Ex2
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Ex2 {

    public static void main(String[] args) {
        int count = 0;
        double num1 = 0.0, num2 = 0.0;
        String operator = null;
        Map<String,Double> dicMap = new HashMap<String, Double>();

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Usage: <Number> <Operator> <Number>");

        String input = myObj.nextLine();  // Read user input

        if(input.contains("=")){

            String[] data = input.trim().split("=");
            dicMap.put(data[0],Double.parseDouble(data[2]));
            System.out.println("Result: " + data[2]);

        }else{
            String[] data = input.trim().split(" ");
            for(int i = 0; i < data.length; i++){
                if(data[i].matches("[a-zA-Z]"));
            }
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

