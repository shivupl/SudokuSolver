import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Solver 
{
//    private static int[][] grid = {
//			{9,0,0,1,0,0,0,0,5},
//			{0,0,5,0,9,0,2,0,1},
//			{8,0,0,0,4,0,0,0,0},
//			{0,0,0,0,8,0,0,0,0},
//			{0,0,0,7,0,0,0,0,0},
//			{0,0,0,0,2,6,0,0,9},
//			{2,0,0,3,0,0,0,0,6},
//			{0,0,0,2,0,0,9,0,0},
//			{0,0,1,9,0,4,5,7,0},
//	};
    
    private static int[][] grid = new int[9][9];
    
    
    
    private static void fill() throws FileNotFoundException
    {
        String fileName = JOptionPane.showInputDialog("Enter File Name:");
        File inFile = new File(fileName);
        Scanner sc = new Scanner(inFile);
        for(int k = 0; k < grid.length; k++)
        {
            for(int i = 0; i < grid.length; i++)
            {
                int temp = sc.nextInt();
                grid[k][i] = temp;
            }
        }
    }
    public static boolean solve() 
    {
        for (int k = 0; k < grid.length; k++) 
        {
            for (int i = 0; i < grid.length; i++) 
            {
                if (grid[k][i] == 0) 
                {
                    int temp = 1;
                    while(temp <= 9)
                    {
                        if (check(temp, k ,i) == true) 
                        {
                            grid[k][i] = temp;

                            if (solve() == true)
                            { 
                                return true;
                            } 
                            else
                            { 
                                grid[k][i] = 0;
                            }
                        }
                        temp++;
                    }

                    return false; 
                }
            }
        }
        return true;
    }

    
    public static boolean check(int num, int x, int y)
    {
        //checking row
        for(int k = 0; k < grid.length; k++)
        {
            if(grid[x][k] == num)
            {
                return false;
            }
        }
        
        //checking col
        for(int i = 0; i < grid.length; i++)
        {
            if(grid[i][y] == num)
            {
                return false;
            }
        }
        
        //checking box
        for(int p = 0; p < 3; p++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(grid[p+((x/3)*3)][j+((y/3)*3)] == num)
                {
                    return false;
                }
            }
        }

        return true;
    }

    public static void print()
    {
        System.out.println("");
        for(int k = 0; k < grid.length; k++)
        {
            for(int i = 0; i < grid.length; i++)
            {
                System.out.print(grid[k][i] + " ");
            }
            System.out.println("");
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException
    {
        fill();
        //solve();
        print();
    }

}
