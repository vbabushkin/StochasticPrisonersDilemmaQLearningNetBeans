/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qlearningspdv3;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import sun.applet.Main;

/**
 *
 * @author Wild
 */
//Defines each stage of the game
public class Stage extends JLabel{
    //create a folder 'images' in the project folder, put all images there
    //add images directory as a source root: Project properties ->Sources->'Add Folder'
    //use Class.getResource():
    URL url = Main.class.getResource("/o.gif");
    URL url1 = Main.class.getResource("/co.gif");
    URL url2 = Main.class.getResource("/closedGate.gif");
    URL url3 = Main.class.getResource("/winGate.gif");
    private ImageIcon icon1 =  new ImageIcon(url);//"images/o.gif" 
    private ImageIcon icon2 =  new ImageIcon(url1);//"images/co.gif" 
    private ImageIcon icon3 =  new ImageIcon(url2);//"images/closedGate.gif" 
    private ImageIcon icon4 =  new ImageIcon(url3);
    private int reward1;
    private int reward2;
    //int screenX;
    //int screenY;
    int x;
    int y;
    String getReward1;
    String getReward2;
   
    private boolean isClosed =false;
    public Stage(final int reward1, final int reward2, int[] coords){
        this.reward1=reward1;
        this.reward2=reward2;
        this.x=coords[0];
        this.y=coords[1];
        String text = String.valueOf(reward1)+','+String.valueOf(reward2);
        super.setText(text);
        super.setIcon(icon1);       //Sets the image.
        super.setIconTextGap(-35);//Sets the number of pixels between the label's text and its image.   
    }
    
    public Stage(final int reward1, final int reward2, int coord1, int coord2){
        this.reward1=reward1;
        this.reward2=reward2;
        this.x=coord1;
        this.y=coord2;
        String text = String.valueOf(reward1)+','+String.valueOf(reward2);
        super.setText(text);
        super.setIcon(icon1);       //Sets the image.
        super.setIconTextGap(-35);//Sets the number of pixels between the label's text and its image.   
    }
    
    public Stage(int[] coords,boolean isFilled){
        
        this.x=coords[0];
        this.y=coords[1];
        
        if(!isFilled)
            super.setIcon(icon1);  
        else 
            super.setIcon(icon2);//Sets the image.
        super.setIconTextGap(-35);//Sets the number of pixels between the label's text and its image.   
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public boolean isClosed(){
        return isClosed;
    }
    public void setClosed(){
        super.setIcon(icon3);
        this.isClosed=true;
        reward1=0;
        reward2=0;
    }
    public void setWin(){
        super.setIcon(icon4);
    }
    public void reset(){
        super.setIcon(icon1);
        //this.isClosed=false;
    }
    public void resetClosed(){
        super.setIcon(icon1);
        this.isClosed=false;
        reward1=10;
        reward2=10;
    }
    //returns reward of first player
    public int getReward1(){
            return reward1;
        }
    
    //returns reward of second player
    public int getReward2(){
            return reward2;
        }
    
    //returns reward of first player as string for JTextFields
    public String getReward1AsString(){
            return getReward1;
        }
    //returns reward of second player as string for JTextFields
    public String getReward2AsString(){
            return getReward2;
        }
    @Override
    public int getX(){
        return x;
    }
    
    @Override
    public int getY(){
        return y;
    }
}
