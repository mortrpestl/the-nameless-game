/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * A Wall serves as a solid, immovable object in a Puzzle grid. Protagonists and puzzle blocks cannot pass through it.
 * @author Diogn Lei R. Mortera
 */
public class Wall extends Block implements Solid, Immovable {
    
  /**
   * A Wall inherits the properties of a Block.
   * @param n the name of the Wall
   * @param tS the filename of the texture of the Wall
   * @param pX the x-position of the Wall
   * @param pY the y-position of the Wall
   */
  public Wall(String n, String tS, int pX, int pY){
    super(n, tS, pX, pY);
  } 

  ///DEPRECATED
  /**
   * Doesn't let the protagonist move a PuzzleBlock to a Wall and displays NotPushableException
     * @throws NotPushableException
   */
  @Override
  public void moved() throws NotPushableException{
    
  }

  /**
   * Doesn't let the protagonist take the position of the block and throws a SolidCollisionException
     * @throws SolidCollisionException
   */
  @Override
  public void collided() throws SolidCollisionException{
    
  }
}
