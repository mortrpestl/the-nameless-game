/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.lang.Exception;

/**
 * The FullInventoryException catches the exception that triggers when the Protag tries to pickUp() an item with a full inventory.
 * @author Diogn Lei R. Mortera
 */
public class FullInventoryException extends Exception {
  public FullInventoryException(String msg){
    super(msg);
  }  
}
