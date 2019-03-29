import java.util.*;
import java.io.*;
public class Calculator{

  public static double eval(String s){

      MyDeque<Double> m = new MyDeque<Double>(s.length());
      File f = new File(s);
      Scanner scan = new Scanner(f);
      String operations = "+-?*%";
      double output;
      while (scan.hasNextLine()){
        String str = scan.next();
        if (operations.contains(str)){
          if (str == "+") output = add(Double.parseDouble(m.removeLast()),Double.parseDouble(m.removeLast()));
          if (str == "-") output = subtract(Double.parseDouble(m.removeLast()),Double.parseDouble(m.removeLast()));
          if (str == "/") output = divide(Double.parseDouble(m.removeLast()),Double.parseDouble(m.removeLast()));
          if (str == "*") output = multiply(Double.parseDouble(m.removeLast()),Double.parseDouble(m.removeLast()));
          if (str == "%") output = mod(Double.parseDouble(m.removeLast()),Double.parseDouble(m.removeLast()));
          str = output + "";
        }
        m.addLast(str);
      }


  }

  public static double add(double a, double b){
   return a + b;
  }

  public static double subtract(double a, double b){
    return a - b;
  }

  public static double multiply(double a , double b){
    return a * b;
  }

  public static double divide(double a, double b){
    return a / b;
  }

  public static double mod(double a, double b){
    return a % b;
  }



}
