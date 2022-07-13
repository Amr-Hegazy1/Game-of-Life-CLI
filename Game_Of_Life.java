import java.util.*;
import java.lang.Thread;  
public class Game_Of_Life {
    public static void main(String[] args){
        int rows = Integer.parseInt(args[0]);
        int columns = Integer.parseInt(args[1]);
        int[][] world = new int[rows][columns];
        
        if (args.length == 2){
            generateWorld(world);
            while (true){
                display(world);
                System.out.println();
                try{
                    Thread.sleep(2000);
                }catch(Exception e){
                    System.out.println("error");
                }
                nextGeneration(world);
            }
        }else
            System.out.println("Please enter two arguments");
       
    

    }

    public static void generateWorld(int[][] world){
        for (int i = 0;i<world.length;i++)
            for(int j = 0;j<world[i].length;j++)
                world[i][j] = (int) Math.round(Math.random());
    }

    public static void display(int[][] world){
        for(int i = 0;i<world.length;i++)
            System.out.println(Arrays.toString(world[i]));
            
        
    }

    

    public static void nextGeneration(int[][] world){
        int[][] augmentWorld = augmentWorld(world);

        for (int i = 0;i<world.length;i++)
            for(int j = 0;j<world[i].length;j++){
                if (augmentWorld[i][j] == -3 || augmentWorld[i][j] == 2 || augmentWorld[i][j] == 3)
                    world[i][j] = 1;
                else
                    world[i][j] = 0;
            }
                
        
    }

   public static int[][] augmentWorld(int[][] world){
        int rows = world.length;
        int cols = world[0].length;
        int[][] res = new int[rows][cols];

        int count;

        for(int i = 0;i<rows;i++){
            
            for(int j = 0;j<cols;j++){
                count = 0;
                if (j != cols-1 && world[i][j+1] == 1)
                    count = (world[i][j] == 0)? count-1:count+1;
                if (j != 0 && world[i][j-1] == 1)
                    count = (world[i][j] == 0)? count-1:count+1;
                if (i != rows-1 && world[i+1][j] == 1)
                    count = (world[i][j] == 0)? count-1:count+1;
                if (i != 0 && world[i-1][j] == 1)
                    count = (world[i][j] == 0)? count-1:count+1;
                if (i != rows-1 && j != cols-1 && world[i+1][j+1] == 1)
                    count = (world[i][j] == 0)? count-1:count+1;
                if (i != 0 && j != 0 && world[i-1][j-1] == 1)
                    count = (world[i][j] == 0)? count-1:count+1;
                if (i != rows-1 && j != 0 && world[i+1][j-1] == 1)
                    count = (world[i][j] == 0)? count-1:count+1;
                if (i != 0 && j != cols-1 && world[i-1][j+1] == 1)
                    count = (world[i][j] == 0)? count-1:count+1;
                
                res[i][j] = count;

                
            }
        }
        


        return res;
   }

}
