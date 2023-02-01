import java.awt.*;
import javax.swing.*;

public class Button extends Block {
  private ImageIcon beforePressed;
  private ImageIcon afterPressed;
  private GameObject affected;
  
  public Button(String n, ImageIcon[] t, int p, GameObject a){
    super(n, t, p);
    affected = a;
  }

  public void pressed(){
    //plays a series of events when pressed
  }
}