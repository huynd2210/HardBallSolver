package logic;

import org.javatuples.Pair;
import pojo.Board;
import pojo.Cell;
import pojo.Item;

public class GameLogic {
    public static Board moveLeft(Board board){
        Pair<Board, Boolean> isLeftMoved = moveLeftOnce(board);
        while (Boolean.TRUE.equals(isLeftMoved.getValue1())){
            isLeftMoved = moveLeftOnce(isLeftMoved.getValue0());
        }
        return isLeftMoved.getValue0();
    }

    private static Pair<Board, Boolean> moveLeftOnce(Board input) {
        Board board = new Board(input);

        Pair<Integer, Integer> ballLocation = findBallLocation(board);
        Pair<Integer, Integer> basketLocation = findBasketLocation(board);

        int ballIndexI = ballLocation.getValue0();
        int ballIndexJ = ballLocation.getValue1();

        int basketIndexI = basketLocation.getValue0();
        int basketIndexJ = basketLocation.getValue1();

        boolean isBallMoved = false;
        boolean isBasketMoved = false;

        if (isInBound(ballIndexI, ballIndexJ - 1, board.getSizeI(), board.getSizeJ())) {
            if (board.getCells()[ballIndexI][ballIndexJ - 1].getItem() == null){
                swapElement(board, ballIndexI, ballIndexJ, ballIndexI, ballIndexJ - 1);
                isBallMoved = true;
            }
        }

        if (isInBound(basketIndexI, basketIndexJ - 1, board.getSizeI(), board.getSizeJ())) {
            if (board.getCells()[basketIndexI][basketIndexJ - 1].getItem() == null){
                swapElement(board, basketIndexI, basketIndexJ, basketIndexI, basketIndexJ - 1);
                isBasketMoved = true;
            }
        }

        return Pair.with(board, isBallMoved || isBasketMoved);
    }

    private static void swapElement(Board board, int firstI, int firstJ, int secondI, int secondJ){
        Cell tmp = new Cell(board.getCells()[firstI][firstJ]);
        board.getCells()[firstI][firstJ] = new Cell(board.getCells()[secondI][secondJ]);
        board.getCells()[secondI][secondJ] = tmp;
    }


    private static boolean isInBound(int indexI, int indexJ, int maxI, int maxJ) {
        return (indexI >= 0 && indexJ >= 0) && (indexI < maxI && indexJ < maxJ);
    }


    private static Pair<Integer, Integer> findBallLocation(Board board) {
        for (int i = 0; i < board.getSizeI(); i++) {
            for (int j = 0; j < board.getSizeJ(); j++) {
                if (board.getCells()[i][j].getItem() == Item.BALL) {
                    return Pair.with(i,j);
                }
            }
        }
        System.out.println("yo ball not exists");
        return null;
    }

    private static Pair<Integer, Integer> findBasketLocation(Board board) {
        for (int i = 0; i < board.getSizeI(); i++) {
            for (int j = 0; j < board.getSizeJ(); j++) {
                if (board.getCells()[i][j].getItem() == Item.BASKET) {
                    return Pair.with(i,j);
                }
            }
        }
        System.out.println("yo basket not exists");
        return null;
    }
}

