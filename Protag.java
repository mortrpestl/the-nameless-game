import java.awt.*;
import javax.swing.*;

public class Protag extends Chara {
  private int lifeCount;
  private AttChangerItem[] attChanInv; //size 36 [35]
  private StoryItem[] storyInv; //size 3 [2]
  
  public Protag(String n, ImageIcon[] t, String sR){
    super(n, t, sR, 100, 100, 10, 5);
    lifeCount = 3;
  }

  public void interact(Interactive i){
    //interact with other Interactives
  }

  public void initiateBattle(NPC npc){
    //initiate battle
  }
  
  public void die(){
    
  }
  
  public void move(){
    
  }
  
  public int getLifeCount(){
    return lifeCount;
  }

  public void useItem(AttChangerItem i) {
    
  }
}