import java.awt.*;
import javax.swing.*;

public class Door extends Block {
  private boolean opened;
  private boolean locked;

  public Door(String n, ImageIcon[] t, int p){
    super(n, t, p);
  }

  public boolean getOpened(){
   return opened; 
  }

  public boolean getLocked(){
   return locked;
  }

    public void toggleDoor() throws LockedDoorException {
        locked = !locked;
    }

      public void toggleDoor(Lever l) throws LockedDoorException {
        locked = !locked;
    }

    public void openDoor(Button b) throws LockedDoorException {
      if(!locked){
        opened = !opened;
      } else {
        throw new LockedDoorException("Nako, the door is locked.");
      }
    }

    public void openDoor(StoryItem s) throws LockedDoorException {
      if(!locked){
        opened = !opened;
      } else {
        throw new LockedDoorException("Nako, the door is locked.");
      }
    }

public void moved(){
  
}

public void collided(){
  
}
  

  
  
}