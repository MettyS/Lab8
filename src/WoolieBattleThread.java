/**
 * Created by Metty on 5/2/17.
 */
public class WoolieBattleThread extends Thread {

    private Woolie fighter1;
    private Woolie fighter2;
    private SportsComplex sportsComplex;

    public WoolieBattleThread(Woolie fighter1, Woolie fighter2, SportsComplex sportsComplex){
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.sportsComplex = sportsComplex;
    }

    public Woolie getFighter1(){
        return fighter1;
    }

    public Woolie getFighter2(){
        return fighter2;
    }

    public void run(){

    }

    public Woolie getWinner(){
        if(fighter1.getCurrentHP() == 0)
            return fighter2;
        else if(fighter2.getCurrentHP() == 0)
            return fighter1;
        else
            return null;
    }

    public void enterArena(){

    }

    public void exitArena(){

    }
}
