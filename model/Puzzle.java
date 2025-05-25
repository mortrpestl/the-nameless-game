/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placeholder.model;

import java.util.ArrayList;

/**
 * The Puzzle class hosts every interaction that happens in a puzzle from player movement and player-and-block interactions.
 * @author Diogn Lei R. Mortera
 */
public class Puzzle implements GameplayList {
    private String name;
    private int boundX;
    private int boundY;
    private int playerX;
    private int playerY;
    private int trophyX;
    private int trophyY;
    private Block floor;
    private Item[][] ItemGrid;
    private Block[][] ObjectGrid;
    private Chara[][] CharaGrid;
    private Protag protag;
    private static int puzzleNum;
    private static ArrayList<Puzzle> puzzleList;
    
    /**
     * A Puzzle instance has a name, a furthest point from the origin denoted with an x-position and y-position, the x-position and y-position of the player's spawn point, and the list of initial blocks in specific order that will be in the Puzzle grid.
     * @param n the name of the Puzzle instance
     * @param bX the x-position of the furthest point from the origin of the Puzzle instance
     * @param bY the y-position of the furthest point from the origin of the Puzzle instance
     * @param pX the x-position of the player's spawn point in the Puzzle object grid
     * @param pY the y-position of the player's spawn point in the Puzzle object grid
     * @param tX the x-position of the win position in the Puzzle object grid
     * @param tY the y-position of the win position in the Puzzle object grid
     * @param f the Block making up the floor of the Puzzle Grid
     * @param p the protagonist instance in the Puzzle object grid
     */
    public Puzzle(String n, int bX, int bY, int pX, int pY, int tX, int tY, Block f, Protag p){
        name = n;
        boundX = bX;
        boundY = bY;
        playerX = pX;
        playerY = pY;
        trophyX = tX;
        trophyY = tY;
        floor = f;
        protag = p;
        
        //the code splits the original ObjectGrid ArrayList into separate arrays to make it look like a Grid
        for(int y = 0; y < bY; y++){
            ArrayList<Block> tempArrayList = new ArrayList<Block>();
            for(int x = 0; x < bX; x++){
                tempArrayList.add(floor);
            }
            Object[] tempArray = tempArrayList.toArray();
            try{
                for(int x = 0; x < bX; x++){
                    ObjectGrid[y][x] = (Block) tempArray[x];
                }
            } catch(NullPointerException npe){
                
            }
            
            
        }
        
        //code for initializing the array for ProtagGrid
        for(int temp = 0; temp < bY; temp++){
            ArrayList<Chara> tempCharaList = new ArrayList<Chara>();
            for(int temp1 = 0; temp1 < bX; temp1++){
                tempCharaList.add(null);
            }
            Object[] tempArray = tempCharaList.toArray();
            try{
                for(int x = 0; x < bX; x++){
                    CharaGrid[temp][x] = (Chara) tempArray[x];
                }
            } catch(NullPointerException npe){
                
            }
        }
        
        //code to intialize player position in Array
        try{
            CharaGrid[playerY][playerX] = protag;
        } catch(NullPointerException npe){
            //tentative
        }
                
        //code for initializing the array for ItemGrid
        for(int temp = 0; temp < bY; temp++){
            ArrayList<Item> tempItemList = new ArrayList<Item>();
            for(int temp1 = 0; temp1 < bX; temp1++){
                tempItemList.add(null);
            }
            Object[] tempArray = tempItemList.toArray();
            try{
                for(int x = 0; x < bX; x++){
                    ItemGrid[temp][x] = (Item) tempArray[x];
                }
            } catch(NullPointerException npe){
                
            }
        }
        
        try{
            puzzleList.add(this);
        } catch(NullPointerException npe){
            //tentative
        }
    }
    
    /**
     * Gets the name of the Puzzle instance.
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the x-position of the furthest point from the origin of the Puzzle instance.
     * @return boundX
     */
    public int getBoundX(){
        return boundX;
    }
    
    /**
     * Gets the y-position of the furthest point from the origin of the Puzzle instance.
     * @return boundY
     */
    public int getBoundY(){
        return boundY;
    }
    
    /**
     * Gets the x-position of the player's spawn point in the Puzzle object grid.
     * @return playerX
     */
    public int getPlayerX(){
        return playerX;
    }
    
