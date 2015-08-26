/*
 * Main.java
 *
 * A class to set up a scenario to demonstratre deadlock. 
 * Creates two Square objects, and sets threads running in such a way that both squares 
 * try to swap colours with each other. 
 *
 * Created 22/12/2006
 *
 * @author M362 Course Team.
 */

package act3_5;


public class Main 
{ 
    public static void main(String[] args)    
    {
       Square squareRed = new Square("red");
       Square squareGreen = new Square("green");
       
       SquareThread t1 = new SquareThread(squareRed, squareGreen);
       SquareThread t2 = new SquareThread(squareGreen, squareRed);
         
       StateReporter r1 = new StateReporter(t1,"t1");
       StateReporter r2 = new StateReporter(t2,"t2");
       
       r1.start();
       r2.start();
       
       t1.start();       
       t2.start();    
    }
}
