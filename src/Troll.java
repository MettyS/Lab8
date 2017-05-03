import java.util.ArrayList;

/**
 * Created by Metty on 5/1/17.
 */
public class Troll {

    /**
     * seed for testing purposes to establish the fight lineups
     */
    public static int seed;

    /**
     * list of all the Woolies that will be fighting
     */
    private ArrayList<Woolie> woolies;

    /**
     * the sportscomplex in which the fights will take place
     */
    private SportsComplex sportsComplex;

    /**
     * number representing the round/iteration of battles
     */
    private int roundNum;


    /**
     * Constructs a new Troll
     * @param woolies
     * @param sportsComplex
     */
    public Troll(ArrayList<Woolie> woolies, SportsComplex sportsComplex){
        this.woolies = woolies;
        this.sportsComplex = sportsComplex;
        roundNum = 1;
    }

    /**
     * Returns a random woolie out of the woolies list
     * @return
     */
    private Woolie randomWoolie(){
        int index = (int) Math.random()*woolies.size();
        return woolies.get(index);
    }

    /**
     * Method to run matches until there is a single victor
     */
    public void beginBattleRoyale(){
        //loop while there is more than a single victor woolie
        while(woolies.size()!= 1) {
            //print the information of woolies going into this round
            System.out.println("Round "+ String.valueOf(roundNum)+" is about to begin!");
            System.out.println("The contestants for this round are:");
            for(Woolie w : woolies){
                System.out.println("\t" +w.toString());
            }
            System.out.println();

            ArrayList<WoolieBattleThread> threads = new ArrayList<>();
            ArrayList<Woolie> winners = new ArrayList<>();
            boolean silly = false;
            while (!woolies.isEmpty()) {
                if (woolies.size() > 1) {
                    //get two random woolies and remove them from the list
                    Woolie first = randomWoolie();
                    woolies.remove(first);
                    Woolie second = randomWoolie();
                    woolies.remove(second);

                    //create a new thread with the random two woolies, and try to run it
                    WoolieBattleThread thread = new WoolieBattleThread(first, second, sportsComplex);
                    threads.add(thread);
                    thread.start();

                }
                //if there's an odd woolie, it gets a 'by' for the round
                else {
                    winners.add(woolies.get(0));
                    silly = true;
                }
            }
            //System.out.println("THREADS: "+threads.size());
            //System.out.println("WINNERS: "+winners.size());

            //wait until threads have finished running
            if(silly){
                //System.out.println("SILLY");
                while(winners.size() <= threads.size()){
                    for(WoolieBattleThread t: threads){
                        Woolie w = t.getTheWinner();
                        if(w != null && !winners.contains(w))
                            winners.add(w);
                    }
                }
            }
            else{
                //System.out.println("NOT SILLY");
                while(winners.size() < threads.size()){
                    for(WoolieBattleThread t: threads){
                        Woolie w = t.getTheWinner();
                        if(w != null && !winners.contains(w))
                            winners.add(w);
                    }
                }
            }

            //reset the woolies to be the remaining woolies
            woolies = winners;

            //print out results of the round
            System.out.println("Round "+ String.valueOf(roundNum)+" is now over!");
            System.out.println("The contestants left after this round are:");
            for(Woolie w : woolies){
                //System.out.println("GOES INSIDE THE LOOP BEFORE STATEMENT");
                System.out.println("\t" +w.toString());
                //System.out.println("GOES INSIDE THE LOOP AFTER STATEMENT");
            }
            //System.out.println("GOES AFTER THE LOOP");
            System.out.println();

            if(roundNum > 50)
                break;
            //increment round number
            roundNum++;
        }
    }
}
