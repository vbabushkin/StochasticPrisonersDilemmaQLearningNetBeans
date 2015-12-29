/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qlearningspdv3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Wild
 */
final public class Player extends JPanel{
     public double probability1;
     private Color color;
     private int x0;
     private int y0;
     public int agentsReward=0;
     public int totalUtility1=0;
     public int totalUtility2=0;
     private Stage startStage;
     private Stage currentStage;
     private int stage;
     public boolean isStopped=false;
     public double [][] qValuesMatrix;
     private int currentPosition;
     private int currentAction;
     double gamma;
     double learningRate;
     ArrayList<Stage> tempSetOfStages = new ArrayList<Stage>();
     public Stage[] setOfStates;
     public Player(Stage startStage, Stage[] setOfStates,Color color){
         qValuesMatrix =new double[20][4];
         qValuesMatrix=initializeQMatrix(0);
         this.color=color;
         this.setOfStates=setOfStates;
         this.setStartStage(startStage); 
         this.currentStage=startStage;
         this.currentPosition=0;
         this.currentAction=0;
     }
     public void setTotalUtility1(int totalUtility1){
         this.totalUtility1=totalUtility1;
     }
     public void setQValueMatrix(double [][] qValuesMatrix){
         this.qValuesMatrix=qValuesMatrix;
     }
    public void setStartStage(Stage s){
         this.startStage=s;
         this.x0=s.getX()+10;
         this.y0=s.getY()+25;
         agentsReward=s.getReward1();
     }
    public void setStage(Stage s){
         //s.setX(x0);
         //s.setY(y0);
         this.x0=s.getX()+10;
         this.y0=s.getY()+25;
         agentsReward=s.getReward1();
     }
    public void setCurrentStage(Stage s){
        this.currentStage=s;
    }
    public Stage getCurrentStage(){
        return this.currentStage;
    }
    public void setCurrentStage(int stage){
        this.stage=stage;
    }
    public void stop(){
        this.isStopped=true;
    }
    /*
    public int getCurrentStage(){
        return stage;
    }
    */
     public void setX0(int newX0){
         this.x0=newX0;
     }
     public int getX0(){
         return x0;
     }
     
     public void setY0(int newY0){
         this.y0=newY0;
     }
     public int getY0(){
         return y0;
     }
     @Override
         protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.setColor(color);
         g.fillOval(x0, y0, 10 , 10);
     }
     
     
     
