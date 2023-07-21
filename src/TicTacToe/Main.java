package TicTacToe;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        run();
    }

    static void run() {
        Field table = new Field();
        byte moves = 0;
        Scanner in = new Scanner(System.in);

        do {
            table.printField();
            int move = in.nextInt();
            if ((moves % 2 == 0) && (table.cells[(move - 1) / 3][(move - 1) % 3].statement != 'x' && table.cells[(move - 1) / 3][(move - 1) % 3].statement != 'o')){
                table.cells[(move - 1) / 3][(move - 1) % 3].statement = 'x';
                moves++;
            } else if ((moves % 2 != 0) && (table.cells[(move - 1) / 3][(move - 1) % 3].statement != 'x' && table.cells[(move - 1) / 3][(move - 1) % 3].statement != 'o')){
                table.cells[(move - 1) / 3][(move - 1) % 3].statement = 'o';
                moves++;
            }
        } while (!gameEnd(table.cells));
        table.printField();
    }

    static boolean gameEnd(Cell[][] cells){
        if ((cells[0][0].statement == cells[0][1].statement && cells[0][1].statement == cells[0][2].statement) && (cells[0][0].statement != '.')) return true;
        else if ((cells[1][0].statement == cells[1][1].statement && cells[1][1].statement == cells[1][2].statement) && (cells[1][0].statement != '.')) return true;
        else if ((cells[2][0].statement == cells[2][1].statement && cells[2][1].statement == cells[2][2].statement) && (cells[2][0].statement != '.')) return true;
        else if ((cells[0][0].statement == cells[1][0].statement && cells[1][0].statement == cells[2][0].statement) && (cells[0][0].statement != '.')) return true;
        else if ((cells[0][1].statement == cells[1][1].statement && cells[1][1].statement == cells[2][1].statement) && (cells[0][1].statement != '.')) return true;
        else if ((cells[0][2].statement == cells[1][2].statement && cells[1][2].statement == cells[2][2].statement) && (cells[0][2].statement != '.')) return true;
        else if ((cells[0][0].statement == cells[1][1].statement && cells[1][1].statement == cells[2][2].statement) && (cells[0][0].statement != '.')) return true;
        else return (cells[2][0].statement == cells[1][1].statement && cells[1][1].statement == cells[0][2].statement) && (cells[2][0].statement != '.');
    }

    static class Cell{
        char statement;
        Cell(char state){
            this.statement = state;
        }
    }

    static class Field{
        Cell[][] cells = new Cell[3][3];
        {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    this.cells[i][j] = new Cell('.');
                }
            }
        }

        void printField(){
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    System.out.printf("%s | ",this.cells[i][j].statement);
                }
                System.out.print('\n');
            }
        }
    }
}