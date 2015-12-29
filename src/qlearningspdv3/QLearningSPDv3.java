/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qlearningspdv3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.border.TitledBorder;



/**
 *
 * @author Wild
 */
public class QLearningSPDv3 extends JFrame{
static JTextField jtfReward1 = new JTextField();
    static JTextField jtfReward2 = new JTextField();
    static JTextField jtfTotalUtilityPlayer = new JTextField();
    static JTextField jtfTotalUtilityAdversary = new JTextField();
    JPanel p12 = new JPanel(new GridLayout(2, 1,10,10));
    JPanel p2 = new JPanel(new GridLayout(7, 2,10,10));
    JPanel p3 = new JPanel(new GridLayout(7, 1,10,10));
    JPanel p03= new JPanel(new GridLayout(2, 1,0,0));
    JPanel p23= new JPanel(new GridLayout(2, 1,0,0));
    JPanel p4= new JPanel(new BorderLayout(0,90));
    final JRadioButton jrbTraining =  new JRadioButton( "Training mode", true );
    final JRadioButton jrbPlaying =  new JRadioButton( "Playing mode", false );
    final JTextField jtfLRPlayer1 = new JTextField("0.1");
    final JTextField jtfGammaPlayer1 = new JTextField("0.95");
    final JTextField jtfLRPlayer2 = new JTextField("0.1");
    final JTextField jtfGammaPlayer2 = new JTextField("0.95");
    final JTextField jtfNumOfRounds = new JTextField("100");
    JButton jbtReset1 =new JButton("Reset p1");
    JButton jbtReset2 =new JButton("Reset p2");
    JLayeredPane lpane = new JLayeredPane();
    JButton jbtRepeat=new JButton("Repeat");
    JButton jbtTraining=new JButton("Start Training");
    JPanel p1 = new JPanel(new GridLayout(7, 5,0,0));
    int numOfRounds;
    public QLearningSPDv3() throws IOException{
        int [][] stageCoordinates =   {{0,0},{50,0},{100,0},{150,0},{200,0},
                                       {0,50},{50,50},{100,50},{150,50},{200,50},
                                       {0,100},{50,100},{100,100},{150,100},{200,100},
                                       {0,150},{50,150},{100,150},{150,150},{200,150},
                                       {0,200},{50,200},{100,200},{150,200},{200,200},
                                       {0,250},{50,250},{100,250},{150,250},{200,250},
                                       {0,300},{50,300},{100,300},{150,300},{200,300},
                                       {0,350},{50,350},{100,350},{150,350},{200,350}
                                      };
        setLayout(new GridLayout(1,2,5,5));
        lpane.setLayout(new OverlayLayout(lpane));
        Stage st11=new Stage(-1,-1,stageCoordinates[0]);
        Stage st12=new Stage(-1,-1,stageCoordinates[1]);
        final Stage st13=new Stage(10,10,stageCoordinates[2]);
        Stage st14=new Stage(-1,-1,stageCoordinates[3]);
        Stage st15=new Stage(-1,-1,stageCoordinates[4]);
    
        Stage st21=new Stage(-1,-1,stageCoordinates[5]);
        Stage st22=new Stage(-1,-1,stageCoordinates[6]);
        Stage st23=new Stage(stageCoordinates[7],true);
        Stage st24=new Stage(-1,-1,stageCoordinates[8]);
        Stage st25=new Stage(-1,-1,stageCoordinates[9]);
        
        Stage st31=new Stage(-1,-1,stageCoordinates[10]);
        Stage st32=new Stage(-1,-1,stageCoordinates[11]);
        final Stage st33=new Stage(10,10,stageCoordinates[12]);
        Stage st34=new Stage(-1,-1,stageCoordinates[13]);
        Stage st35=new Stage(-1,-1,stageCoordinates[14]);
        
        Stage st41=new Stage(-1,-1,stageCoordinates[15]);
        Stage st42=new Stage(-1,-1,stageCoordinates[16]);
        Stage st43=new Stage(stageCoordinates[17],true);
        Stage st44=new Stage(-1,-1,stageCoordinates[18]);
        Stage st45=new Stage(-1,-1,stageCoordinates[19]);
        
        Stage st51=new Stage(-1,-1,stageCoordinates[20]);
        Stage st52=new Stage(-1,-1,stageCoordinates[21]);
        final Stage st53=new Stage(10,10,stageCoordinates[22]);
        Stage st54=new Stage(-1,-1,stageCoordinates[23]);
        Stage st55=new Stage(-1,-1,stageCoordinates[24]);
        
        Stage st61=new Stage(-1,-1,stageCoordinates[25]);
        Stage st62=new Stage(-1,-1,stageCoordinates[26]);
        Stage st63=new Stage(stageCoordinates[27],true);
        Stage st64=new Stage(-1,-1,stageCoordinates[28]);
        Stage st65=new Stage(-1,-1,stageCoordinates[29]);
        
        Stage st71=new Stage(-1,-1,stageCoordinates[30]);
        Stage st72=new Stage(-1,-1,stageCoordinates[31]);
        final Stage st73=new Stage(10,10,stageCoordinates[32]);
        Stage st74=new Stage(-1,-1,stageCoordinates[33]);
        Stage st75=new Stage(-1,-1,stageCoordinates[34]);
        
        final Stage st81=new Stage(-1,-1,stageCoordinates[35]);
        Stage st82=new Stage(-1,-1,stageCoordinates[36]);
        Stage st83=new Stage(stageCoordinates[37],true);
        Stage st84=new Stage(-1,-1,stageCoordinates[38]);
        final Stage st85=new Stage(-1,-1,stageCoordinates[39]);
        
        p1.add(st11);
        p1.add(st12);
        p1.add(st13);
        p1.add(st14);
        p1.add(st15);
        
        p1.add(st21);
        p1.add(st22);
        p1.add(st23);
        p1.add(st24);
        p1.add(st25);
        
        p1.add(st31);
        p1.add(st32);
        p1.add(st33);
        p1.add(st34);
        p1.add(st35);
        
        p1.add(st41);
        p1.add(st42);
        p1.add(st43);
        p1.add(st44);
        p1.add(st45);
        
        p1.add(st51);
        p1.add(st52);
        p1.add(st53);
        p1.add(st54);
        p1.add(st55);
        
        p1.add(st61);
        p1.add(st62);
        p1.add(st63);
        p1.add(st64);
        p1.add(st65);
        
        p1.add(st71);
        p1.add(st72);
        p1.add(st73);
        p1.add(st74);
        p1.add(st75);
        
        p1.add(st81);
        p1.add(st82);
        p1.add(st83);
        p1.add(st84);
        p1.add(st85);
        
        Stage[] setOfStates1={st81,st82,
                             st71,st72, st73,  
                             st61,st62,
                             st51,st52,st53,
                             st41,st42,
                             st31,st32,st33,
                             st21,st22,
                             st11,st12,st13
                            };
        
        Stage[] setOfStates2={st85,st84,
                             st75,st74, st73,  
                             st65,st64,
                             st55,st54,st53,
                             st45,st44,
                             st35,st34,st33,
                             st25,st24,
                             st15,st14,st13
                            };
        
        
        p2.add(new JLabel("First player's Reward"));
        p2.add(jtfReward1);
        p2.add(new JLabel("Second player's Reward"));
        p2.add(jtfReward2);
        p2.add(new JLabel("1st Player's Total Utility"));
        p2.add(jtfTotalUtilityPlayer);
        p2.add(new JLabel("2-nd Player's Total Utility"));
        p2.add(jtfTotalUtilityAdversary);
        p2.add(new JLabel("Number of Rounds to Train"));
        p2.add(jtfNumOfRounds);
        
        p2.add(new JLabel("Current round: #"));
        final JLabel jlblCurrentRound = new JLabel("0");
        p2.add(jlblCurrentRound);
        
        p2.add(jbtRepeat);
        p2.add(jbtTraining);
        
        p2.setBorder(new TitledBorder("Measures"));
        
       
        JButton jbtReset=new JButton("Reset Matrix");
        
        
        p3.add(new JLabel("1-st Player's Learning Rate"));
        p3.add(jtfLRPlayer1);
        p3.add(new JLabel("1-st Player's Discount Factor"));
        p3.add(jtfGammaPlayer1);
        
       // p3.add(jtfLRPlayer2);
        //p3.add(new JLabel("discount factor"));
        //p3.add(jtfGammaPlayer2);
        p3.setBorder(new TitledBorder("Algorithm parameters"));
        
        //to make p3 fit well to pane we first place it in panel p03, change p03's size and then add p03 to p23
        
        //p03.setPreferredSize(new Dimension(150, 10));
        p3.add(new JLabel("2-nd Player's Learning Rate"));
        p3.add(jtfLRPlayer2);
        p3.add(new JLabel("2-nd Player's Discount Factor"));
        p3.add(jtfGammaPlayer2);
      
        
        
        p3.add(new JLabel("Transition Prob. Player 1"));
        final JTextField jtfTransProb1 = new JTextField("0.3");
        p3.add(jtfTransProb1);
        p3.add(new JLabel("Transition Prob. Player 2"));
        final JTextField jtfTransProb2 = new JTextField("0.3");
        p3.add(jtfTransProb2);
        p3.add(jbtReset1);
        p3.add(jbtReset2);
        p23.add(p2);
        p23.add(p3);
        
        
        
        
        
        ///////////////////////////////////////////////////////////////////////
        
        
        
        ///////////////////////////////////////////////////////////////////////
        
         /**
         * Add agents
         */
        
        final Player a1=new Player(st81,setOfStates1,Color.BLACK);
        final Associate a2=new Associate(st85,setOfStates2,Color.GREEN);
        //a1.moveAgent();
        
        final double [][] newQMatrix1=new double[20][4];
        final double [][] newQMatrix2=new double[20][4];
        //fill training matrix
        /*
         * Training the agents
         */
       jbtTraining.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e1) {
                numOfRounds=Integer.parseInt(jtfNumOfRounds.getText());
                for(int round=1;round<=numOfRounds;round++)
                {
                    jlblCurrentRound.setText(Integer.toString(round));
                    while(!a2.isStopped || !a1.isStopped){
                        click(jbtRepeat,300);
                        a1.paintImmediately(0,0,600,600);
                        a2.paintImmediately(0,0,600,600);
                        p2.paintImmediately(0,0,600,600);
                        p23.paintImmediately(0,0,600,600);
                        p3.paintImmediately(0,0,600,600);
                    }
                    try {
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(QLearningSPDv3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    st73.resetClosed();
                    st53.resetClosed();
                    st33.resetClosed();
                    st13.resetClosed();
                    a2.setStartStage(st85);
                    a1.setStartStage(st81);
                    a1.isStopped=false;
                    a2.isStopped=false;
                    st73.paintImmediately(0,0,600,600);
                    st53.paintImmediately(0,0,600,600);
                    st33.paintImmediately(0,0,600,600);
                    st13.paintImmediately(0,0,600,600);
                    a1.paintImmediately(0,0,600,600);
                    a2.paintImmediately(0,0,600,600);
                    p2.paintImmediately(0,0,600,600);
                    p23.paintImmediately(0,0,600,600);
                    p3.paintImmediately(0,0,600,600);
                    System.out.println("END OF ROUND "+round);
                    a1.setTotalUtility1(0);
                    a2.setTotalUtility2(0);
                }
                 //To change body of generated methods, choose Tools | Templates.
            }
       
       });
       