//     //moves an agent  randomly over the whole statespace
//     public void moveRandomly(){
//         int i=(int)Math.round(19*Math.random());
//         setCurrentStage(i);
//         //System.out.println("Current stage is: "+getCurrentStage());
//         
//         setX0(setOfStates[i].getX()+10); 
//         setY0(setOfStates[i].getY()+35);
//         agentsReward=setOfStates[i].getReward1();
//         QLearningSPDv3.jtfReward1.setText(String.valueOf(agentsReward));
//         System.out.println("Player's reward: "+agentsReward);
//         totalUtility1=totalUtility1+agentsReward;
//         QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(totalUtility1));
//         repaint();
//     }
//     //moves an agent  randomly moving one cell on each step
//     public void move(){
//         if (!isStopped){
//         //set current stage equal to initial start stage
//         Stage initCurrentStage = startStage;
//         //search for stage
//         Stage tempCurrentStage=searchStage(initCurrentStage);
//         //associate the newly found stage with the stage from agen't set of stages
//         for(Stage stg: setOfStates){
//             if((tempCurrentStage.getX()==stg.getX())&&(tempCurrentStage.getY()==stg.getY()))
//             {
//                 tempCurrentStage=stg;
//                 break;
//             }
//             
//         }
//         //check whether the new stage is closed or not
//         System.out.println("IS CURRENT STATE CLOSED? "+tempCurrentStage.isClosed());
//         while(tempCurrentStage.isClosed()&& !isStopped)
//             tempCurrentStage=searchStage(tempCurrentStage);
//         
//         //set agent's coordinates in stage to adjust its position
//         setX0(tempCurrentStage.getX()+10); 
//         setY0(tempCurrentStage.getY()+35);
//         agentsReward=tempCurrentStage.getReward1();
//         //then set the current state as agent's initial state
//         
//         setStartStage(tempCurrentStage);
//         setCurrentStage(tempCurrentStage);
//         QLearningSPDv3.jtfReward1.setText(String.valueOf(agentsReward));
//         System.out.println("Player's reward: "+agentsReward);
//         totalUtility1=totalUtility1+agentsReward;
//         QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(totalUtility1));
//         repaint();
//         }
//         else
//             repaint();
//     }
//     /*
//     * moves an agent  randomly moving one cell on each step but along the x 
//     * direction it moves  towards the cell, closest to goal
//     */
//     public void moveRandomToGoal(){
//         if (!isStopped){
//         //set current stage equal to initial start stage
//         Stage tempCurrentStage = startStage;
//         //search for stage
//         tempCurrentStage=searchClosestStage(tempCurrentStage);
//         //associate the newly found stage with the stage from agen't set of stages
//         for(Stage stg: setOfStates){
//             if((tempCurrentStage.getX()==stg.getX())&&(tempCurrentStage.getY()==stg.getY()))
//             {
//                 tempCurrentStage=stg;
//                 break;
//             }
//             
//         }
//         //check whether the new stage is closed or not
//         System.out.println("IS CURRENT STATE CLOSED? "+tempCurrentStage.isClosed());
//         while(tempCurrentStage.isClosed()&& !isStopped)
//             tempCurrentStage=searchClosestStage(tempCurrentStage);
//         
//         //set agent's coordinates in stage to adjust its position
//         setX0(tempCurrentStage.getX()+10); 
//         setY0(tempCurrentStage.getY()+35);
//         agentsReward=tempCurrentStage.getReward1();
//         //then set the current state as agent's initial state
//         
//         
//         
//         
//         //then set the current state as agent's initial state
//         setStartStage(tempCurrentStage);
//         setCurrentStage(tempCurrentStage);
//         QLearningSPDv3.jtfReward1.setText(String.valueOf(agentsReward));
//         System.out.println("Player's reward: "+agentsReward);
//         totalUtility1=totalUtility1+agentsReward;
//         QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(totalUtility1));
//         repaint();
//         }
//         else
//             repaint();
//        
//     }
     
      /*
      * 
      * q-Learning algorithm (new version, takes into account stages that are out
      * of bonds)
      * 
      */
      public void qLearn_v4(){
         System.out.println("START");
         
         int selectedAction;
         int currentAction;
         int [] setOfAllActions = {0,1,2,3};
         
         if (!isStopped){
            Stage tempCurrentStage = this.startStage;
            currentPosition=searchStateIndex(tempCurrentStage);
            
            
            
            //System.out.println("current Position is "+currentPosition);
            //System.out.println("current Reward is "+tempCurrentStage.getReward1());
            ArrayList<Stage> setOfNeighbors =findNeighboringStates(tempCurrentStage);
            Stage nextStage;
           
            
            //select an action randomly
            selectedAction=(int)Math.round(3*Math.random());
            
            //System.out.println("SELECTED ACTION "+selectedAction);
            
            //find the index of a stage that agent gets taking this action
            int index =associateStageWithAction(tempCurrentStage, selectedAction);//not used
            
            //System.out.println("The index of next stage is: "+index);
           
            //Selects the stage-action pair with maximum Q value
            int maxQIndex=0;
                double maxQ=qValuesMatrix[currentPosition][setOfAllActions[0]];
                for(int s=0;s<setOfAllActions.length;s++){
                    if(qValuesMatrix[currentPosition][setOfAllActions[s]]>maxQ){
                        maxQ=qValuesMatrix[currentPosition][setOfAllActions[s]];
                        maxQIndex=s;
                    }
                }
            
            //chooses whether to follow the q matrix or select a random action  
            //with some probability
            double n=Math.round(1+9*Math.random());
            
            if(n<=probability1*10)
                currentAction=maxQIndex;
            else
                currentAction=(int)Math.round(3*Math.random());
            
            //index of stage agent moves when currentAction is chosen
            int nextStageIndex=associateStageWithAction(tempCurrentStage,currentAction);
            System.out.println("nextStageIndex  "+nextStageIndex);
            
                
            
            //it is a auxiliary array to correctly identify next stage's position in the array of
            //neighboring states. Later this approach will be reconsidered and more effective
            //alternative will be found
            int[] indexOfNeighbors = new int[setOfNeighbors.size()];
            for(int i=0;i<indexOfNeighbors.length;i++){
                indexOfNeighbors[i]= searchStateIndex(setOfNeighbors.get(i));
                System.out.println("Agent has following neighbors: "+ indexOfNeighbors[i]);
            }
            int tmp;
            //now, if the agent's choosen action does not led him to states that are out of
            //bounds, the q value is calculated
            if(nextStageIndex!=-1 && nextStageIndex!=currentPosition){
                tmp=searchArray(indexOfNeighbors,nextStageIndex);//find the corresponding neighboring state
                if(tmp!=-1)//if found
                {
                    nextStage=setOfNeighbors.get(tmp);//associate neighbor with it
                    agentsReward=tempCurrentStage.getReward1();
                }
                else
                {
                    nextStage=tempCurrentStage; // if not found stay in the same position
                    agentsReward=0;
                }
            }
            else//if goes out of bonds -- stay on the same state
            {
                nextStage=tempCurrentStage;
                agentsReward=0;
            }
            
           //GUI
            System.out.println("REWARD!!!!  "+agentsReward);
            QLearningSPDv3.jtfReward1.setText(String.valueOf(agentsReward));
            
            
           
           int nextPosition=searchStateIndex(nextStage);
           
                
           //find max Q value for the next stage
           int maxNextQIndex=0;
           double maxNextQ=qValuesMatrix[nextPosition][0];
           for(int s=0;s<4;s++){
               if(qValuesMatrix[nextPosition][s]>maxNextQ){
                   maxNextQ=qValuesMatrix[nextPosition][s];
                   maxNextQIndex=s;
               }
           }
           
           //update Q value
           qValuesMatrix[currentPosition][currentAction]=(1-learningRate)*qValuesMatrix[currentPosition][currentAction]+learningRate*(nextStage.getReward1()+gamma*maxNextQ);
           System.out.println("qValuesMatrix["+currentPosition+"]["+currentAction+"]="+qValuesMatrix[currentPosition][currentAction]);
           
           System.out.println("Player's reward: "+agentsReward);
            
            System.out.println("TOTAL UTILITY !!!!  "+totalUtility1);
            
            totalUtility1=totalUtility1+agentsReward;
            QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(totalUtility1));
            
            
            System.out.println("END");
         
            //then set the current state as agent's initial state
            //setStartStage(tempCurrentStage);
            setStartStage(nextStage);//then agent moves to next stage and starts from it
            setCurrentStage(nextStage);//our currents stage now is nextStage
            
            
            
            
            nextStage=null;//set nextStage to null to use it for further nextStages
            paintImmediately(0,0,600,600);
            }
         else{
                
                paintImmediately(0,0,600,600);
            }
            
      }
      
     
     
     
      /////////////////////////////////////////////////////////////////////////
      int searchArray(int[] arr, int value){
          int res=-1;
          for(int i=0; i<arr.length;i++){
              if(arr[i]==value){
                  res=i;
                  break;
              }
          } 
          return res;
      }
     ///////////////////////////////////////////////////////////////////////////
     
     /*
      * associate stage with action taken
      */
     public int associateStageWithAction(Stage tempCurrentStage, int a){
         int index=-1;
         int x=tempCurrentStage.getX();
         int y=tempCurrentStage.getY();
         //compute next stage's coordinates choosing meaningfull ones from all 
         //possible options, if agents reaches a wall reset it's coordinates to
         //initial values. If agent's coordinates does not change -- continue un-
         //till first change appears -- to avoid "trotting" in one place
         x=tempCurrentStage.getX();
         y=tempCurrentStage.getY();
         
         switch(a){
                case 0:
                    y=y-50;
                    break;
                case 1: 
                    y=y+50;
                    break;
                case 2:
                    x=x-50;
                    break;
                case 3:
                    x=x+50;
                    break;  
            } 
            if(!(((x>=0)&&(x<=100))&&((y>=0)&&(y<=350)))||(x==tempCurrentStage.getX()&& y==tempCurrentStage.getY()))
                index=-1;
            else{
                //walls
                if(x==100 && (y==50 || y==150 || y==250 || y==350)){
                    x=tempCurrentStage.getX();
                    y=tempCurrentStage.getY();
                }
                //set corresponding reward values
                if(x==100 && (y==0 || y==100 || y==200 || y==300))
                    tempCurrentStage=new Stage(10,10,x,y);
                else
                    tempCurrentStage=new Stage(-1,-1,x,y);
                
                index=searchStateIndex(tempCurrentStage);
                }
            return index;
     }
      
     
     
     
