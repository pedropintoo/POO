package SUDOKU;
import java.util.Date;

public class Main {
    private static int GRID_SIZE = 9;
    public static void main(String[] args) throws InterruptedException {

        int[][] board = {
                {3, 0, 0, 0, 0, 1, 0, 2, 0},
                {9, 0, 0, 5, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 6, 8, 0},
                {0, 0, 7, 0, 5, 0, 8, 0, 0},
                {0, 0, 0, 0, 6, 3, 0, 0, 0},
                {0, 0, 5, 9, 0, 4, 0, 3, 0},
                {0, 0, 1, 2, 0, 9, 7, 0, 0},
                {0, 5, 0, 0, 0, 0, 0, 0, 3},
                {0, 0, 0, 7, 0, 0, 0, 1, 0}
        };

        if(solveBoard(board)){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Solved :) ");
            printBoard(board);
        }
        else {
            System.out.println("Unsolvable :( ");
        }

    }

    private static void printBoard(int[][] board) {
        // Classic form
        System.out.println();
        for (int row = 0; row < GRID_SIZE; row++){
            for (int column = 0; column < GRID_SIZE; column++){
                System.out.print(board[row][column]+"  ");
                if((column+1)%3 == 0 && column != GRID_SIZE-1){
                    System.out.print("|  ");
                }
            }
            System.out.println();
            if((row+1)%3 == 0 && row != GRID_SIZE-1){
                System.out.print("-------------------------------");
                System.out.println();
            }
        }
        System.out.println();

        // Terminal form :D

//        System.out.print(
//                 "\n\n"+   board[0][0]+"  "+board[0][1]+"  "+board[0][2]+"  |  "+board[0][3]+"  "+board[0][4]+"  "+board[0][5]+"  |  "+board[0][6]+"  "+board[0][7]+"  "+board[0][8]
//                +"\n"+   board[1][0]+"  "+board[1][1]+"  "+board[1][2]+"  |  "+board[1][3]+"  "+board[1][4]+"  "+board[1][5]+"  |  "+board[1][6]+"  "+board[1][7]+"  "+board[1][8]
//                +"\n"+   board[2][0]+"  "+board[2][1]+"  "+board[2][2]+"  |  "+board[2][3]+"  "+board[2][4]+"  "+board[2][5]+"  |  "+board[2][6]+"  "+board[2][7]+"  "+board[2][8]
//                +"\n-------------------------------"
//                +"\n"+   board[3][0]+"  "+board[3][1]+"  "+board[3][2]+"  |  "+board[3][3]+"  "+board[3][4]+"  "+board[3][5]+"  |  "+board[3][6]+"  "+board[3][7]+"  "+board[3][8]
//                +"\n"+   board[4][0]+"  "+board[4][1]+"  "+board[4][2]+"  |  "+board[4][3]+"  "+board[4][4]+"  "+board[4][5]+"  |  "+board[4][6]+"  "+board[4][7]+"  "+board[4][8]
//                +"\n"+   board[5][0]+"  "+board[5][1]+"  "+board[5][2]+"  |  "+board[5][3]+"  "+board[5][4]+"  "+board[5][5]+"  |  "+board[5][6]+"  "+board[5][7]+"  "+board[5][8]
//                +"\n-------------------------------"
//                +"\n"+   board[6][0]+"  "+board[6][1]+"  "+board[6][2]+"  |  "+board[6][3]+"  "+board[6][4]+"  "+board[6][5]+"  |  "+board[6][6]+"  "+board[6][7]+"  "+board[6][8]
//                +"\n"+   board[7][0]+"  "+board[7][1]+"  "+board[7][2]+"  |  "+board[7][3]+"  "+board[7][4]+"  "+board[7][5]+"  |  "+board[7][6]+"  "+board[7][7]+"  "+board[7][8]
//                +"\n"+   board[8][0]+"  "+board[8][1]+"  "+board[8][2]+"  |  "+board[8][3]+"  "+board[8][4]+"  "+board[8][5]+"  |  "+board[8][6]+"  "+board[8][7]+"  "+board[8][8]
//
//        );



    }

    private static boolean isNumberInRow(int[][] board, int number, int row){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[i][column] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column){
        int rowBox = (int) Math.floor(row / 3) * 3;;
        int columnBox = (int) Math.floor(column / 3) * 3;
        for( int i = rowBox; i < rowBox+3; i++){
            for( int j = columnBox; j < columnBox+3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int column){
        return !isNumberInRow(board, number, row) &&
               !isNumberInColumn(board, number, column) &&
               !isNumberInBox(board, number, row, column);
    }

    private static boolean solveBoard(int[][] board) throws InterruptedException {
        for(int row = 0; row < GRID_SIZE; row++){
            for(int column = 0; column < GRID_SIZE; column++){
                if(board[row][column] == 0){
                    for(int i = 1; i < GRID_SIZE+1; i++){

                        if(isValidPlacement(board, i, row, column)){
                            board[row][column] = i;


                            if(solveBoard(board)){

                                return true;
                            }
                            else {
                                board[row][column] = 0;

                                // PRINT CHANGES IN TERMINAL
                                //Thread.sleep(2);
                                //printBoard(board);
                            }
                        }
                    }
                    return false;
                }
            }

        }

        return true;

    }

}
