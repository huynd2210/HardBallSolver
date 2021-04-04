package logic;

import pojo.Board;
import pojo.Cell;
import pojo.Item;

public class BoardLogic {
    public static Board initSampleBoard() {
        Board sampleBoard = initEmptyBoard(5, 5);
        addItem(sampleBoard, Item.BASKET, 4, 4);
        addItem(sampleBoard, Item.BALL, 2, 2);
        addItem(sampleBoard, Item.WALL, 2, 0);
        return sampleBoard;
    }

    public static Board initEmptyBoard(int sizeI, int sizeJ) {
        Board board = new Board(sizeI, sizeJ);
        initEmptyBoard(board);
        return board;
    }

    private static void initEmptyBoard(Board board) {
        board.setCells(new Cell[board.getSizeI()][board.getSizeJ()]);
        for (int i = 0; i < board.getSizeI(); i++) {
            for (int j = 0; j < board.getSizeJ(); j++) {
                board.getCells()[i][j] = new Cell();
            }
        }
    }

    public static void printBoard(Board board) {
        for (int i = 0; i < board.getSizeI(); i++) {
            for (int j = 0; j < board.getSizeJ(); j++) {
                System.out.print(board.getCells()[i][j]);
            }
            System.out.println();
        }
    }

    public static void addItem(Board board, Item item, int i, int j) {
        board.getCells()[i][j] = new Cell(item);
    }

    public static Board stringNotationToBoard(String notation) {
        String[] tokens = notation.split("/");

        Board board = initEmptyBoard(tokens.length, tokens[0].length());
        for (int i = 0; i < tokens.length; i++) {
            for (int j = 0; j < tokens[i].length(); j++) {
                if (tokens[i].charAt(j) == 'W') {
                    addItem(board, Item.WALL, i, j);
                } else if (tokens[i].charAt(j) == 'O') {
                    addItem(board, Item.BALL, i, j);
                } else if (tokens[i].charAt(j) == 'B') {
                    addItem(board, Item.BASKET, i, j);
                }
            }
        }
        return board;
    }
}
