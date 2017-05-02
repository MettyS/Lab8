import java.util.ArrayList;

/**
 * Created by Metty on 5/2/17.
 */
public class SportsComplex {

    private int maxInUse;
    private int inUse;
    private ArrayList<WoolieBattleThread> threadsToRun;

    public SportsComplex(int maxInUse){
        this.maxInUse = maxInUse;
        inUse = 0;
        threadsToRun = new ArrayList<>();
    }

    public void enterArena(WoolieBattleThread t){
        if(inUse < maxInUse){
            inUse++;
            t.run();
        }
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

    public void leaveArena(){
        if(threadsToRun.isEmpty()){
            inUse--;
        }
        else{
            WoolieBattleThread t = threadsToRun.remove(0);
            synchronized (t){
                t.notify();
            }
        }
    }
}
