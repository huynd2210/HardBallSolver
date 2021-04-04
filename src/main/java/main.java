import logic.BoardLogic;
import pojo.Board;
import solver.Solver;

public class main {
    public static void main(String[] args) {
        Board board = BoardLogic.stringNotationToBoard("W.../W.W./..../O.B.");

        System.out.println(Solver.solve(board));

    }
}