    /**
     * Gets the y-position of the player's spawn point in the Puzzle object grid.
     * @return playerY
     */
    public int getPlayerY(){
        return playerY;
    }
    
    /**
     * Gets the floor block of the Puzzle instance.
     * @return floor;
     */
    public Block getFloor(){
        return floor;
    }
    
    /**
     * Generates a row (horizontal) of blocks in the specified row of the Puzzle instance.
     * @param row the row to be generated with blocks
     * @param b the block to be generated to each row
     */
    public void genRow(int row, Block b){
        //check if row is valid
        try{
            if(row < ObjectGrid.length){
                // replace the blocks
               for(int gR = 0; gR < ObjectGrid[row].length; gR++){
                   ObjectGrid[row][gR] = b;
               } 
            }
        } catch(NullPointerException npe){
            //tentative
        }
            
        //in View's perspective -- update Puzzle blocks
    }
    
     /**
     * Generates a column (vertical) of blocks in the specified row of the Puzzle instance.
     * @param col the column to be generated with blocks
     * @param b the block to be generated to each row
     */
    public void genCol(int col, Block b){
        //check if column is valid
        try{
            if(col < ObjectGrid[0].length){
                //replace the blocks
                for(int gC = 0; gC < ObjectGrid.length; gC++){
                    ObjectGrid[gC][col] = b;
                }
            }
        }catch(NullPointerException npe){
            //tentative
        }
            
        //in View's perspective -- update Puzzle blocks
    }
     
    /**
     * Generates a blocks in the specified position of the Puzzle instance.
     * @param pX the x-position of the position to be generated with a block
     * @param pY the y-position of the position to be generated with a block
     * @param b the block to be generated
     */
    public void genBlock(int pX, int pY, Block b){
        //check if row and column is valid
        
        try{
            if(pX < ObjectGrid[0].length && pY < ObjectGrid.length){
                ObjectGrid[pY][pX] = b;
            }
        } catch(NullPointerException npe){
            //tentative
        }
        //in View's perspective -- update Puzzle blocks
    }
    
     /**
     * Generates an item in the specified position of the Puzzle instance.
     * @param pX the x-position of the position to be generated with an item
     * @param pY the y-position of the position to be generated with an item
     * @param i the item to be generated
     */
    public void genItem(int pX, int pY, Item i){
        //check if row and column is valid
        if(pX < ItemGrid[0].length && pY < ItemGrid.length){
            ItemGrid[pY][pX] = i;
        }
        //in View's perspective -- update Puzzle blocks
    }

    /**
     * Resets the row's blocks to a floor texture.
     * @param row the row to be reset
     */
    public void resetRow(int row){
        //check if row is valid
        if(row < ObjectGrid.length){
            // replace the blocks
           for(int gR = 0; gR < ObjectGrid[row].length; gR++){
               ObjectGrid[row][gR] = getFloor();
           } 
        }
        //in View's perspective -- update Puzzle blocks
    }

    /**
     * Resets the column's blocks to a floor texture.
     * @param col the column to be reset
     */
    public void resetCol(int col){
         //check if column is valid
        if(col < ObjectGrid[0].length){
            //replace the blocks
            for(int gC = 0; gC < ObjectGrid.length; gC++){
                ObjectGrid[gC][col] = getFloor();
            }
        }
        //in View's perspective -- update Puzzle blocks
    }
    
