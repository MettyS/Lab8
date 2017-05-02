import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Metty on 5/2/17.
 */
public class WoolieBattleRoyale {

    public WoolieBattleRoyale(){

    }

    public static void main(String[] args)throws java.io.IOException{
        Scanner s = new Scanner(new File(args[0]));
        int numArenas = Integer.parseInt(s.next());
        ArrayList<Woolie> woolies = new ArrayList<>();
        while(s.hasNext()){
            Woolie w = new Woolie(s.next().trim().split(","));
            woolies.add(w);
        }
        SportsComplex sportsComplex = new SportsComplex(numArenas);
        Troll troll = new Troll(woolies, sportsComplex);
        troll.beginBattleRoyale();
    }
}
