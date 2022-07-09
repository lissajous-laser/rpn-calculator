package com.lissajouslaser;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StackTest {
   
   @Test
   public void gettingFromInitialStackIsZero() {
      Stack stack = new Stack();
      assertEquals(0, stack.get());
   } 

   @Test
   public void multiplePutsWork() {
      Stack stack = new Stack();
      stack.put(10);
      stack.put(11);
      stack.put(12);
      assertEquals(12, stack.get());
   }

   @Test
   public void wrapsOnAddAtIndexFour() {
      int[] numbers = {4, 5, 6, 7};
      Stack stack = new Stack(numbers, 4);
      stack.put(8);
      assertEquals(8, stack.get());
   }

   @Test
   public void wrapsOnGetAtIndexZero() {
      int[] numbers = {4, 5, 6, 7};
      Stack stack = new Stack(numbers, 0);
      assertEquals(7, stack.get());
   }

   @Test
   public void getFifthConsecutiveTimeIsZero() {
      int[] numbers = {4, 5, 6, 7};
      Stack stack = new Stack(numbers, 0);      
      
      for (int i = 0; i < 4; i++) {
         stack.get();
      }
      assertEquals(0, stack.get());
   }

   @Test
   public void toStringWorks() {
      Stack stack = new Stack();
      
      for (int i = 100; i < 106; i++)
         stack.put(i);
      assertEquals("102 103 104 105", stack.toString());
   }
}
