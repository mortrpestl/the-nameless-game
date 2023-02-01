import java.awt.*;
import javax.swing.*;

public class AttChangerItem extends CollectableItem {
  protected String att;
  protected int attVal;
  
  public AttChangerItem(String n, ImageIcon[] t, String a, int av){
    super(n, t);

    att = a;
    attVal = av;
  }

  public String getAtt(){
    return att;
  }

  public int getAttVal(){
    return attVal;
  }
  
  public void changeProtagAtt(){
    
  }
}