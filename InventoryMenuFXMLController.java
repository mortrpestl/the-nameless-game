/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package placeholder;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import placeholder.model.*;

/**
 *
 * @author Diogn Lei R. Mortera, Krixian Skye D. Del Rosario
 */
public class InventoryMenuFXMLController implements Initializable {
    
    
    @FXML private ImageView itemDisp, item00, item01, item02, item03, item04, item05, item06, item07, item08, item09, item10, item11, item12, item13, item14, item15, item16, item17, item18, item19, item20, item21, item22, item23, item24, item25, item26, item27, item28, item29, item30, item31, stoItem1, stoItem2, stoItem3;
    @FXML private StackPane use_portion;
    @FXML private Text title, desc;
    
    private CollectableItem itemDisplayed;
    private ArrayList<ImageView> itemImgList, storyImgList;
    private Protag protag = Battle.getBattleList().get(Battle.getBattleNum()).getProtag();
    
    @FXML private void slotOnMouseEnter(MouseEvent e){
        Pane tempSlot = (Pane) e.getSource();
        tempSlot.setBackground(new Background(new BackgroundFill(Color.rgb(214,214,214), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    @FXML private void slotOnMouseExit(MouseEvent e){
        Pane tempSlot = (Pane) e.getSource();
        tempSlot.setBackground(new Background(new BackgroundFill(Color.rgb(237,237,237), CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    @FXML private void rectOnMouseEnter(MouseEvent event){
        Rectangle tempRectangle = (Rectangle) event.getSource();
        tempRectangle.setFill(Color.PURPLE);
    }
    
    @FXML private void rectOnMouseExit(MouseEvent event){
        Rectangle tempRectangle = (Rectangle) event.getSource();
        tempRectangle.setFill(Color.rgb(135, 87, 189));
    }
    
    @FXML private void slotClick(MouseEvent e){
        ImageView img = (ImageView) e.getSource();
        if(img.getImage()!=null){
            use_portion.setVisible(true);
            if(itemImgList.contains(img)){
                itemDisp.setImage(img.getImage());
                title.setText(protag.getAttChanInv()[itemImgList.indexOf(img)].getName());
                desc.setText(protag.getAttChanInv()[itemImgList.indexOf(img)].getDesc());
                itemDisplayed = protag.getAttChanInv()[itemImgList.indexOf(img)];
            } else if(storyImgList.contains(img)){
                itemDisp.setImage(img.getImage());
                title.setText(protag.getStoryInv()[storyImgList.indexOf(img)].getName());
                desc.setText(protag.getStoryInv()[storyImgList.indexOf(img)].getDesc());
                itemDisplayed = protag.getStoryInv()[storyImgList.indexOf(img)];
            }
        } else {
            clearInfo();
        }
        
        
    }
    
    public void clearInfo(){
        itemDisp.setImage(null);
        title.setText(null);
        desc.setText(null);
        use_portion.setVisible(false);
    }
    
    public void assignSprites(){
        clearSprites();
        int i = 0;
        for(ImageView iv : itemImgList){
            Item item = protag.getAttChanInv()[i];
            if(item != null){
                iv.setImage(new Image(getClass().getResourceAsStream(item.getTextureStr())));
            }
            i++;
        }
        
        int j = 0;
        for(ImageView iv : storyImgList){
            Item item = protag.getStoryInv()[j];
            if(item != null){
                iv.setImage(new Image(getClass().getResourceAsStream(item.getTextureStr())));
            }
            j++;
        }
    }
    
    @FXML private void trashItem(MouseEvent e){
        itemDisplayed.discard(protag);
        assignSprites();
    }
    
    @FXML private void changeTrashButtonOnEnter(MouseEvent e){
        ImageView tempPause = (ImageView) e.getSource();
        Image newPause = new Image(getClass().getResourceAsStream("graphics/trashbuttonhovered.png"));
        
        tempPause.setImage(newPause);
    }
    
    @FXML private void changeTrashButtonOnExit(MouseEvent e){
        ImageView tempPause = (ImageView) e.getSource();
        Image newPause = new Image(getClass().getResourceAsStream("graphics/trashbutton.png"));
        
        tempPause.setImage(newPause);
    }
    
    public void clearSprites(){
        for(ImageView iv : itemImgList){
            iv.setImage(null);
        }
        for(ImageView iv : storyImgList){
            iv.setImage(null);
        }
    }
    
    public void keyPress(KeyEvent event, Scene scene) throws IOException{
        //System.out.println(event.getCode());
        Scene currentScene = scene;
        Stage currentStage = (Stage) currentScene.getWindow();
        
        if(event.getCode()==KeyCode.ESCAPE){
            currentStage.close();
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clearInfo();
        use_portion.setVisible(false);
        
        itemImgList = new ArrayList<>();
        storyImgList = new ArrayList<>();
        
        itemImgList.add(item00);
        itemImgList.add(item01);
        itemImgList.add(item02);
        itemImgList.add(item03);
        itemImgList.add(item04);
        itemImgList.add(item05);
        itemImgList.add(item06);
        itemImgList.add(item07);
        itemImgList.add(item08);
        itemImgList.add(item09);
        itemImgList.add(item10);
        itemImgList.add(item11);
        itemImgList.add(item12);
        itemImgList.add(item13);
        itemImgList.add(item14);
        itemImgList.add(item15);
        itemImgList.add(item16);
        itemImgList.add(item17);
        itemImgList.add(item18);
        itemImgList.add(item19);
        itemImgList.add(item20);
        itemImgList.add(item21);
        itemImgList.add(item22);
        itemImgList.add(item23);
        itemImgList.add(item24);
        itemImgList.add(item25);
        itemImgList.add(item26);
        itemImgList.add(item27);
        itemImgList.add(item28);
        itemImgList.add(item29);
        itemImgList.add(item30);
        itemImgList.add(item31);
        
        storyImgList.add(stoItem1);
        storyImgList.add(stoItem2);
        storyImgList.add(stoItem3);
        
        assignSprites();
    }    
    
}
