/**
 * Created by Metty on 4/27/17.
 */
public class Woolie {

    /**
     * seed for randomizing attack value (testing purposes)
     */
    public static int seed;

    /**
     * name of the Woolie
     */
    private String name;

    /**
     * minimum attack that can be dealt
     */
    private int minAtk;

    /**
     * maximum attack that can be dealt
     */
    private int maxAtk;

    /**
     * time between attacks
     */
    private int hitTime;

    /**
     * the current HP
     */
    private int currHP;

    /**
     * the starting/maximum HP
     */
    private int maxHP;


    /**
     * Constructs a new Woolie
     * @param name
     * @param minAtk
     * @param maxAtk
     * @param hitTime
     * @param maxHP
     */
    public Woolie(String name, int minAtk, int maxAtk, int hitTime, int maxHP){

        this.name = name;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        this.hitTime = hitTime;
        this.maxHP = maxHP;
        this.currHP = maxHP;

    }

    /**
     * Constructs a new Woolie based on the contents of a string
     * @param params
     */
    public Woolie(String[] params){
        this.name = params[0];
        this.minAtk = Integer.parseInt(params[1]);
        this.maxAtk = Integer.parseInt(params[2]);
        this.hitTime = Integer.parseInt(params[3]);
        this.maxHP = Integer.parseInt(params[4]);
        this.currHP = maxHP;
    }

    /**
     * Getter for the name of the Woolie
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Getter for the current HP of the Woolie
     * @return
     */
    public int getCurrentHP(){
        return currHP;
    }

    /**
     * Returns an integer attack amount within the minAtk and maxAtk range
     * @return
     */
    public int getAttackAmount(){
        return minAtk+ (int)Math.floor(Math.random()*((maxAtk -minAtk)+1));
    }

    /**
     * Decreases the Woolie's HP by the damage dealt
     * @param damage
     */
    public void takeDamage(int damage){
        currHP -= damage;
    }

    /**
     * Evaluates and returns if the Woolie is alive
     * @return
     */
    public boolean isOK(){
        return currHP > 0;
    }

    /**
     * Getter for the hitTime field
     * @return
     */
    public int getHitTime(){
        return hitTime;
    }

    /**
     * Resets a Woolie's health
     */
    public void reset(){
        currHP = maxHP;
    }

    /**
     * Method to return a string representing an instance of this class
     * @return
     */
    public String toString(){
        String returned = name+": Max HP "+maxHP+", Min Attack "+minAtk+", Max Attack "+maxAtk+", Hit Time "+hitTime;
        return returned;
    }
}
