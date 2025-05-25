/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;

/**
 * A MainChara is a subset of NPC that contains the characters that appear in more than one phase, or characters that are pivotal to the lore of the game
 * @author Diogn Lei R. Mortera
 */
public class MainChara extends Chara{
  private String special;
  
  public static ArrayList<MainChara> MCList = new ArrayList<MainChara>();
  /**
   * A MainChara inherits the properties of an NPC. A MainChara is also automatically added to an ArrayList containing all MainCharas.
   * @param n the name of the MainChara
   * @param tS the file name of the image containing the texture of the MainChara
   * @param hp the health points of the MainChara
   * @param maxHP the maximum health points of the MainChara
   * @param a the attack points of the MainChara
   * @param d the defense points of the MainChara
   */
 public MainChara(String n, String tS, int hp, int maxHP, int a, int d){
  super(n, tS, hp, maxHP, a, d);
  
  MCList.add(this);
}

 /**
  * Gets the special of the MainChara.
  * @return special
  */
  public String getSpecial(){
    return special;
  }
  
}
