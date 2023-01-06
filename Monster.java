import java.util.Random;
/**
 * You will need to create set and get methods for 
 * all basic information.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Monster
{
    // instance variables - replace the example below with your own
    private Random randNum;
    private String name;
    private String type;//Vampire, Orc, Goblin
    private int health, strength, mana, gold = 0;
    private int x,y;
    
    private static String nameList[] = {"Kill Gore", "Blood Hunter", "Glom"};
    private static String typeList[] = {"Orc", "Goblin", "Gorn"};

    /**
     * Constructor for objects of class Monster
     */
    public Monster(int x, int y)
    {
        randNum = new Random();
        create();
        this.x = x;
        this.y = y;
    }
    
    public void create()
    {
        gold = 0;
        int num = randNum.nextInt(3); 
        String temp = nameList[num];
        setName(temp);
        temp = typeList[num];
        setType(temp);
        num = randNum.nextInt(20)+1; 
        setHealth(num);
        num = randNum.nextInt(15)+10; 
        setStrength(num);
        num = randNum.nextInt(5)+10; 
        setMana(num);
        num = randNum.nextInt(20)+1;
        setGold(num);
    }
    
    public void setCoords(int x, int y){
       this.x = x;
       this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setName(String _name)
    {
        name = _name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setType(String _type)
    {
        type = _type;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setHealth(int _health)
    {
        health = _health;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setStrength(int _strength)
    {
        strength = _strength;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public void setMana(int _mana)
    {
        mana = _mana;
    }
    
    public int getMana()
    {
        return mana;
    }
    
    public void setGold(int _gold)
    {
        gold = _gold;
    }
    
    public void addGold(int _gold)
    {
        gold += _gold;
    }
    
    public int getGold()
    {
        return gold;
    }
    

}
