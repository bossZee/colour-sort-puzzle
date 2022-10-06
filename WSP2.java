/**
 *
 * @author Zinhle
 */
import java.util.*;
public class WSP2 {

    static Character red= new Character('r');
    static Character blue= new Character('b');
    static Character yellow= new Character('y');
    
    static StackAsMyArrayList[] bottles=new StackAsMyArrayList[5];
    
    public static void ShowAll(){
        for(int i=0; i<5; i++){
            System.out.println("Bottle "+i+": "+bottles[i].toString());
        }
    }
    
    static StackAsMyArrayList<Character> colourFills= new StackAsMyArrayList<Character>();
    
    public static void fillBottles(){
        int rCount=0, bCount=0, yCount=0;
        Random rand=new Random();
        while(colourFills.getStackSize()!=12){
            int int_random=rand.nextInt(3);
            if(int_random==0){
                if(rCount<4){
                    colourFills.push(red);
                    rCount++;
                }else continue;
            }else if(int_random==1){
                if(bCount<4){
                    colourFills.push(blue);
                    bCount++;
                }else continue;
            }else if(int_random==2){ 
                if(yCount<4){
                    colourFills.push(yellow);
                    yCount++;
                }else continue;
            }
         }
       
        while(colourFills.getStackSize()!=0){
            int indexRand=rand.nextInt(3);
            if(bottles[indexRand].getStackSize()<4)
                bottles[indexRand].push(colourFills.pop());
            else continue;
        }
    }
    
    public static boolean solved(StackAsMyArrayList[] bottles){
       int bottlesSolved=0;
        for(int i=0; i<5; i++){
           if(bottles[i].getStackSize()==4){
               bottles[i].checkStackUniform();
               if(bottles[i].checkStackUniform()==true) 
                   bottlesSolved++;
           }else continue;
       }
        if(bottlesSolved==3) return true;
        else return false;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StackAsMyArrayList<Character> tube1= new StackAsMyArrayList<Character>();
        
        for(int i=0; i<5; i++)
            bottles[i]= new StackAsMyArrayList<Character>();
        
       System.out.println("\nWater Sort Puzzle Part 2");
       System.out.println("Randomly fill bottles");
       
       fillBottles();
       ShowAll();
       solved(bottles);
       
       System.out.println("\nWater Sort Puzzle Part 3: Play Game");
       
       while(solved(bottles)!=true){
           Scanner input=new Scanner(System.in);
           int move, target;
           System.out.println("\nMove from which bottle: ");
           move=input.nextInt();
           
           while(bottles[move].getStackSize()==0){
               System.out.println("Bottle is Empty. Try again. ()");
               System.out.println("Move from tube: ");
               move=input.nextInt();
           }
           
           System.out.println("Target bottle: ");
           target=input.nextInt();
           
           while(bottles[target].getStackSize()==4){
               System.out.println("Bottle is full. Try again.");
               System.out.println("Target bottle: ");
               target=input.nextInt();
           }
           
           //bottles[target].push(bottles[move].pop());
           
           while(bottles[target].peek()!=bottles[move].peek() && bottles[target].getStackSize()!=0){
               System.out.println("Colours do not match. Try again.");
               System.out.println("Target bottle: ");
               target=input.nextInt();
           }
           
           bottles[target].push(bottles[move].pop());
           
           while(bottles[target].peek()==bottles[move].peek() && bottles[target].getStackSize()!=4){
               bottles[target].push(bottles[move].pop()); 
           }
           System.out.println("\n");
           ShowAll();
       }
       System.out.println("\nCongratulations!\nYou won the game!");
        
    }
}
    



