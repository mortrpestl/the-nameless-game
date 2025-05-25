/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * Doors can be opened and closed. They can also be locked and unlocked. They can be toggled by different Blocks such as Levers, Buttons, and StoryItems.
 * @author Diogn Lei R. Mortera
 */
public class Door extends Block implements Solid {
  private boolean opened;
  private boolean locked;
  private String siName;

  /**
   * A Door inherits the properties of a Block, as well as have boolean variables to determine if a Door is opened/closed and locked/unlocked. By default, a Door is closed yet unlocked.
   * @param n the name of the Door
   * @param tS the filename of the texture of the Door
   * @param pX the x-position of the Door
   * @param pY the y-position of the Door
   * @param sin the story item that can open the Door
   */
    public Door(String n, String tS, int pX, int pY, String sin){
    super(n, tS, pX, pY);
    siName = sin;
    opened = false;
    locked = false;
  }
  
    /**
     * A Door inherits the properties of a Block, as well as have boolean variables to determine if a Door is opened/closed and locked/unlocked.
      @param n the name of the Door
   * @param tS the filename of the texture of the Door
   * @param pX the x-position of the Door
   * @param pY the y-position of the Door
   * @param sin the story item that can open the Door
     * @param o value of opened boolean of Door (true for opened/false for closed)
     * @param l value for locked boolean of Door (true for locked/false for unlocked)
     */
    public Door(String n, String tS, int pX, int pY, String sin, boolean o, boolean l){
    super(n, tS, pX, pY);
    siName = sin;
    opened = o;
    locked = l;
  }

    /**
     * Gets the value of the opened boolean of a Door
     * @return opened
     */
    public boolean getOpened(){
        return opened; 
  }

    /**
     * Gets the value of the locked boolean of a Door
     * @return locked
     */
    public boolean getLocked(){
        return locked;
  }

    /**
     * Gets the name of the StoryItem that can open the door
     * @return siName
     */
    public String getSIName(){
        return siName;
    }
    
    /**
     * Opens a closed door and closes an opened door, when it is unlocked. When the protagonist tries to toggle a door when it's locked, a LockedDoorException will arise.
     * @throws LockedDoorException 
     */
    public void toggleDoor() throws LockedDoorException {
        locked = !locked;
    }

    /**
     * Using a Lever - opens a closed door and closes an opened door, when it is unlocked. When the protagonist tries to toggle a door when it's locked, a LockedDoorException will arise.
     * @param l Lever that toggles the Door
     * @throws LockedDoorException 
     */
    public void toggleDoor(Lever l) throws LockedDoorException {
        locked = !locked;
    }

    /**
     * Using a Button - opens a closed door and closes an opened door, when it is unlocked. When the protagonist tries to toggle a door when it's locked, a LockedDoorException will arise.
     * @param b ButtonPuzzle that toggles the Door
     * @throws LockedDoorException 
     */
    public void openDoor(ButtonPuzzle b) throws LockedDoorException {
      if(!locked){
        opened = !opened;
      } else {
        throw new LockedDoorException("Nako, the door is locked.");
      }
    }

    /**
     * Using a StoryItem - opens a closed door and closes an opened door, when it is unlocked. When the protagonist tries to toggle a door when it's locked, a LockedDoorException will arise. 
     * @param si StoryItem that toggles the door
     * @throws LockedDoorException 
     */
    public void openDoor(StoryItem si) throws LockedDoorException {
      if(!locked){
        opened = !opened;
      } else {
        throw new LockedDoorException("Nako, the door is locked.");
      }
    }

    /**
     * Unlocks the door.
     * @param b the ButtonPuzzle that can unlock the door
     */
    public void unlockDoor(ButtonPuzzle b) {
            locked = false;
    }
    ///DEPRECATED
    /**
     * Doesn't let the protagonist move a locked Door and displays NotPushableException
     * @throws NotPushableException
     */
    public void moved() throws NotPushableException{

    }

    /**
     * Doesn't let the protagonist take the position of the locked Door and throws a SolidCollisionException
     */
    @Override
    public void collided() throws SolidCollisionException{

    }
  
}
