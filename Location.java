import java.awt.*;
import javax.swing.*;

public class Location {
  private String name;
  private GameObject[] objects;
  private ImageIcon bgImage;
  private ImageIcon map;
  
  public Location(String n){
    name = n;
  }

  public String getName(){
    return name;
  }

  public void enterLoc(){

  }

  public ImageIcon getBG(){
    return bgImage;
  }

  public ImageIcon getMap(){
    return map;
  }
}