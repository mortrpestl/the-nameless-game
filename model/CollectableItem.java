/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * CollectableItems are items that can be collected and dropped by the player. The protagonist can use these items to change their stats such as health, defense, or attack points. They can also be pivotal to the story's direction.
 * @author Diogn Lei R. Mortera
 */
public abstract class CollectableItem extends Item{
  
    /**
     * The CollectableItem inherits the properties of an Item.
     * @param n the name of the CollectableItem
     * @param tS the filename of the texture of the CollectableItem
     * @param d the description of the CollectableItem
     */
  public CollectableItem(String n, String tS, String d){
    super(n, tS, d);
  }

  /**
   * Puts the CollectableItem into the protagonist's inventory.
   * @param p the Protag instance the inventory belongs to 
   * @throws FullInventoryException
   */
  public void pickUp(Protag p) throws FullInventoryException {
      //add to corresponding Inv
     if(this instanceof AttChangerItem){
        for(int i = 0; i < p.getAttChanInv().length; i++){
            if(p.getAttChanInv()[i] == null){
                p.getAttChanInv()[i] = (AttChangerItem) this;
            }
        }
     } if(this instanceof StoryItem){
         for(int i = 0; i < p.getStoryInv().length; i++){
            if(p.getStoryInv()[i] == null){
                p.getStoryInv()[i] = (StoryItem) this;
            }
        }
     }
  }

  /**
   * Removes the CollectableItem into the protagonist's inventory.
   * @param p the Protag instance the inventory belongs to
   */
  public void discard(Protag p){
    //remove from corresponding Inv
    if(this instanceof AttChangerItem){
        for(int i = 0; i < p.getAttChanInv().length; i++){
            if(p.getAttChanInv()[i] == this){
                p.getAttChanInv()[i] = null;
            }
        }
     } if(this instanceof StoryItem){
         for(int i = 0; i < p.getStoryInv().length; i++){
            if(p.getStoryInv()[i] == this){
                p.getStoryInv()[i] = null;
            }
        }
     }
  }
}
