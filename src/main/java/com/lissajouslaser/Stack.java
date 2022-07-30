package com.lissajouslaser;

// First-in last-out buffer that wraps around.
public class Stack {
   private float[] numbers;
   int pointer;

   public Stack() {
      this(new float[4], 0);
   }

   public Stack(float[] numbers, int pointer) {
      this.numbers = numbers;
      this.pointer = pointer;
   }

   /**
    * Inserts number into the stack. If stack is full,
    * overwrite the oldest entry in the stack.
    */
   public void put(float number) {
      pointerWrap();
      numbers[pointer++] = number;
   }

   /**
    * Removes and returns most recent number from the
    * stack. 
    */
   public float get() {
      pointer--;
      pointerWrap();
      float holder = numbers[pointer];
      // overwrite read index with 0
      numbers[pointer] = 0;
      return holder;
   }

   /**
    * Wraps the pointer index if it is out of bounds of
    * the stack.
    */
   private void pointerWrap() {
      // allow pointer to wrap around array
      if (pointer == numbers.length) {
         pointer = 0;
      }
      if (pointer < 0) {
         pointer = numbers.length - 1;
      }
   }

   @Override
   public String toString() {
      // Display array items from most recent to earliest.
      String result = "";
      int localPointer = pointer;

      for (int i = 0; i < numbers.length; i++) {
         if (localPointer == numbers.length)
            localPointer = 0;
         
         // If number is a whole number, don't print decimals.
         float number = numbers[localPointer];
         int numberAsInt = (int) number;
         if (number == numberAsInt) {
            result = "  " + numberAsInt + result;
         } else {
            result = "  " + number + result;
         }
         localPointer++;
      }
      return result.trim();
   }

   public void addi(float operand) {
      put(get() + operand);
   }

   public void addi() {
      put(get() + get());
   }

   public void subt(float operand) {
      put(get() - operand);
   }

   public void subt() {
      float subtractor = get();
      put(get() - subtractor);
   }

   public void mult(float operand) {
      put(get() * operand);
   }

   public void mult() {
      put(get() * get());
   }

   public void divi(float operand) {
      if (operand == 0)
         System.out.println("Division by zero invalid");
      else
         put(get() / operand);
   }

   public void divi() {
      float divisor = get();
      if (divisor == 0) {
         System.out.println("Division by zero invalid");
         put(divisor);
      } else
         put(get() / divisor);
   }
}
