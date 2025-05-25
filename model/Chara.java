/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * A Chara is a class that consists of characters you can interact with in various ways such as healing and attacking.
 * @author Diogn Lei R. Mortera
 */
public abstract class Chara extends GameObject {

  protected String storyRole;
  protected int hp;
  protected int maxHP;
  protected int atk;
  protected int def;
  protected int hpBars=5;
  
  /**
   * A Chara has a role in the story, hp, a maximum HP, attack points, and defense points.
   * 
   * @param n the name of the Chara instance
   * @param tS the file name of the image containing the texture of the Chara instance
   * @param sR the story role of the Chara instance
   * @param h the health points of the Chara instance
   * @param mh the maximum health points of the Chara instance
   * @param a the attack points of the Chara instance
   * @param d the defense points of the Chara instance
   */
  public Chara(String n, String tS, int h, int mh, int a, int d){
    super(n,tS);
    hp = h;
    maxHP = mh;
    atk = a;
    def = d;
  }

  /**
   * Gets the current health points of the Chara instance.
   * @return hp
   */
  public int getHP(){
    return hp;
  }

  /**
   * Gets the maximum health points that can be attained by the Chara instance.
   * @return maxHP
   */

  public int getMaxHP(){
    return maxHP;
  }

  /**
   * Gets the defense points of the Chara instance.
   * @return def
   */

  public int getDef(){
    return def;
  }

  /**
   * Gets the story Role of the Chara instance.
   * @return storyRole
   */
  public String getStoryRole(){
    return storyRole;
  }
  
  /**
   * Makes a Chara instance attack another Chara instance
   * @param c the Chara that will be attacked
   */
  public void attack(Chara c){
        if (this.hp > 0){
            c.hp -= atk - c.def;
            c.updateHPBar();
        }
      
  }
  
  /**
   * Changes the health points of the Chara instance by a given integer.
   * @param n number to change HP of Chara instance by (negative numbers will subtract)
   */
  public void changeHP(int n){
      hp += n;
      this.updateHPBar();
  }
  
  /**
   * Sets the health points of the Chara instance.
   * @param n number to set HP of Chara
   */
  public void setHP(int n){
      hp += n;
      this.updateHPBar();
  }
  
  /**
   * Sets the maximum health points of the Chara instance.
   * @param n number to set max HP of Chara
   */
  public void setMaxHP(int n){
      maxHP = n;
      this.updateHPBar();
  }
  
  /**
   * Changes the attack points of the Chara by a given integer.
   * @param n number to change atk of Chara by (negative numbers will subtract)
   */
  public void changeAtk(int n){
      atk += n;
  }
  
  /**
   * Changes the defense points of the Chara instance by a given integer.
   * @param n number to change def of Chara by (negative numbers will subtract)
   */
  public void changeDef(int n){
      def += n;
  }
  
  /**
   * Updates the HP Bar of the Chara instance in the view.
   * 
   */
  public void updateHPBar(){
      for(int i=5; i>=0; i--){
          if(hp<maxHP*(0.20*i+0.01)) hpBars = i;
      }
  }
  
  /**
   * Gets the number of HP Bars of the Chara instance.
   * @return hpBars
   */
  public int getHPBar(){
      return hpBars;
  }
}