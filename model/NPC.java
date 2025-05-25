/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;

/**
 * An NPC is a type of Chara that can be interacted with by the Protag
 * @author Diogn Lei R. Mortera
 */
public class NPC extends Chara implements Interactive, GameplayList {
  protected int relVal;
  protected Event event;
  
  public static ArrayList<NPC> NPCList = new ArrayList<NPC>();
  
/**
 * An NPC inherits the properties of a Chara, as well as have a relationship value with the Protag. A NPC is also automatically added to an ArrayList containing all NPCs.
 * @param n the name of the NPC
   * @param tS the file name of the image containing the texture of the NPC
   * @param hp the health points of the NPC
   * @param maxHP the maximum health points of the NPC
   * @param a the attack points of the NPC
   * @param d the defense points of the NPC
   * @param e the event that plays when an NPC is interacted
 */
  public NPC(String n, String tS, int hp, int maxHP, int a, int d, Event e){
    super(n, tS, hp, maxHP, a, d);
    event = e;
    
    NPCList.add(this);
  }

  /**
   * Determines what happens when the NPC dies.
   */
  public void die(){
    //causes the NPC to die
  }

  /**
   * Determines the NPC's effects to a Protag when interacted
   */
  @Override
  public void interact(){
      event.play();
  }
  
}
