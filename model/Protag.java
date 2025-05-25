/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 *A Protag is a special type of Chara with 2 types of Inventories; custom values for its hp, maxHP, atk, and def parameters; and a life count.
 * @author Diogn Lei R. Mortera
 */
public class Protag extends Chara {
  private int lifeCount;
  private AttChangerItem[] attChanInv; //size 36 [35]
  private StoryItem[] storyInv; //size 3 [2]
  private boolean dead = false;
  private static boolean firstPlay = true;
  
/**
 * The Protag is a type of Chara with unique name, texture, and storyRole, because it contains the characteristics of the main character of the story. The hp, maxHP, atk, and def initializer values have presets and varies when the difficulty is changed.
 * @param n the name of the Protag
   * @param tS the file name of the image containing the texture of the Protag
   * @param sR the story role of the Protag
 */
  public Protag(String n, String tS){
    super(n, tS, 100, 100, 20,20);
    lifeCount = 3;
  }

  /**
   * Determines what happens when a Protag instance dies in a battle
   */
  public void die(){
    lifeCount--;
    //restart Battle
    
    if(lifeCount == 0) dead = true;
  }
  
//  /**
//   * Determines how the Protag instance moves in a Puzzle scene.
//   */
//  public void move(){
//    
//  } (MOVED TO PUZZLE)
  
  /**
   * gets the number of lives  of a Protag instance
   * @return lifeCount
   */
  public int getLifeCount(){
    return lifeCount;
  }

  /**
   * Takes an AttChangerInv item from the Protag instance's AttChangerInv inventory and applies its effect on the Protag (effect depends on the item).
   * @param index item to be applied to the Protag
   */
  public void useItem(int index) {
    //its up to the VIEW ASSIGNMENT person to get the index using MouseEvent return methods
    attChanInv[index].changeProtagAtt(this);
    attChanInv[index] = null;
  }
  
   
  /**
   * checks if StoryItem in parameter can be found in the Protag instance's storyInv inventory
   * @param si the StoryItem to compare
   * @return boolean
   */
  public boolean inSIInv(StoryItem si){
         for(StoryItem s : storyInv){
          if(si == s){
              return true;
          }
      }
      return false;
    }
  
   
  /**
   * checks if AttChangerItem in parameter can be found in the Protag instance's AttChanInv inventory
   * @param aci the AttChangerItem to compare
   * @return boolean
   */
  public boolean inACIInv(AttChangerItem aci){
      for(AttChangerItem a : attChanInv){
          if(aci == a){
              return true;
          }
      }
      return false;
    }
  
  /**
   * Gets the Att Changer inventory of the Protag instance
   * @return attChanInv
   */
  public AttChangerItem[] getAttChanInv(){
      return attChanInv;
  }
  
  /**
   * Gets the Story Item inventory of the Protag instance
   * @return storyInv
   */
  public StoryItem[] getStoryInv(){
      return storyInv;
  }
  
  /**
   * Gets if the Protag is dead in a Battle or not.
   * @return dead
   */
  public boolean getDead(){
      return dead;
  }
  /**
   * Gets whether or not it is the player's first time playing the game
   * @return firstPlay
   */
  public static boolean getFirstPlay(){
      return firstPlay;
  }
  
  /**
   * Sets variable firstPlay to false
   */
  public static void firstPlayDone(){
      firstPlay = false;
  }
}