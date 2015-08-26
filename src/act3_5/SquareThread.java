/*
 * SquareThread.java
 *
 * A Thread class with run method to get two squares to swap colours by invoking the method swapColour.
 *
 *
 * Created on 08 December 2006, 18:27
 * Revised 1 August 2007.
 *
 * @author M362 Course Team.
 */

package act3_5;

public class SquareThread extends Thread
{
    private Square squareA;
    private Square squareB;
    
    public SquareThread(Square c1, Square c2)
    {
        squareA = c1;
        squareB = c2;
        
       System.out.println(getName() + " colours are  " + squareA.getColour() + " " + squareB.getColour());
    }
    
    public void run()
    {         
        squareA.swapColour(squareB);
        System.out.println(getName() + " after swap = " + squareA.getColour());
    }
}
