/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Battle class hosts the battles that happens between Charas. 
 * @author Diogn Lei R. Mortera // Edits by Krixian Skye D. Del Rosario
 */
public class Battle { //include a battle number thing here too ueueuuuueuueueu
    private String name;
    private Protag protag;
    private Chara ally1;
    private Chara ally2;
    private Chara enemy1;
    private Chara enemy2;
    private Chara enemy3;
    private static int battleNum;
    private int turn;
    private int iterationCount;
    private String textureStr;
    
    private static ArrayList<Chara> CharaList = new ArrayList<Chara>();
    public static ArrayList<Battle> BattleList = new ArrayList<Battle>();
    
    /**
     * A Battle instance has a name and the six Charas participating (1 protagonist, 1-2 allies, 2-3 enemies). A Battle instance is also automatically added to an ArrayList containing all Battles.
     * @param n the name of the Battle instance
     * @param p the protagonist in the battle
     * @param a1 the 1st ally participating in the battle
     * @param a2 the 2nd ally participating in the battle
     * @param e1 the 1st enemy participating in the Battle
     * @param e2 the 2nd enemy participating in the Battle
     * @param e3 the 3rd enemy participating in the Battle
     * @param tS the texture String of the battle
     */
    public Battle(String n, Protag p, Chara a1, Chara a2, Chara e1, Chara e2, Chara e3, String tS){
        name = n;
        protag = p;
        ally1 = a1;
        ally2 = a2;
        enemy1 = e1;
        enemy2 = e2;
        enemy3 = e3;
        textureStr = tS;
        
        CharaList.add(p);
        CharaList.add(a1);
        CharaList.add(a2);
        CharaList.add(e1);
        CharaList.add(e2);
        CharaList.add(e3);
        
        BattleList.add(this);
    }
    
    /**
     * Hosts the battle between the 2-6 Charas.
     */
    public void battle(){
        //Mechanics:
       
        Chara[] AllyList = {protag, ally1, ally2}; 
        Chara[] EnemyList = {enemy1, enemy2, enemy3};
        int noOfAllies = 0;
        int noOfEnemies = 0;
        
        for(Chara a : AllyList){
            if(a != null){
                noOfAllies++;
            }
        }
        
        for(Chara e : AllyList){
            if(e != null){
                noOfEnemies++;
            }
        }
        
        boolean battleProceed = true;
        int noOfTurns = 0;
        int noOfTurnsAlly = 0;
        int noOfTurnsEnemy = 0;
        
        while(battleProceed){
            
            checkDeath();
            
            if(noOfTurns % 2 == 0){
                //ally's turns
                //1) Ally side battle sequencing: protag, ally1, ally2
                if(noOfTurnsAlly % noOfAllies == 0){
                    //protag attack sequence
                }else{
                    
                    //normal chara-enemy sequence
                    Random random = new Random();
                    AllyList[noOfTurnsAlly % noOfAllies].attack(EnemyList[random.nextInt(noOfEnemies)]); //while loop to check for nulls in the randomization
                }
                noOfTurnsAlly++;
                noOfTurns++;
            } else if(noOfTurns % 2 == 1){
                //enemy's turns
                //2) Battle side battle sequencing: enemy1 -> random ally, enemy2 -> random ally, enemy3 -> random ally            Random
                Random random = new Random();
                EnemyList[noOfTurnsEnemy % noOfEnemies].attack(AllyList[random.nextInt(noOfAllies)]); //while loop to check for nulls in the randomization
                noOfTurnsEnemy++;
                noOfTurns++;
            }
            
        }
        //Attacks:
        //1) Can attack with attack buff
        
        //Additional features:
        //1) "Confirm" button for attacks (clicking mechanic: click enemy sprite -> display dialog box making user confirm) VIEW
        //2) "Open inventory" and click on an item -> when item is a TempAttChangerItem -- display options in the side allowing player to "Use Item" (only allowed when player is previously in a BattleLayout) VIEW       
        
    }
    
    /**
     * Gets the Battle Number of the Battle instance.
     * @return battleNum
     */
    public static int getBattleNum(){
        return battleNum;
    }
    
    public static void setBattleNum(int i){
        battleNum = i;
    }
    
    /**
     * Gets the Battle List of the Battle instance.
     * @return BattleList
     */
    public static ArrayList<Battle> getBattleList(){
        return BattleList;
    }
    
    /**
     * Gets the Protagonist in the Battle instance.
     * @return protag
     */
    public Protag getProtag(){
        return protag;
    }
    
    /**
     * Gets the Ally that corresponds to the number from the Battle instance.
     * @param a number of the ally
     * @return ally1, ally2, or null
     */
    public Chara getAlly(int a){
        switch(a){
            case 1:
                return ally1;
            case 2:
                return ally2;
            default: 
                break;
        }
        return null;
    }
    
    /**
     * Gets the Enemy that corresponds to the number from the Battle instance.
     * @param e number of the enemy
     * @return enemy1, enemy2, enemy3, or null
     */
    public Chara getEnemy(int e){
        switch(e){
            case 1:
                return enemy1;
            case 2:
                return enemy2;
            case 3:
                return enemy3;
            default:
                break;
        }
        return null;
    }
    
    /**
     * Gets the texture string of the Battle instance.
     * @return textureStr
     */
    public String getTextureStr(){
        return textureStr;
    }
    
    /**
     * Gets the CharaList of the Battle instance.
     * @return CharaList
     */
    public ArrayList<Chara> getCharaList(){
        return CharaList;
    }
    
    /**
     * Checks if the Protag is dead and reopens the Battle scene or closes the game depending on the remaining life count of the protagonist.
     */
    public void checkDeath(){
        if(protag.getDead() && protag.getLifeCount() > 0){
            //do something here that reopens the scene
        }else if(protag.getDead() && protag.getLifeCount() == 0){
            //display dialog and close the game
        }
    }
}
