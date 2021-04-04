import logic.BoardLogic;
import logic.GameLogic;
import logic.MovementLogic;
import org.javatuples.Pair;
import pojo.Board;
import solver.Solver;

import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        Board board = BoardLogic.initSampleBoard();
        Board tmp = BoardLogic.initSampleBoard();

//        BoardLogic.printBoard(board);

        System.out.println(Solver.solve(board));

//
//        Set<Pair<Board, String>> test = Solver.getNextStates(board);
//
//        for (Pair<Board, String> data : test) {
//            BoardLogic.printBoard(data.getValue0());
//            System.out.println("--------------");
//        }

//        Pair<Board, String> first = Pair.with(board, "right");
//        Pair<Board, String> second = Pair.with(board, "right");
//
//        Set<Pair<Board, String>> set = new HashSet<>();
//
//        set.add(first);
//        set.add(second);
//
//        System.out.println(set.size());



//        System.out.println(Solver.solve(board));

//        Set<Board> boardSet = Solver.getNextStates(board);
//        for (Board board1 : boardSet) {
//            BoardLogic.printBoard(board1);
//            System.out.println("----------");
//        }
    }
}
