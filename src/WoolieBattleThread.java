/**
 * Created by Metty on 5/2/17.
 */
public class WoolieBattleThread extends Thread {

    /**
     * the first Woolie fighter
     */
    private Woolie fighter1;

    /**
     * the second Woolie fighter
     */
    private Woolie fighter2;

    /**
     * the sportscomplex in which the arena is that the fight is taking place in
     */
    private SportsComplex sportsComplex;

    /**
     * Construct a new WoolieBattleThread
     * @param fighter1
     * @param fighter2
     * @param sportsComplex
     */
    public WoolieBattleThread(Woolie fighter1, Woolie fighter2, SportsComplex sportsComplex){
        this.fighter1 = fighter1;
        this.fighter2 = fighter2;
        this.sportsComplex = sportsComplex;
    }

    /**
     * Getter for the fighter1 Woolie
     * @return
     */
    public Woolie getFighter1(){
        return fighter1;
    }

    /**
     * Getter for the fighter2 Woolie
     * @return
     */
    public Woolie getFighter2(){
        return fighter2;
    }

    /**
     * Method to run the actions of this thread
     */
    public void run(){
        System.out.println("WOOLIES: "+fighter1.getName()+" and "+fighter2.getName()+" enterArena line to battle");
        enterArena();
        int time = 0;

        System.out.println("WOOLIES: "+fighter1.getName()+" and "+fighter2.getName()+" enterArena arena to battle");
        System.out.println("The battle has begun between "+fighter1.getName()+" and "+fighter2.getName());

        while(getWinner() == null){

            //sleep the thread for a second to make it realistic to the writeup
            try {
                this.sleep(1000);
                time++;
            }
            //catch the exception if the sleep is interrupted
            catch(InterruptedException i){

            }

            //evaluate who's turn it is and deal damage
            if(time % fighter1.getHitTime() == 0){
                int dmg = fighter1.getAttackAmount();
                System.out.println(fighter1.getName()+" does "+ String.valueOf(dmg)+" damage to "+fighter2.getName());
                fighter2.takeDamage(dmg);
                System.out.println(fighter2.getName()+" has "+fighter2.getCurrentHP()+ " HP left");
            }
            else if(time % fighter2.getHitTime() == 0){
                int dmg = fighter2.getAttackAmount();
                System.out.println(fighter2.getName()+" does "+ String.valueOf(dmg)+" damage to "+fighter1.getName());
                fighter1.takeDamage(dmg);
                System.out.println(fighter1.getName()+" has "+fighter1.getCurrentHP()+ " HP left");
            }
            System.out.println();
        }
        System.out.println("The results are in!");
        System.out.println(getWinner().getName()+" has won!");
        exitArena();
    }

    /**
     * Getter for the winner of the match
     * @return
     */
    public Woolie getWinner(){
        if(fighter1.getCurrentHP() == 0)
            return fighter2;
        else if(fighter2.getCurrentHP() == 0)
            return fighter1;
        else
            return null;
    }

    /**
     * Call to sportsComplex to enter an arena
     */
    public void enterArena(){
        sportsComplex.enterArena(this);
    }

    /**
     * Call to sportsComplex to exit the arena
     */
    public void exitArena(){
        sportsComplex.leaveArena();
    }
}
