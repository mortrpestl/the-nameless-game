/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * Buttons can toggle things such as doors and items.
 * @author Diogn Lei R. Mortera // Edits by Krixian Skye D. Del Rosario
 */
public class ButtonPuzzle extends Block {
  private String beforePressedStr;
  private String afterPressedStr;
  private String type;
  
  private Puzzle puzzle;
  
  private Door door;
  private int doorX;
  private int doorY;
  
  private Item item;
  private int itemX;
  private int itemY;
  
  /**
   * A Button inherits the properties of a Block, as well as the GameObject that it toggles/affects - this type of Button ***opens Doors***
   * @param p the Puzzle instance where the Button instance can be found
   * @param n the name of the Button instance
   * @param tS the file name of the image texture of the Button instance
   * @param pX the x-position of the Button in the puzzleGrid
   * @param pY the y-position of the Button in the puzzleGrid
   * @param d the Door to be toggled when the button is pressed
   * @param dX the x-position of the Door to be toggled in the puzzleGrid
   * @param dY the y-position of the Door to be toggled in the puzzleGrid
   */
  public ButtonPuzzle(Puzzle p, String n, String tS, int pX, int pY, Door d, int dX, int dY){
    super(n, tS, pX, pY);
    puzzle = p;
    type = "door";
    
    door = d;
    doorX = dX;
    doorY = dY;
    
    item = null;
    itemX = 0;
    itemY = 0;
  }
  
  /**
   * A Button inherits the properties of a Block, as well as the GameObject that it toggles/affects - this type of Button makes ***Items appear in the PuzzleGrid***
   * @param p the Puzzle instance where the Button instance can be found
   * @param n the name of the Puzzle instance
   * @param tS the file name of the image texture of the Puzzle instance
   * @param pX the x-position of the Button in the puzzleGrid
   * @param pY the y-position of the Button in the puzzleGrid
   * @param i the item to appear when the Button is pressed
   * @param iX the x-position of the Item in the puzzleGrid when it appears
   * @param iY the y-position of the Item in the puzzleGrid when it appears
   */
  public ButtonPuzzle(Puzzle p, String n, String tS, int pX, int pY, Item i, int iX, int iY){
    super(n, tS, pX, pY);
    puzzle = p;
    type = "item";
    
    door = null;
    doorX = 0;
    doorY = 0;
    
    item = i;
    itemX = iX;
    itemY = iY;
  }

  /**
   * Opens the Door instance connected to a button.
   */
  public void openDoor() throws LockedDoorException{
      //return here and add openDoor parameter after editing Door
      door.openDoor(this);
  }
  
  /**
   * Makes an item appear in a certain position in the Puzzle grid.
   */
  public void appearItem(){
      puzzle.genItem(itemX, itemY, item);
  } 
  
  /**
   * Determines what happens when a ButtonPuzzle is pressed in the Puzzle grid (for Item-type buttons)
   * @throws LockedDoorException
   */
  public void pressed() throws LockedDoorException{
        if(type.equals("item")){
            this.appearItem();
        }
        else if(type.equals("door")){
            try{
                door.openDoor(this);
            }catch(LockedDoorException lde){
                throw new LockedDoorException("This door is locked.");
            }
        }
  }
}