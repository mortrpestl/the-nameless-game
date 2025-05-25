/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * A StoryItem is a type of CollectableItem that is pivotal to the story.
 * @author Diogn Lei R. Mortera
 */
public class StoryItem extends CollectableItem {
    
    /**
     * A StoryItem inherits the properties of a CollectableItem.
     *  @param n the name of the StoryItem
   * @param tS the filename of the texture of the StoryItem
   * @param d the description of the StoryItem 
     */
  public StoryItem(String n, String tS, String d){
    super(n, tS, d);
  }
}
