import java.util.ArrayList;

/**
 * Created by Metty on 5/2/17.
 */
public class SportsComplex {

    /**
     * the maximum number of arenas
     */
    private int maxInUse;

    /**
     * the number of arenas being used
     */
    private int inUse;

    /**
     * a list of waiting threads
     */
    private ArrayList<WoolieBattleThread> threadsToRun;


    /**
     * Construct a new SportsComplex
     * @param maxInUse
     */
    public SportsComplex(int maxInUse){
        this.maxInUse = maxInUse;
        inUse = 0;
        threadsToRun = new ArrayList<>();
    }

    /**
     * Method to allow a thread to hold a battle in an 'arena'
     * @param t
     */
    public void enterArena(WoolieBattleThread t){
        //if there are still empty arenas, allow the thread to run
        if(inUse < maxInUse){
            inUse++;
            //t.run();
        }
        //if there are no open arenas, set the thread to wait and add it to the list of waiting threads
        else{
            threadsToRun.add(t);
            synchronized(t){
                try {
                    t.wait();
                }
                catch(InterruptedException i){}
            }
        }
    }

    /**
     * Pulls a thread 'out of an arena', opening up an arena
     */
    public void leaveArena(){
        //if there are no waiting threads, increase the number of open arenas
        if(threadsToRun.isEmpty()){
            inUse--;
        }
        //if there are waiting threads, don't change the number of open arenas, and notify the first waiting arena
        else{
            WoolieBattleThread t = threadsToRun.remove(0);
            synchronized (t){
                t.notify();
            }
        }
    }

    public ArrayList<WoolieBattleThread> getThreadsToRun(){
        return threadsToRun;
    }
}
