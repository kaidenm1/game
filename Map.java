import java.util.ArrayList; 
import java.util.Random;

public class Map
{
    private char map[][];
    private Random rand;
    private int x,y,mx,my;
    private boolean outOfBounds;
    private boolean battleSquare;
    private int monsterCount = 0;
    private boolean hiddenMonsters = false;
    private static final char[] coordinates = 
        {'0','1','2','3','4','5','6','7','8','9','0','1','2','3','4','5','6','7','8','9','0'};
    public Map(){
        rand = new Random();
        map = new char[21][21];
        clearMap();
    }
    
    public void clearMap()
    {
        for (int x = 0; x <= 20; x++){
                map[0][x] = (coordinates[x]);
                map[x][0] = (coordinates[x]);
        }
        for (int x = 1; x <= 20; x++){
            for (int y = 1; y <= 20; y++){
                map[x][y] = ' ';                
            }            
        }
    }
    
    public void displayMap(){
        for (int y = 0; y <= 20; y++){
            for (int x = 0; x <= 20; x++){
            if(hiddenMonsters == false){
                System.out.print(map[x][y]);
            }else if(hiddenMonsters == true && map[x][y] == 'M'){
                System.out.print(' ');
            }
                              
            }
            System.out.println();            
        }
    }
    
    public void makeMonsterSprite(){
        do{
            mx = rand.nextInt(20)+1;
            my = rand.nextInt(20)+1;
        }while(map[mx][my] != ' ');
        
        map[mx][my] = 'M';
    }public int getMonsterX(){
        return mx;
    }public int getMonsterY(){
        return my;
    }
    
    public void makeHeroSprite(){
        do{
            x = rand.nextInt(20)+1;
            y = rand.nextInt(20)+1;
        }while(map[x][y] != ' ');
        map[x][y] = 'H';
    }public int getX(){
        return x;
    }public int getY(){
        return y;
    }
    
    public char getSpaceValue(int x, int y){
        return map[x][y];
    }
    
    public void putHeroThere(int x, int y){
        map[x][y] = 'H';
    }
    
    public void moveHeroBack(char _move){
        if(_move == 'w'){
            y += 1;
        }else if(_move == 's'){
            y -= 1;
        }else if(_move == 'a'){
            x += 1;
        }else if(_move == 'd'){
            x -= 1;
        }
        map[x][y] = 'H';
    }
    
    public void moveHero(char _move){
        map[x][y] = ' ';
        if(_move == 'w'){
            y -= 1;
        }else if(_move == 's'){
            y += 1;
        }else if(_move == 'a'){
            x -= 1;
        }else if(_move == 'd'){
            x += 1;
        }
        
        if(map[x][y] == ' '){
            map[x][y] = 'H';
         }else if(map[x][y] == 'M'){
            //map[x][y] = 'M';
        }
        
    }
}