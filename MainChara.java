import java.awt.*;
import javax.swing.*;

public class MainChara extends NPC{
  private String special;
 public MainChara(String n, ImageIcon[] t, String sR, int hp, int maxHP, int a, int d, int rV){
  super(n, t, sR, hp, maxHP, a, d, rV);
}

  public String getSpecial(){
    return special;
  }
  
}