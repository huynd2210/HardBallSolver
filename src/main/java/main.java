import logic.BoardLogic;
import logic.GameLogic;
import pojo.Board;

public class main {
    public static void main(String[] args) {
        Board board = BoardLogic.initSampleBoard();

        BoardLogic.printBoard(board);
        System.out.println("-------------");

        board = GameLogic.moveLeft(board);
        BoardLogic.printBoard(board);
    }
}
