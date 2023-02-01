import java.awt.*;
import javax.swing.*;

public class HealItem extends AttChangerItem {
  int HPInc;
  float HPIncPercent;
  
  public HealItem(String n, ImageIcon[] t, int av, int hpi, int hpip){
      super(n, t, "hp", av);

      HPInc = hpi;
      HPIncPercent = hpip;
    }

  public int getHPInc(){
    return HPInc;
  }

  public float getHPIncPercent(){
    return HPIncPercent;
  }

  @Override
  public void changeProtagAtt(){
    
  }
}