//     /*
//      * q-Learning algorithm (new version)
//      * 
//      */
//      public void qLearn_v1(){
//         int i=0;
//         int j=0;
//         System.out.println("START ");
//         if (!isStopped){
//            ArrayList<Stage> setOfNeighbors = new ArrayList<>();
//            ArrayList<Integer> setOfActions = new ArrayList<>();
//            ArrayList<Integer> setOfStateIndices = new ArrayList<>();
//            Stage tempCurrentStage = startStage;
//            Stage nextStage;
//            //find current position
//            currentPosition=searchStateIndex(tempCurrentStage);
//            System.out.println("currentPosition "+currentPosition);
//            
//            
//            
//            System.out.println("Now agent is in stage : "+searchStateIndex(tempCurrentStage));
//            
//            
//            
//            System.out.println("Find all available neighbors and actions:");
//            setOfNeighbors =findNeighboringStates(tempCurrentStage);
//            setOfActions = findSetOfActions(tempCurrentStage);
//            setOfStateIndices = findNeighboringStatesIndices(tempCurrentStage);
//            
//            
//            
//            
//            //find the stage with maximum Q value
//            int maxQIndex=0;
//                double maxQ=qValuesMatrix[currentPosition][setOfActions.get(0)];
//                for(int s=0;s<setOfActions.size();s++){
//                    if(qValuesMatrix[currentPosition][setOfActions.get(s)]>maxQ){
//                        maxQ=qValuesMatrix[currentPosition][setOfActions.get(s)];
//                        maxQIndex=s;
//                    }
//                }
//            
//                
//             
//            //TODO Implement selecting an action with some probability
//            double n=Math.round(1+9*Math.random());
//            System.out.println("Now n is: "+n);
//            System.out.println("Now prob is: "+probability1*10);
//            if(n<=probability1*10)
//                nextStage=setOfNeighbors.get(maxQIndex);
//            else
//                nextStage=searchStageRandomly(tempCurrentStage);
//            
//           /* 
//             //check whether the new stage is closed or not
//            System.out.println("IS CURRENT STATE CLOSED? "+nextStage.isClosed());
//            while(nextStage.isClosed() && !isStopped)
//                nextStage=searchStage(nextStage);
//         
//            */
//            // find the index of new stage
//            currentAction=findCurrentActionTaken(nextStage);
//            int nextPosition=searchStateIndex(nextStage);
//            System.out.println("nextPosition "+nextPosition);
//            System.out.println("currentAction "+currentAction);
//            
//            //find max Q value
//             int maxNextQIndex=0;
//             double maxNextQ=qValuesMatrix[nextPosition][0];
//             for(int s=0;s<4;s++){
//                    if(qValuesMatrix[nextPosition][s]>maxNextQ){
//                        maxNextQ=qValuesMatrix[nextPosition][s];
//                        maxNextQIndex=s;
//                    }
//                }
//            
//             
//            
//             //update Q value
//             qValuesMatrix[currentPosition][currentAction]=(1-learningRate)*qValuesMatrix[currentPosition][currentAction]+learningRate*(nextStage.getReward1()+gamma*maxNextQ);
//             System.out.println("qValuesMatrix["+currentPosition+"]["+currentAction+"]="+qValuesMatrix[currentPosition][currentAction]);
//             
//            tempCurrentStage=nextStage;
//            setCurrentStage(tempCurrentStage);
//            nextStage=null;
//            //associate the newly found stage with the stage from agen't set of stages
//            for(Stage stg: setOfStates){
//             if((tempCurrentStage.getX()==stg.getX())&&(tempCurrentStage.getY()==stg.getY()))
//             {
//                 tempCurrentStage=stg;
//                 break;
//             }
//             
//            }
//            
//             //check whether the new stage is closed or not
//            System.out.println("IS CURRENT STATE CLOSED? "+tempCurrentStage.isClosed());
//            while(tempCurrentStage.isClosed() && !isStopped)
//                tempCurrentStage=searchStage(tempCurrentStage);
//            
//            System.out.println("Now agent moves to "+searchStateIndex(tempCurrentStage));
//            //set agent's coordinates in stage to adjust its position
//            setX0(tempCurrentStage.getX()+10); 
//            setY0(tempCurrentStage.getY()+35);
//            agentsReward=tempCurrentStage.getReward1();
//            
//            
//            System.out.println("END");
//         
//            //then set the current state as agent's initial state
//            //setStartStage(tempCurrentStage);
//            setStartStage(tempCurrentStage);
//            setCurrentStage(tempCurrentStage);
//            
//            QLearningSPDv3.jtfReward1.setText(String.valueOf(agentsReward));
//            System.out.println("Associate's reward: "+agentsReward);
//            totalUtility1=totalUtility1+agentsReward;
//            QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(totalUtility1));
//            
//            paintImmediately(0,0,600,600);
//            }
//            else
//                paintImmediately(0,0,600,600);
//            
//      }
//     
//     
//     ///////////////////////////////////////////////////////////////////////////
//     
//     ///////////////////////////////////////////////////////////////////////////
//     
//     
//     /*
//      * q-Learning algorithm
//      * 
//      */
//     
//     public void qLearn(){
//         
//         int i=0;
//         int j=0;
//         
//         if (!isStopped){
//            ArrayList<Stage> setOfNeighbors = new ArrayList<>();
//            ArrayList<Integer> setOfActions = new ArrayList<>();
//            ArrayList<Integer> setOfStateIndices = new ArrayList<>();
//            Stage tempCurrentStage = startStage;
//            
//            
//            //find current position
//            currentPosition=searchStateIndex(tempCurrentStage);
//            System.out.println("Agent now is in state "+ currentPosition);
//            //System.out.println("Now agent is in stage : "+searchStateIndex(tempCurrentStage));
//            
//            
//            
//           // System.out.println("Find all available neighbors and actions:");
//            setOfNeighbors =findNeighboringStates(tempCurrentStage);
//            setOfActions = findSetOfActions(tempCurrentStage);
//            setOfStateIndices = findNeighboringStatesIndices(tempCurrentStage);
//            
//            
//            System.out.println();
//            System.out.println("Set of possible actions:");
//            for(int a=0;a<setOfActions.size();a++)
//                System.out.println(setOfActions.get(a));
//            
//            System.out.println();
//            System.out.println("Set of possible states:");
//            for(int s=0;s<setOfStateIndices.size();s++)
//                System.out.println(setOfStateIndices.get(s));
//            
//            
//            for(int k=0;k<setOfNeighbors.size();k++){
//                Stage nextStage=setOfNeighbors.get(k);
//                ArrayList<Stage> setOfNextNeighbors =findNeighboringStates(nextStage);
//                ArrayList<Integer>  setOfNextActions = findSetOfActions(nextStage);
//                ArrayList<Integer> setOfNextStateIndices = findNeighboringStatesIndices(nextStage);
//                System.out.println();
//                System.out.println("Set of possible actions for state:"+k);
//                for(int a=0;a<setOfNextActions.size();a++)
//                    System.out.println(setOfNextActions.get(a));
//            
//                System.out.println();
//                System.out.println("Set of possible states for state: "+k);
//                for(int s=0;s<setOfNextStateIndices.size();s++)
//                    System.out.println(setOfNextStateIndices.get(s));
//                
//                double max=-1000000;
//                for(int m=0;m<setOfNextNeighbors.size();m++){
//                    if(qValuesMatrix[setOfNextStateIndices.get(m)][setOfNextActions.get(m)]>max){
//                        max=qValuesMatrix[setOfNextStateIndices.get(m)][setOfNextActions.get(m)];
//                    }
//                }
//                System.out.println("Max for next stage "+max);
//                //update Q value
//                qValuesMatrix[currentPosition][setOfActions.get(k)]=(1-learningRate)*qValuesMatrix[currentPosition][setOfActions.get(k)]+learningRate*(nextStage.getReward1()+gamma*max);
//                System.out.println("qValuesMatrix["+currentPosition+"]["+setOfActions.get(k)+"]="+qValuesMatrix[currentPosition][setOfActions.get(k)]);
//                
//                
//            }
//            
//            
//            //find current action taken
//            currentAction=findCurrentActionTaken(tempCurrentStage);
//            //find current position
//            currentPosition=searchStateIndex(tempCurrentStage);
//            
//            System.out.println("END");
//            
//            
//                int maxQIndex=0;
//                double maxQ=qValuesMatrix[currentPosition][setOfActions.get(0)];
//                for(int s=0;s<setOfActions.size();s++){
//                    if(qValuesMatrix[currentPosition][setOfActions.get(s)]>maxQ){
//                        maxQ=qValuesMatrix[currentPosition][setOfActions.get(s)];
//                        maxQIndex=s;
//                    }
//                }
//                
//            
//            
//                
//                
//                
//                
//            //TODO Implement selecting an action with some probability
//            int n=(int)Math.round(1+9*Math.random());
//            System.out.println("Now n is: "+n);
//            if(n<probability1*10)
//                tempCurrentStage=setOfNeighbors.get(maxQIndex);
//            else
//                tempCurrentStage=searchStageRandomly(tempCurrentStage);
//            
//            
//            
//            //associate the newly found stage with the stage from agen't set of stages
//            for(Stage stg: setOfStates){
//             if((tempCurrentStage.getX()==stg.getX())&&(tempCurrentStage.getY()==stg.getY()))
//             {
//                 tempCurrentStage=stg;
//                 break;
//             }
//             
//         }
//            
//            
//            
//             //check whether the new stage is closed or not
//            System.out.println("IS CURRENT STATE CLOSED? "+tempCurrentStage.isClosed());
//            while(tempCurrentStage.isClosed()&& !isStopped)
//                tempCurrentStage=searchStage(tempCurrentStage);
//         
//            //set agent's coordinates in stage to adjust its position
//            setX0(tempCurrentStage.getX()+10); 
//            setY0(tempCurrentStage.getY()+35);
//            agentsReward=tempCurrentStage.getReward1();
//         
//         
//            //then set the current state as agent's initial state
//            setStartStage(tempCurrentStage);
//            setCurrentStage(tempCurrentStage);
//            QLearningSPDv3.jtfReward1.setText(String.valueOf(agentsReward));
//            System.out.println("Associate's reward: "+agentsReward);
//            totalUtility1=totalUtility1+agentsReward;
//            QLearningSPDv3.jtfTotalUtilityPlayer.setText(String.valueOf(totalUtility1));
//         
//            paintImmediately(0,0,600,600);
//            }
//            else
//                paintImmediately(0,0,600,600);
//         
//     }
//     ///////////////////////////////////////////////////////////////////////////
//     
//     /*
//      * searchState looks for next state
//      */
//     public Stage searchStageRandomly(Stage tempCurrentStage){
//         int x=tempCurrentStage.getX();
//         int y=tempCurrentStage.getY();
//         //compute next stage's coordinates choosing meaningfull ones from all 
//         //possible options, if agents reaches a wall reset it's coordinates to
//         //initial values. If agent's coordinates does not change -- continue un-
//         //till first change appears -- to avoid "trotting" in one place
//         do{
//             x=tempCurrentStage.getX();
//             y=tempCurrentStage.getY();
//             int direction=(int)Math.round(1+3*Math.random());
//             switch(direction){
//                case 1:
//                    y=y+50;
//                    break;
//                case 2: 
//                    y=y-50;
//                    break;
//                case 3:
//                    x=x-50;
//                    break;
//                case 4:
//                    x=x+50;
//                    break;  
//            } 
//             if(x==100 && (y==50 || y==150 || y==250 || y==350)){
//                 x=tempCurrentStage.getX();
//                 y=tempCurrentStage.getY();
//             }
//                     
//             //System.out.println("Agent moves to i="+direction+"   "+ x+"   "+y);
//             
//         }while(!(((x>=0)&&(x<=100))&&((y>=0)&&(y<=350)))||(x==tempCurrentStage.getX()&& y==tempCurrentStage.getY()));
//         //System.out.println("X="+x+"       Y="+y);
//         
//         //set corresponding reward values
//         if(x==100 && (y==0 || y==100 || y==200 || y==300))
//             tempCurrentStage=new Stage(10,10,x,y);
//         else
//             tempCurrentStage=new Stage(-1,-1,x,y);
//         
//         return tempCurrentStage;
//     }
//     
     ///////////////////////////////////////////////////////////////////////////
     
     /*
      * Search for set of available actions
      */
     ArrayList<Integer> findSetOfActions(Stage currentState){
         ArrayList<Integer> setOfActions = new ArrayList<>();
         for(Stage neighborStage: setOfStates){
                //UP
                if(neighborStage.getX()==currentState.getX() && neighborStage.getY()==currentState.getY() -50 && !neighborStage.isClosed()){
                    
                    setOfActions.add(0);
                }
                //DOWN    
                if(neighborStage.getX()==currentState.getX() && neighborStage.getY()==currentState.getY() +50 && !neighborStage.isClosed() ){
                    
                    setOfActions.add(1);
                }  
                //LEFT
                if(neighborStage.getX()==currentState.getX()+50 && neighborStage.getY()==currentState.getY() && !neighborStage.isClosed()){
                    
                    setOfActions.add(2);
                }
                //RIGHT
                if(neighborStage.getX()==currentState.getX()-50 && neighborStage.getY()==currentState.getY() && !neighborStage.isClosed()){
                    
                    setOfActions.add(3);
                }   
            }
         return setOfActions;
     }
