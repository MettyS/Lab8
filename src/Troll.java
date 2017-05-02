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
     * Constructs a new Troll
     * @param woolies
     * @param sportsComplex
     */
    public Troll(ArrayList<Woolie> woolies, SportsComplex sportsComplex){
        this.woolies = woolies;
        this.sportsComplex = sportsComplex;
    }


    public void beginBattleRoyale(){

    }
}
