import java.awt.*;
import javax.swing.*;

public abstract class Chara extends GameObject {

  protected String storyRole;
  protected int hp;
  protected int maxHP;
  protected int atk;
  protected int def;
  
  public Chara(String n, ImageIcon[] t, String sR, int h, int mh, int a, int d){
    super(n,t);
    storyRole = sR;
    hp = h;
    maxHP = mh;
    atk = a;
    def = d;
  }

  public String getName(){
    return name;
  }

  public int getHP(){
    return hp;
  }

  public int getMaxHP(){
    return maxHP;
  }

  public int getDef(){
    return def;
  }

  public String getStoryRole(){
    return storyRole;
  }

  public abstract void die(); //kills the Chara

  public void attack(){
    //causes Chara to attack
  }

  public void defend(){
    //causes Chara to defend
  }
}