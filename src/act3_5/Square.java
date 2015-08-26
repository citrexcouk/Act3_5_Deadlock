/*
 * Square.java
 *
 * A class to demonstrate the occurence of deadlock, due to multi-party action.
 * Loosely based on Doug Lea, Concurrent programming in Java, Cell example, p89.
 *
 * Here the method swapColour requires two objects: the invoking object, and the
 * object required in the parameter.
 *
 *
 * Created on 08 December 2006, 18:19. 
 * Revised 1 August 2007
 *
 * @author M362 Course Team.
 */

package act3_5;                 


class Square 					// warning: do not use this class
{
    private String colour;
    
    public Square(String col)
    {
        colour = col;
    }
    
    public synchronized String getColour()
    {
        workABit(50);
        return colour;
    }
    
    private void workABit(long pause)
    {
        long startTime = System.currentTimeMillis();
        long timeLater = System.currentTimeMillis();
        
        while (timeLater - startTime < pause)
        {
            timeLater = System.currentTimeMillis();
        }
    }
    
    private synchronized void setColour(String c)
    {
        colour = c;
    }
    
    public synchronized void swapColour(Square other)
    {
        String c1 = this.getColour();
        String c2 = other.getColour();
        this.setColour(c2);
        other.setColour(c1);
    }
}