    /**
     * Determines how the Protag moves in a Puzzle scene.
     * @param direction direction the Protag will move to
     */
    public void move(String direction){
        //detect Key press
        
        try{
            if(direction.equals("r")){
                CharaGrid[playerY][playerX] = null;
                playerX++;
                CharaGrid[playerY][playerX] = protag;
                
                //check if player is in the same position of a Wall, closed Door, or out-of-bounds
                if(detectPlayerOverlap() || detectOutOfBounds()){
                    CharaGrid[playerY][playerX] = null;
                    playerX--;
                    CharaGrid[playerY][playerX] = protag;
                }    

                //moves PuzzleBlock if player collided with PuzzleBlock
                if(detectMovableCollision()){
                    ObjectGrid[playerY][playerX+1] = ObjectGrid[playerY][playerX];
                    ObjectGrid[playerY][playerX] = null;

                    //check if PuzzleBlock is in the same position of a Wall, closed Door, or out-of-bounds
                    if(detectInvalidPuzzleBlockPosition()){
                        ObjectGrid[playerY][playerX] = ObjectGrid[playerY][playerX+1];
                        ObjectGrid[playerY][playerX+1] = null;
                    }
                }
            }

            if(direction.equals("l")){        
                CharaGrid[playerY][playerX] = null;
                playerX--;
                CharaGrid[playerY][playerX] = protag;
                
                //check if player is in the same position of a Wall, closed Door, or out-of-bounds
                if(detectPlayerOverlap() || detectOutOfBounds()){
                    CharaGrid[playerY][playerX] = null;
                    playerX++;
                    CharaGrid[playerY][playerX] = protag;
                }    

                //moves PuzzleBlock if player collided with PuzzleBlock
                if(detectMovableCollision()){
                    ObjectGrid[playerY][playerX-1] = ObjectGrid[playerY][playerX];
                    ObjectGrid[playerY][playerX] = null;

                    //check if PuzzleBlock is in the same position of a Wall, closed Door, or out-of-bounds
                    if(detectInvalidPuzzleBlockPosition()){
                        ObjectGrid[playerY][playerX] = ObjectGrid[playerY][playerX+1];
                        ObjectGrid[playerY][playerX-1] = null;
                    }
                }
            }

            ///if-statement when "up" arrow is pressed
            if(direction.equals("u")){
                CharaGrid[playerY][playerX] = null;
                playerY++;
                CharaGrid[playerY][playerX] = protag;

                //check if player is in the same position of a Wall, closed Door, or out-of-bounds
                if(detectPlayerOverlap() || detectOutOfBounds()){
                    CharaGrid[playerY][playerX] = null;
                    playerY--;
                    CharaGrid[playerY][playerX] = protag;
                }    

                //moves PuzzleBlock if player collided with PuzzleBlock
                if(detectMovableCollision()){
                    ObjectGrid[playerY+1][playerX] = ObjectGrid[playerY][playerX];
                    ObjectGrid[playerY][playerX] = null;

                    //check if PuzzleBlock is in the same position of a Wall, closed Door, or out-of-bounds
                    if(detectInvalidPuzzleBlockPosition()){
                        ObjectGrid[playerY][playerX] = ObjectGrid[playerY][playerX+1];
                        ObjectGrid[playerY+1][playerX] = null;
                    }
                }
            }

            ///if-statement when "down" arrow is pressed
            if(direction.equals("d")){
                CharaGrid[playerY][playerX] = null;
                playerY--;
                CharaGrid[playerY][playerX] = protag;

                //check if player is in the same position of a Wall, closed Door, or out-of-bounds
                if(detectPlayerOverlap() || detectOutOfBounds()){
                    CharaGrid[playerY][playerX] = null;
                    playerY++;
                    CharaGrid[playerY][playerX] = protag;
                }    

                //moves PuzzleBlock if player collided with PuzzleBlock
                if(detectMovableCollision()){
                    ObjectGrid[playerY-1][playerX] = ObjectGrid[playerY][playerX];
                    ObjectGrid[playerY][playerX] = null;

                    //check if PuzzleBlock is in the same position of a Wall, closed Door, or out-of-bounds
                    if(detectInvalidPuzzleBlockPosition()){
                        ObjectGrid[playerY][playerX] = ObjectGrid[playerY][playerX+1];
                        ObjectGrid[playerY-1][playerX] = null;
                    }
                }
            }
        }catch(Exception e){
            //Nothing happens here. this is just so an exception won't stop the entire program.
        }
    }
    
