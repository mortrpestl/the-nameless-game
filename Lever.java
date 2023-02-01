import java.awt.*;
import javax.swing.*;

public class Lever extends Block {
  private boolean down = false;
  private Lever[] connectedLevers;
  private Door[] connectedDoors;
  
  public Lever(String n, ImageIcon[] t, int p, Lever[] cl, Door[] cd){
    super(n, t, p);
    connectedLevers = cl;
    connectedDoors = cd;
  }

  public boolean getDown(){
    return down;
  }

  public void toggleLever(){
    down = !down;
  }
}