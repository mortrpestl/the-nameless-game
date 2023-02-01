import java.awt.*;
import javax.swing.*;

public class TempAttChangerItem extends AttChangerItem {
  private int duration;
  
  public TempAttChangerItem(String n, ImageIcon[] t, String a, int av, int d){
    super(n, t, a, av);
    duration = d;
  }

  public int getDuration(){
    return duration;
  }
}