    /**
     * Determines what happens when a Player has the same position as a Lever or Button. Triggered every time a Protag moves.
     * @throws LockedDoorException
     */
    public void blockInteract() throws LockedDoorException {
        //making the list of x-positions and y-positions of Levers
        ArrayList<Integer[]> LeverList = new ArrayList<Integer[]>();
        for(int y = 0; y < boundY; y++){
            for(int x = 0; x < boundX; x++){
                if(ObjectGrid[y][x] instanceof Lever){
                    Integer[] tempArray = {x, y};
                    LeverList.add(tempArray);
                }
            }
        }
        
        //making the list of x-positions and y-positions of Buttons
        ArrayList<Integer[]> ButtonList = new ArrayList<Integer[]>();
        for(int y = 0; y < boundY; y++){
            for(int x = 0; x < boundX; x++){
                if(ObjectGrid[y][x] instanceof ButtonPuzzle){
                    Integer[] tempArray = {x, y};
                    ButtonList.add(tempArray);
                }
            }
        }
        
        //checking for overlap with Lever and toggles it
        for(int lLi = 0; lLi < LeverList.size(); lLi++){
            int tempX = (int) LeverList.get(lLi)[0];
            int tempY = (int) LeverList.get(lLi)[1];
            Lever lever = (Lever) ObjectGrid[tempY][tempX];
            if(tempX == playerX && tempY == playerY){
                lever.toggleLever();
            }
        }
        
        //checking for overlap with ButtonPuzzle and toggles it
        for(int bLi = 0; bLi < ButtonList.size(); bLi++){
            int tempX = (int) ButtonList.get(bLi)[0];
            int tempY = (int) ButtonList.get(bLi)[1];
            ButtonPuzzle button = (ButtonPuzzle) ObjectGrid[tempY][tempX];
            if(tempX == playerX && tempY == playerY){
                button.pressed();
            }
        }
    }

