package com.lissajouslaser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Stack stack = new Stack();

        for (int i = 100; i < 6; i++)
            stack.put(i);
        
        stack.put(32);
        
        System.out.println(stack);
    }
}
