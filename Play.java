import java.util.Random;
import java.util.ArrayList;

/**
* Write a description of class Battle here.
*
* @author (your name)
* @version (a version number or a date)
*/
public class Play
{
    // instance variables - replace the example below with your own
    private Map myMap;
    private Monster myMonster;
    private Hero myHero;
    private Input myInput;
    private Random rand;
    private ArrayList<Monster> monsterList = new ArrayList<Monster>();
    private int x, y;
    private int monsterIndice;

    /**
     * Constructor for objects of class Battle
     */
    public Play()
    {
        System.out.print('\f');
        myInput = new Input();
        fancyPrint("Welcome to the dungeon!\n");
        fancyPrint("Enter your name: ");
        String name = myInput.getString();
        fancyPrint("Enter your race: ");
        String type = myInput.getString();
        myHero = new Hero(name,type);
        fancyPrint("\nGood luck...");
        try{
            Thread.sleep(2500);
        }catch(InterruptedException e){}
        System.out.print('\f');
        myMap = new Map();
        playGame();
    }
    
    
    public void fancyPrint(Object obj){
        String s;
        if (obj instanceof String) {
          s = (String) obj;
        } else if (obj instanceof Integer) {
          s = obj.toString();
        } else {
          throw new IllegalArgumentException("obj must be a String or an Integer");
        }
        for (char c : s.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }
    
    public void makeNewMonster(int x,int y){
        monsterList.add(new Monster(x,y));
    }
    
    public void checkWhichMonster(int x,int y){
        for(int i = 0; i < monsterList.size(); i++){
            myMonster = monsterList.get(i);
            if(x == myMonster.getX() && y == myMonster.getY()){
                monsterIndice = i;
                break;
            }
        }
    }
    
    public void battleIntro(int hp, int mhp, int gold, int mGold, int hStr, int mStr, int mana, int mMana){
        System.out.println(myMonster.getName()+" the "+myMonster.getType()+" has appeared!");
        System.out.println("\nHealth: "+mhp);
        System.out.println("Strength: "+mStr);
        System.out.println("Mana: "+mMana);
        System.out.println("\n"+myHero.getName()+"the"+myHero.getType()+"'s stats:");
        System.out.println("Health: "+hp);
        System.out.println("Strength: "+hStr);
        System.out.println("Mana: "+mMana);
        System.out.println("Player's Gold: "+gold);
    }
    
    public void fight(char fight, int mStr, int hStr, int hp, int mhp){
        while (fight == 'y' && !(hp <= 0 || mhp <= 0)){
            int hitp,mStrike,hStrike;
            mStrike = rand.nextInt(mStr)+1;
            hStrike = rand.nextInt(hStr)+1;
            hitp = Math.abs(mStrike - hStrike);
            if (mStrike > hStrike){
                System.out.println("Monster hits you. You take "+hitp+" damage.");
                hp -= hitp;
            } else if (hStrike > mStrike){
                System.out.println("You smite the monster! It takes "+hitp+" damage.");
                mhp -= hitp;
            } else{
                System.out.println("You deflected the monster's strike.");
            }
            System.out.println();
            System.out.println("Monster's health: "+mhp);
            System.out.println("Player's Health: "+hp);
            if(!(hp <= 0 || mhp <= 0)){    
                System.out.print("\nDo you want to continue the fight? (y/n): ");
                fight = myInput.getChar();
                System.out.println();
            }
        }  
    }
    public void battle(){
        rand = new Random();
        boolean respawn, monsterDead, ran;
        int hp,mhp,gold,mGold,hStr,mStr,mana,mMana;
        hp = myHero.getHealth();
        gold = myHero.getGold();
        mhp = myMonster.getHealth();
        hStr = myHero.getStrength();
        mStr = myMonster.getStrength();
        mMana = myMonster.getMana();
        mGold = myMonster.getGold();
        battleIntro(hp,mhp,gold,mGold,hStr,mStr,mana,mMana);
        System.out.print("\nDo you wish to fight? (y/n): ");
        char fight = myInput.getChar();
        System.out.println();
        while (fight == 'y' && !(hp <= 0 || mhp <= 0)){
            int hitp,mStrike,hStrike;
            mStrike = rand.nextInt(mStr)+1;
            hStrike = rand.nextInt(myHero.getStrength())+1;
            hitp = Math.abs(mStrike - hStrike);
            if (mStrike > hStrike){
                System.out.println("Monster hits you. You take "+hitp+" damage.");
                hp -= hitp;
            } else if (hStrike > mStrike){
                System.out.println("You smite the monster! It takes "+hitp+" damage.");
                mhp -= hitp;
            } else{
                System.out.println("You deflected the monster's strike.");
            }
            System.out.println();
            System.out.println("Monster's health: "+mhp);
            System.out.println("Player's Health: "+hp);
            if(!(hp <= 0 || mhp <= 0)){    
                System.out.print("\nDo you want to continue the fight? (y/n): ");
                fight = myInput.getChar();
                System.out.println();
            }
        }  
        
        if (mhp <= 0){
            System.out.println("\nYou have slain the monster!");
            System.out.println("You have gained "+mGold+" gold!");
            monsterList.remove(monsterIndice);
            gold += mGold;
            myHero.setGold(gold);
            myHero.setHealth(hp);
            System.out.println("\nPlayer's Health = "+hp);
            System.out.println("Player's Gold   = "+gold);
            myMap.putHeroThere(x,y);
        }else if(hp <= 0){
            System.out.print("\nYou have died. Would you like to respawn? (y/n): ");
            char respawnInput = myInput.getChar();
            if (respawnInput == 'y'){
                myMonster.setHealth(mhp);
                myMonster.setStrength(mStr);
                myMonster.addGold(gold);
                monsterList.set(monsterIndice,myMonster);
                myHero.setGold(0);
                myHero.setHealthDefault();
                System.out.println("\nAll of your health has been regenerated.");
                System.out.println("You have lost all your gold to the monster.");
                myMap.makeHeroSprite();
                x = myMap.getX();
                y = myMap.getY();
            }else{
                System.out.println("You have been slain.");
                System.out.println("\nGame Over");
                System.exit(0);
            }
        }else if(fight == 'n'){
            myHero.setHealth(hp);
            myMonster.setHealth(mhp);
            myMonster.setStrength(mStr);
            myMonster.addGold(gold);
            monsterList.set(monsterIndice,myMonster);
            myMap.moveHeroBack(move);
        }
        System.out.println();
    }
    
    public char checkMove(char move,int x,int y){
        while(!(move == 'a' || move == 'w' || move == 's' || move == 'd') || 
        (move == 'a' && x == 1) || (move == 'w' && y == 1) || (move == 's' && y == 20) || (move == 'd' && x == 20)){
            //System.out.print('\r');
            System.out.println("Bad Input!");
            System.out.print("Which way would you like to move? (w,a,s,d) ");
            move = myInput.getChar();
        }
        return move;
    }
    
    public void playGame(){
        myMap.clearMap();
        for(int i = 0; i < 3; i++){
            myMap.makeMonsterSprite();
            makeNewMonster(myMap.getMonsterX(),myMap.getMonsterY());
        }
        myMap.makeHeroSprite();
        x = myMap.getX();
        y = myMap.getY();
        myMap.displayMap();
        char move;
        do{
            System.out.print("Which way would you like to move? (w,a,s,d) ");
            move = myInput.getChar();
            move = checkMove(move,x,y);
            System.out.print('\f');
            myMap.moveHero(move);
            x = myMap.getX();
            y = myMap.getY();
            if(myMap.getSpaceValue(x,y) == 'M'){
                checkWhichMonster(x,y);
                battle(move);
            }  
            myMap.displayMap();
            
        }while(true);
    }
}