    /**
     * Determines what happens when a Player has the same position as a Door or Wall. Triggered every time a Protag moves.
     * @return boolean
     */
    public boolean detectPlayerOverlap(){
        //making the list of x-positions and y-positions of Doors
        ArrayList<Integer[]> DoorList = new ArrayList<Integer[]>();
        for(int y = 0; y < boundY; y++){
            for(int x = 0; x < boundX; x++){
                if(ObjectGrid[y][x] instanceof Door){
                    Integer[] tempArray = {x, y};
                    DoorList.add(tempArray);
                }
            }
        }
        
        //making the list of x-positions and y-positions of Walls
        ArrayList<Integer[]> WallList = new ArrayList<Integer[]>();
        for(int y = 0; y < boundY; y++){
            for(int x = 0; x < boundX; x++){
                if(ObjectGrid[y][x] instanceof Wall){
                    Integer[] tempArray = {x, y};
                    WallList.add(tempArray);
                }
            }
        }
        
        //checking for overlap with Door
        for(int dLi = 0; dLi < DoorList.size(); dLi++){
            int tempX = (int) DoorList.get(dLi)[0];
            int tempY = (int) DoorList.get(dLi)[1];
            Door door = (Door) ObjectGrid[tempY][tempX];
            if(tempX == playerX && tempY == playerY && !door.getOpened()){
                return true;
            }
        }
        
        //checking for overlap with Wall
        for(int wLi = 0; wLi < WallList.size(); wLi++){
            int tempX = (int) WallList.get(wLi)[0];
            int tempY = (int) WallList.get(wLi)[1];
            if(tempX == playerX && tempY == playerY){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Detects when the Player moves to a place with a PuzzleBlock.
     * @return boolean
     */
    public boolean detectMovableCollision(){
        //making the list of x-positions and y-positions of PuzzleBlocks
        ArrayList<Integer[]> PuzzleBlockList = new ArrayList<Integer[]>();
        for(int y = 0; y < boundY; y++){
            for(int x = 0; x < boundX; x++){
                if(ObjectGrid[y][x] instanceof PuzzleBlock){
                    Integer[] tempArray = {x, y};
                    PuzzleBlockList.add(tempArray);
                }
            }
        }
        
        //checking for overlap with PuzzleBlock
        for(int dLi = 0; dLi < PuzzleBlockList.size(); dLi++){
            int tempX = (int) PuzzleBlockList.get(dLi)[0];
            int tempY = (int) PuzzleBlockList.get(dLi)[1];
            PuzzleBlock puzzleBlock = (PuzzleBlock) ObjectGrid[tempY][tempX];
            if(tempX == playerX && tempY == playerY){
                return true;
            }
        }
        return false;
    }
    
    /** Detects when a PuzzleBlock is out-of-bounds or in the place of a Door or wall
     * @return boolean
     */
    public boolean detectInvalidPuzzleBlockPosition(){
        //making the list of x-positions and y-positions of PuzzleBlocks
        ArrayList<Integer[]> PuzzleBlockList = new ArrayList<Integer[]>();
        for(int y = 0; y < boundY; y++){
            for(int x = 0; x < boundX; x++){
                if(ObjectGrid[y][x] instanceof PuzzleBlock){
                    Integer[] tempArray = {x, y};
                    PuzzleBlockList.add(tempArray);
                }
            }
        }
        
        //making the list of x-positions and y-positions of Walls
        ArrayList<Integer[]> WallList = new ArrayList<Integer[]>();
        for(int y = 0; y < boundY; y++){
            for(int x = 0; x < boundX; x++){
                if(ObjectGrid[y][x] instanceof Wall){
                    Integer[] tempArray = {x, y};
                    WallList.add(tempArray);
                }
            }
        }
        
        //making the list of x-positions and y-positions of Doors
        ArrayList<Integer[]> DoorList = new ArrayList<Integer[]>();
        for(int y = 0; y < boundY; y++){
            for(int x = 0; x < boundX; x++){
                if(ObjectGrid[y][x] instanceof Door){
                    Integer[] tempArray = {x, y};
                    DoorList.add(tempArray);
                }
            }
        }
        
        //detecting if a PuzzleBlock and a Wall has the same position
        for(int pbLi = 0; pbLi < PuzzleBlockList.size(); pbLi++){
            for(int wLi = 0; wLi < WallList.size(); wLi++){
                int pbX = (int) PuzzleBlockList.get(pbLi)[0];
                int pbY = (int) PuzzleBlockList.get(pbLi)[1];
                int wX = (int) WallList.get(wLi)[0];
                int wY = (int) WallList.get(wLi)[1];
                
                if(pbX == wX && pbY == wY){
                    return true;
                }
            }
        }
        
        //detecting if a PuzzleBlock and an unopened Door has the same position
        for(int pbLi = 0; pbLi < PuzzleBlockList.size(); pbLi++){
            for(int dLi = 0; dLi < DoorList.size(); dLi++){
                int pbX = (int) PuzzleBlockList.get(pbLi)[0];
                int pbY = (int) PuzzleBlockList.get(pbLi)[1];
                int dX = (int) DoorList.get(dLi)[0];
                int dY = (int) DoorList.get(dLi)[1];
                
                if(pbX == dX && pbY == dY){
                    return true;
                }
            }
        }
        
        //detecting if a PuzzleBlock is out-of-bounds 
        for(int pbLi = 0; pbLi < PuzzleBlockList.size(); pbLi++){
            int pbX = (int) PuzzleBlockList.get(pbLi)[0];
            int pbY = (int) PuzzleBlockList.get(pbLi)[1];


            if(pbX < 0 || pbX > boundX || pbY < 0 || pbY > boundY){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Detects when a Player goes out of bounds of the Puzzle grid. Triggered every time a Protag moves.
     * @return boolean
     */
    public boolean detectOutOfBounds(){
        if(playerX < 0 || playerX > boundX || playerY < 0 || playerY > boundY){
            return true;
        }
        return false;
    }
    
    /**
     * Sets the number of the Puzzle instance
     * @param i the number to set the number of the Puzzle instance to
     */
    public static void setPuzzleNum(int i){
        puzzleNum = i;
    }
    
    /**
     * Gets the number of the Puzzle instance
     * @return puzzleNum
     */
    public static int getPuzzleNum(){
        return puzzleNum;
    }
    
    /**
     * Gets the Puzzle List of the Puzzle instance
     * @return puzzleList
     */
    public static ArrayList<Puzzle> getPuzzleList(){
        return puzzleList;
    }
    
    
    /**
     * Gets the Object Grid of the Puzzle instance
     * @return ObjectGrid
     */
    public Block[][] getObjGrid(){
        return ObjectGrid;
    }
    
    /**
     * Gets the Chara Grid of the Puzzle instance
     * @return CharaGrid
     */
    public Chara[][] getChaGrid(){
        return CharaGrid;
    }
    
    /**
     * Gets the Item Grid of the Puzzle instance
     * @return ItemGrid
     */
    public Item[][] getItemGrid(){
        return ItemGrid;
    }
    
    /**
     * Gets the x-position of the win position in the Puzzle object grid
     * @return trophyX
     */
    public int getTrophyX(){
        return trophyX;
    }
    
    /**
     * Gets the y-position of the win position in the Puzzle object grid
     * @return trophyY
     */
    public int getTrophyY(){
        return trophyY;
    }
}
