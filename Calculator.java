import java.util.*;
import java.io.*;
public class Calculator{

  public static double eval(String s){

      MyDeque<String> calculator = new MyDeque<String>();
      Scanner scan = new Scanner(s);
      String operations = "+-?*%";
      double output;
      while (scan.hasNextLine()){
        String str = scan.next();
        if (operations.contains(str)){
          output = performMath(Double.parseDouble(calculator.removeLast()), Double.parseDouble(calculator.removeLast()), str);
          str = output + "";
        }
        calculator.addLast(str);
      }
      return Double.parseDouble(calculator.getLast());
  }

  private static double performMath(double a, double b, String operation){
    if(operation.equals("+")) return b + a;
    else if(operation.equals("-")) return b - a;
    else if(operation.equals("*")) return b * a;
    else if(operation.equals("/")) return b / a;
    else if(operation.equals("%")) return b % a;
    return 0.0;
  }



}
