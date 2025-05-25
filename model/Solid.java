/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * The Solid interface ensures that solid instances do not occupy the same position in a PuzzleGrid
 * 
 * @author Diogn Lei R. Mortera
 */
public interface Solid {
  /**
   * Triggers everytime the Protag moves and checks if atleast 2 Solid instances are occupying the same position
     * @throws SolidCollisionException
   */
  void collided() throws SolidCollisionException;
}
