package com.lissajouslaser;


// first-in last-out circular buffer for size 4
public class Stack {
   private int[] numbers;
   int pointer;

   public Stack() {
      this(new int[4], 0);
   }
   public Stack(int[] numbers, int pointer) {
      this.numbers = numbers;
      this.pointer = pointer;
   }

   public void put(int number) {
      pointerWrap();
      numbers[pointer++] = number;
   }

   public int get() {
      pointer--;
      pointerWrap();     
         int holder = numbers[pointer];
         // overwrite read index with 0 
         numbers[pointer] = 0;
         return holder;
   }

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
      // display array items from most recent to earliest
      String acc = "";
      int localPointer = pointer;

      for (int i = 0; i < numbers.length; i++) {
         if (localPointer == numbers.length)
            localPointer = 0;
         acc =  "  " + numbers[localPointer] + acc;
         localPointer++;
      }
      return acc.trim();
   }

   public void addi(int operand) {
      put(get() + operand);
   }
   public void addi() {
      put(get() + get());
   }

   public void subt(int operand) {
      put(get() - operand);
   }
   public void subt() {
      int subtractor = get();
      put(get() - subtractor);
   }

   public void mult(int operand) {
      put(get() * operand);
   }
   public void mult() {
      put(get() * get());
   }

   public void divi(int operand) {
      if (operand == 0) 
         System.out.println("Division by zero invalid");
      else put(get() / operand);
   }
   public void divi() {
      int divisor = get();
      if (divisor == 0) {
         System.out.println("Division by zero invalid");
         put(divisor);
      }   
      else put(get() / divisor);
   }
}
