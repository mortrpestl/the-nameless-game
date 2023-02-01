import java.awt.*;
import javax.swing.*;

import java.awt.*;
import javax.swing.*;

public abstract class Block extends GameObject {
  protected int position;
  
  public Block(String n, ImageIcon[] t, int p){
    super(n, t);
    position = p;
  }

  public int getPosition(){
    return position;
  }
}