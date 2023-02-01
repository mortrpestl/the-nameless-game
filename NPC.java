import java.awt.*;
import javax.swing.*;

public class NPC extends Chara implements Interactive {
  protected int relVal;
  
  public NPC(String n, ImageIcon[] t, String sR, int hp, int maxHP, int a, int d, int rV){
    super(n, t, sR, hp, maxHP, a, d);
    relVal = rV;
  }
  
  public void initiateBattle(Protag p){
    
  }

  public int getRelVal(){
    return relVal;
  }

  public void changeRelVal(int i){
    relVal += i;
  }

  public void interacted(){
    
  }

  public void die(){
    //causes the NPC to die
  }

  public void changeHP(Chara c){
    
  }

  public void increaseDP(Chara c){
    
  }

  public void move(){
    
  }

  @Override
  public void interact(){
    
  }
}