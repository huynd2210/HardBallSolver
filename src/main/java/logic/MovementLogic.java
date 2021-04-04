package logic;

import org.javatuples.Pair;
import pojo.Board;
import pojo.Cell;
import pojo.Item;

public class MovementLogic {

    public static Board moveRight(Board board) {
        Pair<Board, Boolean> isRightMoved = moveRightOnce(board);
        while (Boolean.TRUE.equals(isRightMoved.getValue1())) {
            isRightMoved = moveRightOnce(isRightMoved.getValue0());
        }
        return isRightMoved.getValue0();
    }

    public static Board moveLeft(Board board) {
        Pair<Board, Boolean> isLeftMoved = moveLeftOnce(board);
        while (Boolean.TRUE.equals(isLeftMoved.getValue1())) {
            isLeftMoved = moveLeftOnce(isLeftMoved.getValue0());
        }
        return isLeftMoved.getValue0();
    }

    public static Board moveUp(Board board) {
        Pair<Board, Boolean> isUpMoved = moveUpOnce(board);
        while (Boolean.TRUE.equals(isUpMoved.getValue1())) {
            isUpMoved = moveUpOnce(isUpMoved.getValue0());
        }
        return isUpMoved.getValue0();
    }

    public static Board moveDown(Board board) {
        Pair<Board, Boolean> isDownMoved = moveDownOnce(board);
        while (Boolean.TRUE.equals(isDownMoved.getValue1())) {
            isDownMoved = moveDownOnce(isDownMoved.getValue0());
        }
        return isDownMoved.getValue0();
    }

    private static Pair<Board, Boolean> moveDownOnce(Board input){
        Board board = new Board(input);
        Pair<Integer, Integer> ballLocation = findBallLocation(board);
        Pair<Integer, Integer> basketLocation = findBasketLocation(board);

        int ballIndexI;
        boolean isBallMoved = false;
        if (ballLocation.getValue0() != -1){
            ballIndexI = ballLocation.getValue0();
            int ballIndexJ = ballLocation.getValue1();
            if (isInBound(ballIndexI + 1, ballIndexJ, board.getSizeI(), board.getSizeJ())) {
                if (board.getCells()[ballIndexI + 1][ballIndexJ].getItem() == null) {
                    swapElement(board, ballIndexI, ballIndexJ, ballIndexI + 1, ballIndexJ);
                    isBallMoved = true;
                }else if (board.getCells()[ballIndexI + 1][ballIndexJ].getItem() == Item.BASKET){
                    board.getCells()[ballIndexI][ballIndexJ] = new Cell();
                }
            }
        }

        int basketIndexI = basketLocation.getValue0();
        int basketIndexJ = basketLocation.getValue1();

        boolean isBasketMoved = false;

        if (isInBound(basketIndexI + 1, basketIndexJ, board.getSizeI(), board.getSizeJ())) {
            if (board.getCells()[basketIndexI + 1][basketIndexJ].getItem() == null) {
                swapElement(board, basketIndexI, basketIndexJ, basketIndexI + 1, basketIndexJ);
                isBasketMoved = true;
            }
        }

        return Pair.with(board, isBallMoved || isBasketMoved);
    }

    private static Pair<Board, Boolean> moveUpOnce(Board input){
        Board board = new Board(input);
        Pair<Integer, Integer> ballLocation = findBallLocation(board);
        Pair<Integer, Integer> basketLocation = findBasketLocation(board);

        int ballIndexI = ballLocation.getValue0();
        int ballIndexJ = ballLocation.getValue1();

        int basketIndexI = basketLocation.getValue0();
        int basketIndexJ = basketLocation.getValue1();

        boolean isBallMoved = false;
        boolean isBasketMoved = false;

        if (isInBound(ballIndexI - 1, ballIndexJ, board.getSizeI(), board.getSizeJ())) {
            if (board.getCells()[ballIndexI - 1][ballIndexJ].getItem() == null) {
                swapElement(board, ballIndexI, ballIndexJ, ballIndexI - 1, ballIndexJ);
                isBallMoved = true;
            }
        }

        if (isInBound(basketIndexI - 1, basketIndexJ, board.getSizeI(), board.getSizeJ())) {
            if (board.getCells()[basketIndexI - 1][basketIndexJ].getItem() == null) {
                swapElement(board, basketIndexI, basketIndexJ, basketIndexI - 1, basketIndexJ);
                isBasketMoved = true;
            }
        }

        return Pair.with(board, isBallMoved || isBasketMoved);
    }

