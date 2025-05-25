/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * HealItems are a specific type of AttChangerItem that can be used during a battle. Note that they are different from AttChangerItems that heal as the latter can be used outside a battle, whereas HealItems cannot.
 * @author Diogn Lei R. Mortera
 */
public class HealItem extends AttChangerItem {
  int HPInc; //default value: 10
  int HPIncPercent; //default value: 10
  
  /**
   * HealItems inherit the properties of an AttChangerItem, as well as have a value (either points/percentage) of the amount of health points it will heal of the Protag.
   *  @param n the name of the HealItem
   * @param tS the filename of the texture of the HealItem
   * @param d the description of the HealItem
   * @param v the amount of health points it heals outside battle (set to 0 so it cannot be used outside battle)
   * @param hpi the amount of health points it heals inside battle (in points)
   * @param hpip the amount of health points it heals inside battle (in percentage, where 1 = 1%)
   */
  public HealItem(String n, String tS, String d, int v, int hpi, int hpip){
      super(n, tS, d, "hp", 0); //0 so it would not have any effect
      // TODO: consider adding an Exception here

      HPInc = hpi;
      HPIncPercent = hpip;
    }

  /**
   * Gets the amount of health points it heals inside battle (in points)
   * @return HPInc
   */
  public int getHPInc(){
    return HPInc;
  }

  /**
   * Gets the amount of health points it heals inside battle (in percentage, where 1 = 1%).
   * @return HPIncPercent
   */
  public int getHPIncPercent(){
    return HPIncPercent;
  }

  /**
   * Changes the heal attribute of the protagonist by the amount/value the AttChangerItem affects the attribute by point.
   * @param p the Protag that will be healed by point
   * @throws FullHealthException
   */
  public void changeProtagAttByPoint (Protag p) throws FullHealthException {
    p.changeHP(HPInc);
    
    //if health > maxHP
    if(p.getHP() > p.getMaxHP()){
       p.setHP(p.getMaxHP());
    }
    p.updateHPBar();
  }
  
  /**
   * Changes the heal attribute of the protagonist by the amount/value the AttChangerItem affects the attribute by percentage.
     * @param p the Protag that will be healed by percentage
     * @throws FullHealthException
   */
  public void changeProtagAttByPercent(Protag p) throws FullHealthException {
    int n = p.getHP() * getHPIncPercent();
    
    p.changeHP(n);
    
    //if health > maxHP
    if(p.getHP() > p.getMaxHP()){
       p.setHP(p.getMaxHP());
    }
    p.updateHPBar();
  }
}
