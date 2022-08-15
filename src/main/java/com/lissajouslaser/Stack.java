package com.lissajouslaser;

// First-in last-out buffer that wraps around backing array.
public class Stack {
   private static final int stackSize = 4;
   private float[] numbers; // The stack.
   private int pointer;

   public Stack() {
      this(new float[stackSize], 0);
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
      float temp = numbers[pointer];
      // Overwrites index with 0, which becomes the
      // oldest entry. Popping all values off the stack
      // will zero out the stack.
      numbers[pointer] = 0;
      return temp;
   }

   /**
    * Wraps the pointer index if it is out of bounds of
    * the backing array.
    */
   private void pointerWrap() {
      if (pointer == -1 || pointer == numbers.length) {
         pointer = Math.floorMod(pointer, numbers.length);
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
         
         // If number is a whole number, don't print decimal
         // places.
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
