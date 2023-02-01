import java.awt.*;
import javax.swing.*;
  
public class PuzzleBlock extends Block implements Solid {
  private int goalPos;
  private boolean inGoalPos = false;

  public PuzzleBlock(String n, ImageIcon[] t, int p, int gp){
    super(n, t, p);
    goalPos = gp;
  }

  public void getGoalPos(){
    
  }

  public void reachedGoalPos(){
    
  }

  public void pushed(){
    
  }

  public void collided(){
    
  }
}