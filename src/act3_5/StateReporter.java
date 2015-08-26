/*
 * StateReporter.java
 *
 * Objects of this class can be run as threads to report on thread states of
 * other threads.
 *
 * The thread state is displayed if it differs from any previously stored.
 *
 * @author M362 Course Team.
 */

package act3_5;

public class StateReporter extends Thread
{
    private Thread myThread;              //report on this thread
    private Thread.State myThreadState;   //last state recorded for this thread

    /** Creates a new instance of StateReporter to report on Thread t*/
    public StateReporter(Thread t, String name)
    {
        myThread = t;
        setName(name);
        myThreadState = myThread.getState();
    }

    //main thread loop polls the state of the designated thread
    public void run()
    {
        System.out.println("Initial observed state of " + getName() + " is " + myThreadState);

        checkConstantly();
    }

    //constantly check and report changes in state
    private void checkConstantly()
    {
        do
        {
            displayThreadState();
        }
        while (!(myThread.getState() == Thread.State.TERMINATED));

        System.out.println(getName() + " ends at " + myThread.getState());
    }


    //report the state of the thread, if it differs from that already stored
    public void displayThreadState()
    {
        Thread.State stateNow = myThread.getState(); //get the current state

        //if state has changed
        if (stateNow != myThreadState)
        {
            myThreadState = stateNow; //new current state
            System.out.println(getName() + " is in state " + myThreadState);
        }
    }
}
