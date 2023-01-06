public class Hero
{
    private String name;
    private String type;//Humans, Elves, Dwarves
    private int health = 20, strength = 20, mana = 20, gold = 0;



    /**
     * Constructor for objects of class Monster
     */
    public Hero(String _name, String _type)
    {
        setName(_name);
        setType(_type);
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
    
    public void setHealthDefault(){
        health = 20;
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
    
    public int getGold()
    {
        return gold;
    }
}