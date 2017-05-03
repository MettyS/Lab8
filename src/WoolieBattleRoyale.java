import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Metty on 5/2/17.
 */
public class WoolieBattleRoyale {

    /**
     * unused constructor
     */
    public WoolieBattleRoyale(){}

    /**
     * the main method, runs a full BattleRoyale
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws java.io.IOException{
        //make a file and scanner based off of the input
        Scanner s = new Scanner(new File(args[0]));

        //saves the value of max arenas
        int numArenas = Integer.parseInt(s.next());

        //make a list of woolies and add the woolies to the list
        ArrayList<Woolie> woolies = new ArrayList<>();
        while(s.hasNext()){
            Woolie w = new Woolie(s.next().trim().split(","));
            woolies.add(w);
        }

        //new sportsComplex and troll, and run the game!
        SportsComplex sportsComplex = new SportsComplex(numArenas);
        Troll troll = new Troll(woolies, sportsComplex);
        troll.beginBattleRoyale();
    }
}
