package algorithms.backtracking;

import java.util.Scanner;

public class Nqueens {
    private static int N;
    public static void main(String[] args){
        System.out.println("Size of chess board: ");
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[][] board = new int[N][N];
        if(!solveNqueue(board, 0)){
            System.out.println("Solution does not exist");
        } else {
            printSolution(board);
        }
    }

    private static void printSolution(int[][] board) {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]);
                if(j!=N-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static boolean solveNqueue(int[][] board, int column) {
        if(column >= N){
            return true;
        }
        for(int row=0;row<N;row++){
            if(isSafe(board,row,column)){
                board[row][column] = 1;
                if(solveNqueue(board,column+1)){
                    return true;
                }
                board[row][column] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] board, int row, int column) {
        /* check if the queen is present in the row on the left side */
        for(int i=0;i<column;i++){
            if(board[row][i]==1){
                return false;
            }
        }

        /* check if the queen is present in the upper diagonal on the left side */
        for(int i=row,j=column;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }

        /* check if the queen is present in the lower diagonal om the left side */
        for(int i=row,j=column;i<N && j>=0;i++,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
