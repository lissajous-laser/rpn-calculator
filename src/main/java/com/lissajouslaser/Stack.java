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
      // enable pointer to wrap around array
      if (pointer == numbers.length) {
         pointer = 0;
      }
      if (pointer < 0) {
         pointer = numbers.length - 1;
      }
   }

   @Override
   public String toString() {
      // displays array from earliest to most recent numbers
      String acc = "";
      int iter = pointer;

      for (int i = 0; i < numbers.length; i++) {
         if (iter == numbers.length)
            iter = 0;
         acc = acc + numbers[iter] + " ";
         iter++;
      }
      return acc.trim();
   }



   // private int addi() { TODO

   // } 
}
