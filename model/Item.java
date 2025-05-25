/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * An Item is a GameObject that can be used that can be interacted and/or collected. It can also be used to change the story's direction and/or the attributes of a Protag temporarily or permanently.
 * @author Diogn Lei R. Mortera
 */
public class Item extends GameObject {
    protected String desc;
    /**
     * An Item inherits the properties of a GameObject, as well as have a description.
     * @param n name
     * @param tS textureStr
     * @param d desc
     */
  public Item(String n, String tS, String d){
    super(n, tS);
    desc = d;
  }
  
  /**
   * Gets the description of an Item instance.
   * @return desc
   */
  public String getDesc(){
      return desc;
  }
  
  
}
