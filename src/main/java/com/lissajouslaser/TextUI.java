package com.lissajouslaser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUI {
   Scanner scanInput;
   Stack stack;

   public TextUI() {
      this(new Scanner(System.in), new Stack());
   }

   public TextUI(Scanner scanInput, Stack stack) {
      this.scanInput = scanInput;
      this.stack = stack;
   }

   public void menu() {
      System.out.println("\nEnter either:");
      System.out.println("-  a number");
      System.out.println("-  an operation (+, -, *, /)");
      System.out.println("-  a number and operation ");
      System.out.println("   (eg. 11+, equivalent to entering 11 then +)");
      System.out.println("- 'q' to quit");
      
      while (true) {
         System.out.println("\n" + stack);
         String input = scanInput.nextLine().trim();

         if (input.equals("q"))
            break;
         inputDispatcher(input);
      }
   }

   void inputDispatcher(String input) {

      if (input.matches("-?\\d+(.\\d+)*")) {
         // Integer input only.
         stack.put(Float.valueOf(input));
      } else if (input.matches("[\\*/\\+-]{1}")) {
         // Operator input only.
         switch (input) {
            case "*":
               stack.mult(); break;
            case "/":
               stack.divi(); break;
            case "+":
               stack.addi(); break;
            case "-":
               stack.subt(); break;
         }
      } else if (input.matches("-?\\d+(.\\d+)*(\\*|/|\\+|-)?")) {
         // Integer and operator input.
         Pattern pattern = Pattern.compile("-?\\d+(.\\d+)*");
         Matcher matcher = pattern.matcher(input);
         float operand = 0;
         if (matcher.find()) 
            operand = Float.valueOf(matcher.group());         
               
         pattern = Pattern.compile("[\\*/\\+-]{1}");
         matcher = pattern.matcher(input);
         String operator = "";
         if (matcher.find())
            operator = matcher.group();

         switch (operator) {
            case "*":
               stack.mult(operand); break;
            case "/":
               stack.divi(operand); break;
            case "+":
               stack.addi(operand); break;
            case "-":
               stack.subt(operand); break;
         } 
      } else if (input.isEmpty()) {
         // Blank input - duplicates last item on
         // the stack.
         float number = stack.get();
         stack.put(number);
         stack.put(number);
      }
      else System.out.println("Invalid input.");     
   }

   Stack getStack() {
      return stack;
   }   
}
