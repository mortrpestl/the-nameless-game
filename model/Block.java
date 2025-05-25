/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;

/**
 * Blocks are a type of class that contains all instances that can be found in a Puzzle layout.
 * @author Diogn Lei R. Mortera
 */
public abstract class Block extends GameObject {
  protected int posX;
  protected int posY;
  
  public static ArrayList<Block> BlockList = new ArrayList<Block>();
  /**
   * A Block inherits the properties of a GameObject, as well as have a specific position in the Puzzle class grid.
   * @param n name of the Block
   * @param tS file name of the texture of the Block
   * @param pX position of the block in the grid (X-axis)
   * @param pY position of the block in the grid (Y-axis)
   */
  public Block(String n, String tS, int pX, int pY){
    super(n, tS);
    posX = pX;
    posY = pY;
    
    BlockList.add(this);
  }

  /**
   * Gets the x-position of the Block instance
   * @return posX 
   */
  public int getPosX(){
    return posX;
  }
  
  /**
   * Gets the y-position of the Block instance
   * @return posY
   */
  public int getPosY(){
    return posY;
  }
}
