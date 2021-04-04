import logic.BoardLogic;
import pojo.Board;
import solver.Solver;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Write board notation to parse, 'W' for wall, 'O' for ball, 'B' for basket," +
                    " any other string for empty space, separate line with '/' ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")){
                break;
            }
            Board board = BoardLogic.stringNotationToBoard(input);
            System.out.println("Input board is: ");
            BoardLogic.printBoard(board);
            System.out.println("Solution is: ");
            System.out.println(Solver.solve(board));
            System.out.println("Write another board or type 'exit' to exit");
        }



    }
}
