/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;

/**
 * A WorldItem is a type of item that can be found inside a location and can be interacted with by the Protag.
 * 
 * @author Diogn Lei R. Mortera
 */
public class WorldItem extends Item implements Interactive, GameplayList {

    private Event relatedEvent;
    private static Settings settings = null; //Insert Settings instance here
    
  public static ArrayList<WorldItem> WIList = new ArrayList<WorldItem>();
  /**
   * A WorldItem inherits the properties of an Item. A WorldItem is also automatically added to an ArrayList containing all WorldItems.
   * @param n the name of the WorldItem
   * @param tS the filename of the texture of the WorldItem
   * @param d the description of the WorldItem
   * @param rE event to play when WorldItem is interacted
   */
  public WorldItem(String n, String tS, String d, Event rE){
    super(n, tS, d);
    relatedEvent = rE;
    
    WIList.add(this);
  }

  /**
   * Plays the events that happen when an object is interacted. Events may include dialogue sequences and effects on the Protag's health, max health, and defense. Take note that world items cannot be collected.
   */
  @Override
  public void interact(){
    relatedEvent.play();
  }
}