//     ///////////////////////////////////////////////////////////////////////////
//     /*
//      * Find current action taken
//      */
//     public int findCurrentActionTaken(Stage currentState){
//         int currentAction=0;
//         //find current action taken
//         if(currentState.getX()==startStage.getX() && currentState.getY()<startStage.getY())
//                currentAction=0;
//         if(currentState.getX()==startStage.getX() && currentState.getY()>startStage.getY())
//                currentAction=1;
//         if(currentState.getX()<startStage.getX() && currentState.getY()==startStage.getY())
//                currentAction=2;
//        if(currentState.getX()>startStage.getX() && currentState.getY()==startStage.getY())
//                currentAction=3;
//        return currentAction;
//     }
//     
      /*
      * searchState looks for next state
      */
     public Stage searchStage(Stage tempCurrentStage){
         int x=tempCurrentStage.getX();
         int y=tempCurrentStage.getY();
         //compute next stage's coordinates choosing meaningfull ones from all 
         //possible options, if agents reaches a wall reset it's coordinates to
         //initial values. If agent's coordinates does not change -- continue un-
         //till first change appears -- to avoid "trotting" in one place
         do{
             x=tempCurrentStage.getX();
             y=tempCurrentStage.getY();
             int direction=(int)Math.round(1+3*Math.random());
             switch(direction){
                case 1:
                    y=y+50;
                    break;
                case 2: 
                    y=y-50;
                    break;
                case 3:
                    x=x-50;
                    break;
                case 4:
                    x=x+50;
                    break;  
            } 
             if(x==100 && (y==50 || y==150 || y==250 || y==350)){
                 x=tempCurrentStage.getX();
                 y=tempCurrentStage.getY();
             }
                     
             System.out.println("i="+direction+"   "+ x+"   "+y);
         }while(!(((x>=0)&&(x<=100))&&((y>=0)&&(y<=350)))||(x==tempCurrentStage.getX()&& y==tempCurrentStage.getY()));
         System.out.println("X="+x+"       Y="+y);
         
         //set corresponding reward values
         if(x==100 && (y==0 || y==100 || y==200 || y==300))
             tempCurrentStage=new Stage(10,10,x,y);
         else
             tempCurrentStage=new Stage(-1,-1,x,y);
         
         return tempCurrentStage;
     }
     
     ///////////////////////////////////////////////////////////////////////////
     
     /*
      * Search for neighboring states indeces
      */