    private static Pair<Board, Boolean> moveRightOnce(Board input){
        Board board = new Board(input);
        Pair<Integer, Integer> ballLocation = findBallLocation(board);
        Pair<Integer, Integer> basketLocation = findBasketLocation(board);

        int ballIndexI = ballLocation.getValue0();
        int ballIndexJ = ballLocation.getValue1();

        int basketIndexI = basketLocation.getValue0();
        int basketIndexJ = basketLocation.getValue1();

        boolean isBallMoved = false;
        boolean isBasketMoved = false;

        if (isInBound(ballIndexI, ballIndexJ + 1, board.getSizeI(), board.getSizeJ())) {
            if (board.getCells()[ballIndexI][ballIndexJ + 1].getItem() == null) {
                swapElement(board, ballIndexI, ballIndexJ, ballIndexI, ballIndexJ + 1);
                isBallMoved = true;
            }
        }

        if (isInBound(basketIndexI, basketIndexJ + 1, board.getSizeI(), board.getSizeJ())) {
            if (board.getCells()[basketIndexI][basketIndexJ + 1].getItem() == null) {
                swapElement(board, basketIndexI, basketIndexJ, basketIndexI, basketIndexJ + 1);
                isBasketMoved = true;
            }
        }

        return Pair.with(board, isBallMoved || isBasketMoved);
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
            if (board.getCells()[ballIndexI][ballIndexJ - 1].getItem() == null) {
                swapElement(board, ballIndexI, ballIndexJ, ballIndexI, ballIndexJ - 1);
                isBallMoved = true;
            }
        }

        if (isInBound(basketIndexI, basketIndexJ - 1, board.getSizeI(), board.getSizeJ())) {
            if (board.getCells()[basketIndexI][basketIndexJ - 1].getItem() == null) {
                swapElement(board, basketIndexI, basketIndexJ, basketIndexI, basketIndexJ - 1);
                isBasketMoved = true;
            }
        }

        return Pair.with(board, isBallMoved || isBasketMoved);
    }

    private static void swapElement(Board board, int firstI, int firstJ, int secondI, int secondJ) {
        Cell tmp = new Cell(board.getCells()[firstI][firstJ]);
        board.getCells()[firstI][firstJ] = new Cell(board.getCells()[secondI][secondJ]);
        board.getCells()[secondI][secondJ] = tmp;
    }

    private static boolean isInBound(int indexI, int indexJ, int maxI, int maxJ) {
        return (indexI >= 0 && indexJ >= 0) && (indexI < maxI && indexJ < maxJ);
    }


    private static Pair<Integer, Integer> findBasketLocation(Board board) {
        for (int i = 0; i < board.getSizeI(); i++) {
            for (int j = 0; j < board.getSizeJ(); j++) {
                if (board.getCells()[i][j].getItem() == Item.BASKET) {
                    return Pair.with(i, j);
                }
            }
        }
        System.out.println("yo basket not exists");
        return null;
    }

    public static Pair<Integer, Integer> findBallLocation(Board board) {
        for (int i = 0; i < board.getSizeI(); i++) {
            for (int j = 0; j < board.getSizeJ(); j++) {
                if (board.getCells()[i][j].getItem() == Item.BALL) {
                    return Pair.with(i, j);
                }
            }
        }
        //-1 indicates ball not found
        return Pair.with(-1,-1);
    }
}
