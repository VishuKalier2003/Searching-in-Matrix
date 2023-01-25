/* You are given an m x n integer matrix matrix with the following two properties:
* Each row is sorted in non-decreasing order...
* The first integer of each row is greater than the last integer of the previous row...
Given an integer target, return true if target is in matrix or false otherwise...
  * Eg 1: matrix = [[1,3,5,7],[11,15,16,20],[30,34,56,60]]       target = 3       Output = true
  * Eg 2: matrix = [[1,3,5,7],[11,15,16,20],[30,34,56,60]]       target = 12      Output = false
 */
import java.util.*;
public class Matrices
{
    public boolean Search(int matrix[][], int target)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0, col = cols-1;
        while(row < rows && col > -1)     // While we are within the 2d matrix...
        {
            int current = matrix[row][col];   // Current the rightmost matrix of current row...
            if(current == target)
                return true;        // If target found...
            if(target > current)
                row++;
            else 
                col--;
        }
        return false;     // If search was unsuccessful...
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int m, n;
        System.out.print("Enter the number of rows (n) : ");
        n = sc.nextInt();
        System.out.print("Enter the number of columns (m) : ");
        m = sc.nextInt();
        int matrix[][] = new int[n][m];
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print("Enter data of "+(i+1)+" row and "+(j+1)+" column : ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the target to be searched : ");
        n = sc.nextInt();
        Matrices matrices = new Matrices();     // Object creation...
        System.out.println("The number present is : "+matrices.Search(matrix, n));
        sc.close();
    }
}

// Time Complexity  - O(m+n) time...
// Space Complexity - O(1) space...

/* DEDUCTIONS :- 
 * 1. The rightmost value of every row is the largest...
 * 2. Creating the indices for the starting and ending position of a row we can binary search row wise and then, we can binary search column wise...
*/