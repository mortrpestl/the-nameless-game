import java.awt.*;
import javax.swing.*;

public class Wall extends Block implements Solid, Immovable {
  public Wall(String n, ImageIcon[] t, int p){
    super(n,t,p);
  }

  @Override
  public void moved(){
    
  }

  @Override
  public void collided(){
    
  }
}