//     ArrayList<Integer> findNeighboringStatesIndices(Stage currentState){
//         ArrayList<Integer> setOfStateIndices = new ArrayList<>();
//         //find neighboring stages indeces
//            for(Stage neighborStage: setOfStates){
//                //UP
//                if(neighborStage.getX()==currentState.getX() && neighborStage.getY()==currentState.getY() -50 && !neighborStage.isClosed()){
//                    
//                    setOfStateIndices.add(searchStateIndex(neighborStage));
//                    
//                }
//                //DOWN    
//                if(neighborStage.getX()==currentState.getX() && neighborStage.getY()==currentState.getY() +50 && !neighborStage.isClosed() ){
//                    
//                    setOfStateIndices.add(searchStateIndex(neighborStage));
//                    
//                }  
//                //LEFT
//                if(neighborStage.getX()==currentState.getX()-50 && neighborStage.getY()==currentState.getY() && !neighborStage.isClosed()){
//                    
//                    setOfStateIndices.add(searchStateIndex(neighborStage));
//                    
//                }
//                //RIGHT
//                if(neighborStage.getX()==currentState.getX()+50 && neighborStage.getY()==currentState.getY() && !neighborStage.isClosed()){
//                    
//                    setOfStateIndices.add(searchStateIndex(neighborStage));
//                    
//                }   
//            }
//         return setOfStateIndices;
//     }
     ///////////////////////////////////////////////////////////////////////////
     
     /*
      * Search for neighboring states
      */
     ArrayList<Stage> findNeighboringStates(Stage currentState){
         ArrayList<Stage> setOfNeighbors = new ArrayList<>();
         //find neighboring stages
         for(Stage neighborStage: setOfStates){
                //UP
                if(neighborStage.getX()==currentState.getX() && neighborStage.getY()==currentState.getY() -50 && !neighborStage.isClosed()){
                    setOfNeighbors.add(neighborStage);
                    
                }
                //DOWN    
                if(neighborStage.getX()==currentState.getX() && neighborStage.getY()==currentState.getY() +50 && !neighborStage.isClosed() ){
                    setOfNeighbors.add(neighborStage);
                    
                }  
                //LEFT
                if(neighborStage.getX()==currentState.getX()-50 && neighborStage.getY()==currentState.getY() && !neighborStage.isClosed()){
                    setOfNeighbors.add(neighborStage);
                    
                }
                //RIGHT
                if(neighborStage.getX()==currentState.getX()+50 && neighborStage.getY()==currentState.getY() && !neighborStage.isClosed()){
                    setOfNeighbors.add(neighborStage);
                    
                }   
            }
         return setOfNeighbors;
     }
     
     /*
      * searchClosestState looks for next state, that is close to the goal stage
      * -- moves only to goal stage along x axis
      */
