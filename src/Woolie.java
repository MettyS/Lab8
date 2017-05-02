/**
 * Created by Metty on 4/27/17.
 */
public class Woolie {

    public static int seed;
    private String name;
    private int minAtk;
    private int maxAtk;
    private int hitTime;
    private int currHP;
    private int maxHP;

    public Woolie(String name,
                  int minAtk,
                  int maxAtk,
                  int hitTime,
                  int maxHP){
        this.name = name;
        this.minAtk = minAtk;
        this.maxAtk = maxAtk;
        this.hitTime = hitTime;
        this.maxHP = maxHP;
        this.currHP = maxHP;

    }

    public Woolie(String[] params){

    }

    public String getName(){
        return name;
    }

    public int getCurrentHP(){
        return currHP;
    }

    public int getAttackAmount(){
        return (int)Math.floor(Math.random()*((maxAtk -minAtk)+1));
    }

    public void takeDamage(int damage){
        currHP -= damage;
    }

    public boolean isOK(){
        return currHP > 0;
    }

    public int getHitTime(){
        return hitTime;
    }

    public void reset(){
        currHP = maxHP;
    }

    public String toString(){
        String returned = "";

        return returned;
    }
}
