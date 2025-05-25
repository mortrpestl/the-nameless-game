/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.*;
 
/**
 *A GameObject has a name and a texture. It can be a Chara, Block, or Item
 * 
 * @author Diogn Lei R. Mortera
 */
public class GameObject {
  String name;
  String textureStr;
  private static ArrayList<GameplayList> gpList = new ArrayList<>();

  /**
   * Has a name and a textureString. Can be an Item, Chara, or Block
   * @param n name
   * @param tS textureStr
   */
  public GameObject(String n, String tS){
    name = n;
    textureStr = tS;
  }

  /**
   * gets the name of the GameObject
   * @return name
   */
  public String getName(){
      return name;
  }
  
  /**
   * gets the texture name of the GameObject to be used for getting the filename of the texture in the View files
   * @return textureStr
   */
  public String getTextureStr(){
    return textureStr;
  }

}
