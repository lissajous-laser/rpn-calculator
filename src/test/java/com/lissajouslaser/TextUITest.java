package com.lissajouslaser;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TextUITest {
   
   @Test
   public void numberEntriesArePutIntoStack() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("6");
      textUI.inputDispatcher("4");
      textUI.inputDispatcher("2");
      textUI.inputDispatcher("-2");     
      assertEquals("-2  2  4  6", textUI.getNumStack().toString());
   }

   @Test
   public void doesNotAllowDivideByZero() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("7");
      textUI.inputDispatcher("0/");
      assertEquals("7  0  0  0", textUI.getNumStack().toString());
   }

   @Test
   public void subractionWorks1() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("7");
      textUI.inputDispatcher("4-");
      assertEquals("3  0  0  0", textUI.getNumStack().toString());      
   }

   @Test
   public void subractionWorks2() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("7");
      textUI.inputDispatcher("4");
      textUI.inputDispatcher("-");
      assertEquals("3  0  0  0", textUI.getNumStack().toString());      
   }

   @Test
   public void additionWorks1() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("7");
      textUI.inputDispatcher("4+");
      assertEquals("11  0  0  0", textUI.getNumStack().toString());      
   }

   @Test
   public void additionWorks2() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("7");
      textUI.inputDispatcher("4");
      textUI.inputDispatcher("+");
      assertEquals("11  0  0  0", textUI.getNumStack().toString());      
   }
      @Test
   public void multiplicationWorks1() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("7");
      textUI.inputDispatcher("4*");
      assertEquals("28  0  0  0", textUI.getNumStack().toString());      
   }

   @Test
   public void multiplicationWorks2() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("7");
      textUI.inputDispatcher("4");
      textUI.inputDispatcher("*");
      assertEquals("28  0  0  0", textUI.getNumStack().toString());      
   }
      @Test
   public void divisionWorks1() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("100");
      textUI.inputDispatcher("3/");
      assertEquals("33  0  0  0", textUI.getNumStack().toString());      
   }

   @Test
   public void divisionWorks2() {
      TextUI textUI = new TextUI();
      textUI.inputDispatcher("100");
      textUI.inputDispatcher("3");
      textUI.inputDispatcher("/");
      assertEquals("33  0  0  0", textUI.getNumStack().toString());      
   }   
}
