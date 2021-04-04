package solver;

import logic.MovementLogic;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import pojo.Board;

import java.util.*;

public class Solver {
    public static Set<Pair<Board, String>> getNextStates(Board board) {
        Set<Pair<Board, String>> nextStates = new HashSet<>();
        nextStates.add(Pair.with(MovementLogic.moveRight(board), "right"));
        nextStates.add(Pair.with(MovementLogic.moveLeft(board), "left"));
        nextStates.add(Pair.with(MovementLogic.moveUp(board), "up"));
        nextStates.add(Pair.with(MovementLogic.moveDown(board), "down"));
        nextStates.removeIf(data -> data.getValue0().equals(board));
        return nextStates;
    }

    public static List<String> solve(Board board){
        List<String> moveList = new ArrayList<>();
        List<Pair<Board, String>> childStates = new ArrayList<>(getNextStates(board));
        List<Triplet<Board, String, List<String>>> stateData = new ArrayList<>();

        for (Pair<Board, String> pairData : childStates) {
            stateData.add(pairData.addAt2(moveList));
        }
        while(!stateData.isEmpty()){
            Triplet<Board, String, List<String>> data = stateData.get(0);
            data = data.setAt2(new ArrayList<>(data.getValue2()));
            data.getValue2().add(data.getValue1());

            int ballLocation = MovementLogic.findBallLocation(data.getValue0()).getValue0();
            if (ballLocation == -1) { //Ball not found
                return data.getValue2();
            }

            childStates = new ArrayList<>(getNextStates(data.getValue0()));
            for (Pair<Board, String> childState : childStates) {
                Triplet<Board, String, List<String>> nextData = childState.addAt2(new ArrayList<>(data.getValue2()));
                stateData.add(nextData);
            }
            stateData.remove(0);
        }
        System.out.println("Illegal return");
        return null;
    }
}
