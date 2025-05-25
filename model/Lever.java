/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * A Lever is a type of block that can be toggled by the Protag and is used to toggle Doors and the connected Levers.
 * @author Diogn Lei R. Mortera
 */
public class Lever extends Block {
  private boolean down = false;
  private Lever[] connectedLevers;
  private Door[] connectedDoors;
  
  /**
   * A Lever inherits the properties of a block, as well as have the list of the Levers connected to it and the doors it can toggle. 
   * @param n name of the Lever
   * @param tS file name of the texture of the Lever
   * @param pX x-position of the Lever in the Puzzle instance
   * @param pY y-position of the Lever in the Puzzle instance
   * @param cl list of Levers connected to the Lever
   * @param cd list of Doors connected to the Lever
   */
  public Lever(String n, String tS, int pX, int pY, Lever[] cl, Door[] cd){
    super(n, tS, pX, pY);
    connectedLevers = cl;
    connectedDoors = cd;
  }

 /**
  * Gets if the lever is up (deactivated) or down (activated).
  * @return down
  */
  public boolean getDown(){
    return down;
  }
  
  /**
   * Toggles the state of the Lever instance.
   * @throws LockedDoorException
   */
  public void toggleLever() throws LockedDoorException {
    down = !down;
    
    for(Door cd : connectedDoors){
        cd.toggleDoor(this);
    }
    //change texture of Lever
  }
}
