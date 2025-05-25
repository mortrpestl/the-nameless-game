/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

/**
 * The Immovable interface makes Blocks that implement it immovable.
 * @author Diogn Lei R. Mortera
 */
public interface Immovable {
  
  /**
   * Throws an Exception which displays a message informing the protagonist they cannot move this block
   * @throws NotPushableException
   */
  void moved() throws NotPushableException;
}