        /*
        * Reseting the player's matrix
        */
       jbtReset1.addActionListener(new ActionListener() {
            private BufferedWriter writer;

            @Override
            public void actionPerformed(ActionEvent e) {
                
                a1.initializeQMatrix(0);
                
                //Writting q matrix to a file
                    try {
                        writer = new BufferedWriter(new FileWriter("qMatrix1.txt"));
                        writeToFile(writer,a1);
                        } 
                    catch (IOException ex) {
                        Logger.getLogger(QLearningSPDv3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     //end of writting to a file 
                    
            }
       });
       
       /*
        * Reseting the matrix
        */
       jbtReset2.addActionListener(new ActionListener() {
            private BufferedWriter writer;

            @Override
            public void actionPerformed(ActionEvent e) {
               
                a2.initializeQMatrix(0);
                //Writting q matrix to a file
                   
                     //end of writting to a file 
                    //Writting q matrix to a file
                    try {
                        writer = new BufferedWriter(new FileWriter("qMatrix2.txt"));
                        writeToFile(writer,a2);
                        } 
                    catch (IOException ex) {
                        Logger.getLogger(QLearningSPDv3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     //end of writting to a file 
            }
       });
               
       
       /*
        * Playing mode -- starts with matrix that is already trained
        */
        final boolean startWithTrainedMatrix1 = true;
        final boolean startWithTrainedMatrix2 = true;
        jbtRepeat.addActionListener(new ActionListener() {
            private BufferedWriter writer;
            private BufferedReader reader;
            
            @Override 
            public void actionPerformed(ActionEvent e) {
                if(startWithTrainedMatrix1){
                     //Reading q matrix from a file
                    String strLine=null;
                    try {
                        FileInputStream in = new FileInputStream("qMatrix1.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        int i=0;
                        while((strLine = br.readLine())!= null){
                            ////System.out.println(strLine);
                            ////System.out.println("Split:"+Double.parseDouble(strLine.split("\\s+")[4]));
                            
                            for(int j=0;j<4;j++)
                                newQMatrix1[i][j]=Double.parseDouble(strLine.split("\\s+")[j+1]);
                            i++;
                        }
                    }catch(Exception b){
                        //System.out.println(b);
                    }
                    a1.setQValueMatrix(newQMatrix1);
                }
                
                if(startWithTrainedMatrix2){
                     //Reading q matrix from a file
                    String strLine=null;
                    try {
                        FileInputStream in = new FileInputStream("qMatrix2.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        int i=0;
                        while((strLine = br.readLine())!= null){
                            ////System.out.println(strLine);
                            ////System.out.println("Split:"+Double.parseDouble(strLine.split("\\s+")[4]));
                            
                            for(int j=0;j<4;j++)
                                newQMatrix2[i][j]=Double.parseDouble(strLine.split("\\s+")[j+1]);
                            i++;
                        }
                    }catch(Exception b){
                        //System.out.println(b);
                    }
                    a2.setQValueMatrix(newQMatrix2);
                }
                //set parameters
                a1.learningRate=Double.parseDouble(jtfLRPlayer1.getText());
                a1.gamma=Double.parseDouble(jtfGammaPlayer1.getText());
                a1.probability1=Double.parseDouble(jtfTransProb1.getText());
                a1.qLearn_v4();
                
                a2.learningRate=Double.parseDouble(jtfLRPlayer2.getText());
                a2.gamma=Double.parseDouble(jtfGammaPlayer2.getText());
                a2.probability2=Double.parseDouble(jtfTransProb2.getText());
                a2.qLearn_v4();
                
               System.out.println(a2.getCurrentStage().getX());
               System.out.println(a2.getCurrentStage().getY());
                    if((a1.getCurrentStage().getX()==100 && a1.getCurrentStage().getY()==300)^(a2.getCurrentStage().getX()==100 && a2.getCurrentStage().getY()==300 )){
                        st33.setClosed();
                        st53.setClosed();
                        st73.setClosed();
                        if((a1.getCurrentStage().getX()==100 && a1.getCurrentStage().getY()==300)&&!(a2.getCurrentStage().getX()==100 && a2.getCurrentStage().getY()==300 ))
                        {
                            a1.stop();
                            QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(a1.totalUtility1+10));
                        }
                        if((a2.getCurrentStage().getX()==100 && a2.getCurrentStage().getY()==300)&&! (a1.getCurrentStage().getX()==100 && a1.getCurrentStage().getY()==300))
                        {
                            a2.stop();
                            QLearningSPDv3.jtfTotalUtilityAdversary.setText(String.valueOf(a2.totalUtility2+10));
                        }
                        
                    }
                   
                    // both a1 and a2 enter gate 1 gates 1,2,3 close
                    if((a1.getCurrentStage().getX()==100 && a1.getCurrentStage().getY()==300 ) && (a2.getCurrentStage().getX()==100 && a2.getCurrentStage().getY()==300 )){
                       
                        st73.setClosed();
                        st53.setClosed();
                    }
                    //a1  enters gate 2 gate 1 closes
                    if((a1.getCurrentStage().getX()==100 && a1.getCurrentStage().getY()==200 )){
                        a1.stop();
                        st73.setClosed();  
                        QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(a1.totalUtility1+10));
                    }
                    // a2 enters gate 2 gate 1 closes
                    if((a2.getCurrentStage().getX()==100 && a2.getCurrentStage().getY()==200 )){
                        a2.stop();
                        QLearningSPDv3.jtfTotalUtilityAdversary.setText(String.valueOf(a2.totalUtility2+10));
                        st73.setClosed();   
                    }
                    //other cases (gates 3,4)
                    if((a1.getCurrentStage().getX()==100 && a1.getCurrentStage().getY()==0)|| (a1.getCurrentStage().getX()==100 && a1.getCurrentStage().getY()==100 ))//||(a1.getCurrentStage().getX()==100 && a1.getCurrentStage().getY()==200))
                    {
                        a1.stop();
                        QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(a1.totalUtility1+10));
                    }
                    if((a2.getCurrentStage().getX()==100 && a2.getCurrentStage().getY()==0)|| (a2.getCurrentStage().getX()==100 && a2.getCurrentStage().getY()==100))//||(a2.getCurrentStage().getX()==100 && a2.getCurrentStage().getY()==200))
                    {
                        a2.stop();
                        QLearningSPDv3.jtfTotalUtilityAdversary.setText(String.valueOf(a2.totalUtility2+10));
                    }
                    
                    
                    System.out.println("Q values for agent 1: ");
                    //printing q matrix
                    System.out.println("States        UP    DOWN    LEFT   RIGHT");
                    for(int i=0;i<a1.qValuesMatrix.length;i++){
                        System.out.printf("%4d    ",i);
                        for(int j=0;j<a1.qValuesMatrix[i].length;j++)
                            System.out.printf("%8.1f",a1.qValuesMatrix[i][j]);
                        System.out.println();
                    }
                    
                    System.out.println("Q values for agent 2: ");
                    //printing q matrix
                    System.out.println("States        UP    DOWN    LEFT   RIGHT");
                    for(int i=0;i<a2.qValuesMatrix.length;i++){
                        System.out.printf("%4d    ",i);
                        for(int j=0;j<a2.qValuesMatrix[i].length;j++)
                            System.out.printf("%8.1f",a2.qValuesMatrix[i][j]);
                        System.out.println();
                    }
                    
                     //Writting q matrix to a file
                    try {
                        writer = new BufferedWriter(new FileWriter("qMatrix1.txt"));
                        writeToFile(writer,a1);
                        } 
                    catch (IOException ex) {
                        Logger.getLogger(QLearningSPDv3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     //end of writting to a file 
                    //Writting q matrix to a file
                    try {
                        writer = new BufferedWriter(new FileWriter("qMatrix2.txt"));
                        writeToFile(writer,a2);
                        } 
                    catch (IOException ex) {
                        Logger.getLogger(QLearningSPDv3.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     //end of writting to a file  
                   
                }
            }
        );
        
        
        
        ////////////////////////////////////////////////////////////////////////
        a1.setOpaque(false);
        a2.setOpaque(false);
        lpane.add(a1,JLayeredPane.DEFAULT_LAYER, new Integer(4));
        lpane.add(a2,JLayeredPane.DEFAULT_LAYER, new Integer(4));
        lpane.add(p1,JLayeredPane.DEFAULT_LAYER, new Integer(2));
        lpane.add(p1,JLayeredPane.DEFAULT_LAYER, new Integer(2));
        //lpane.setBounds(0, 0, 200, 200);
        p4.add(p23,BorderLayout.PAGE_START);
        
        add(p4);
        add(lpane);
    }
    
     void writeToFile(BufferedWriter writer, Associate a){
        try {
            for(int i=0;i<a.qValuesMatrix.length;i++){
               for(int j=0;j<a.qValuesMatrix[i].length;j++)
                   writer.write(String.format("%8.1f",a.qValuesMatrix[i][j]));
               writer.newLine();
               }
            writer.close();
        } 
        catch (IOException ex) {
                    Logger.getLogger(QLearningSPDv3.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
     void writeToFile(BufferedWriter writer, Player a){
        try {
            for(int i=0;i<a.qValuesMatrix.length;i++){
               for(int j=0;j<a.qValuesMatrix[i].length;j++)
                   writer.write(String.format("%8.1f",a.qValuesMatrix[i][j]));
               writer.newLine();
               }
            writer.close();
        } 
        catch (IOException ex) {
                    Logger.getLogger(QLearningSPDv3.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
     /**
    * Click a button on screen
    *
    * @param button Button to click
    * @param millis Time that button will remain "clicked" in milliseconds
    */
    public void click(AbstractButton button, int millis) {
        jbtRepeat.doClick(millis);
        }
     
     
     
     
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        QLearningSPDv3 frame = new QLearningSPDv3();
        frame.setTitle("Prisoners' Dilemma");
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); 
    }
   
}
