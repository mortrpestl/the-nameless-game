/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * An AttChangerItem is a type of CollectorItem that can change the attributes (health, attack, defense) of the protagonist.
 * @author Diogn Lei R. Mortera
 */
public class AttChangerItem extends CollectableItem {
  protected String type;
  protected int value;
  
  /**
   * An AttChangerItem inherits the properties of a CollectableItem, as well as have the type of attribute the AttChangerItem affects and the amount it does so.
   * @param n the name of the AttChangerItem
   * @param tS the filename of the texture of the AttChangerItem
   * @param d the description of the AttChangerItem
   * @param t the type of attribute that the AttChangerItem affects
   * @param v the amount/value the AttChangerItem affects the attribute
   */
  public AttChangerItem(String n, String tS, String d, String t, int v){
    super(n, tS, d);

    type = t;
    value = v;
  }

  /**
   * Gets the type of attribute of AttChangerItem affects
   * @return type
   */
  public String getType(){
    return type;
  }

  /**
   * Gets the amount/value the AttChangerItem affects the attribute
   * @return value
   */
  public int getValue(){
    return value;
  }
  
  /**
   * Changes the attribute of the protagonist the AttChangerItem type pertains to by the amount/value the AttChangerItem affects the attribute.
   * @param p the Protag instance whose attributes will be changed
   */
  public void changeProtagAtt(Protag p){
    switch(type){
        case "hp":
            p.changeHP(value);
            p.updateHPBar();
        break;
        case "atk":
            p.changeAtk(value);
        break;
        case "def":
            p.changeDef(value);
        break;
    }
  }
  
  /**
   * Reverts the attribute of the protagonist the AttChangerItem type pertains to by the amount/value the AttChangerItem affects the attribute.
   * @param p the Protag instance whose attributes will be changed
   */
  public void revertProtagAtt(Protag p){
    switch(type){
        case "hp":
            p.changeHP(-value);
            p.updateHPBar();
        break;
        case "atk":
            p.changeAtk(-value);
        break;
        case "def":
            p.changeDef(-value);
        break;
    }
  }
}