//     public Stage searchClosestStage(Stage tempCurrentStage){
//         int x=tempCurrentStage.getX();
//         int y=tempCurrentStage.getY();
//         //compute next stage's coordinates choosing meaningfull ones from all 
//         //possible options, if agents reaches a wall reset it's coordinates to
//         //initial values. If agent's coordinates does not change -- continue un-
//         //till first change appears -- to avoid "trotting" in one place
//         do{
//             x=tempCurrentStage.getX();
//             y=tempCurrentStage.getY();
//             int direction=(int)Math.round(1+2*Math.random());
//             switch(direction){
//                case 1:
//                    y=y+50;
//                    break;
//                case 2: 
//                    y=y-50;
//                    break;
//                case 3:
//                    x=x-50;
//                    break;
//                 
//            } 
//             if(x==100 && (y==50 || y==150 || y==250 || y==350)){
//                 x=tempCurrentStage.getX();
//                 y=tempCurrentStage.getY();
//             }
//             if(tempCurrentStage.isClosed()) 
//                 x=x-50;        
//             System.out.println("i="+direction+"   "+ x+"   "+y);
//         }while(!(((x>=0)&&(x<=100))&&((y>=0)&&(y<=350)))||(x==tempCurrentStage.getX()&& y==tempCurrentStage.getY()));
//         System.out.println("X="+x+"       Y="+y);
//         
//         //set corresponding reward values
//         if(x==100 && (y==0 || y==100 || y==200 || y==300))
//             tempCurrentStage=new Stage(10,10,x,y);
//         else
//             tempCurrentStage=new Stage(-1,-1,x,y);
//         
//         return tempCurrentStage;
//     }
     ///////////////////////////////////////////////////////////////////////////
     /*
      * Search for state's index in list of given states
      */
     public int searchStateIndex(Stage currentState){
         int i=0;
         int index =0;
         for(i=0;i<setOfStates.length;i++){
                 if((currentState.getX()==setOfStates[i].getX())&&(currentState.getY()==setOfStates[i].getY()))
                 {
                     index=i;
                     break;
                 
                }
             }
         return index;
     }
     
     ///////////////////////////////////////////////////////////////////////////
     /*
      * Initialize q matrix
      */
     public double[][] initializeQMatrix(double value){
        
          for(int i=0;i<qValuesMatrix.length;i++){
             for(int j=0;j<qValuesMatrix[i].length;j++)
                 qValuesMatrix[i][j]=value;
         }
          return qValuesMatrix;
     }
     ///////////////////////////////////////////////////////////////////////////
     /*
      * Print q matrix
      */
     public void printQMatrix(){
         //printing q matrix 
         System.out.println("States        UP    DOWN    LEFT   RIGHT");
          for(int i=0;i<qValuesMatrix.length;i++){
              System.out.printf("%4d    ",i);
             for(int j=0;j<qValuesMatrix[i].length;j++)
                 System.out.printf("%8.1f",qValuesMatrix[i][j]);
             System.out.println();
         }
          
    }
}
