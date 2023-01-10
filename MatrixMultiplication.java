import java.util.*;
public class MatrixMultiplication{
     public static void main(String args[]){
    Scanner input =new Scanner(System.in);
     int m = input.nextInt();int n = input.nextInt();int p = input.nextInt();
     int[][] matrix1=new int[m][n];
     int[][] matrix2=new int[n][p];
     int[][] matrix3=new int[m][p];
     for(int a=0;a<m;a++){
        for (int b = 0;b<n;b++){
            matrix1[a][b]=input.nextInt();
        }
     }
     for(int a=0;a<n;a++){
        for (int b=0;b<p;b++){
            matrix2[a][b]=input.nextInt();
        }
     }
    for(int a=0;a<m;a++){
        for(int b=0;b<p;b++){
            for(int c=0;c<n;c++){
            matrix3[a][b]+=matrix1[a][c]*matrix2[c][b];
            }
        }
    }
    System.out.println(m+" "+p);
    for(int a=0;a<m;a++){
        for (int b = 0;b<p;b++){
        if (b==p-1) System.out.println(matrix3[a][b]);
        else System.out.print(matrix3[a][b]+" ");
        }
     }
    } }