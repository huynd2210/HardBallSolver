package pojo;


import lombok.Data;

@Data
public class Board {
    private int sizeI;
    private int sizeJ;
    private Cell[][] cells;

    public Board(int sizeI, int sizeJ) {
        this.sizeI = sizeI;
        this.sizeJ = sizeJ;
    }

    public Board(Board board){
        this.sizeI = board.sizeI;
        this.sizeJ = board.sizeJ;
        this.cells = new Cell[sizeI][sizeJ];
        for (int i = 0; i < this.sizeI; i++){
            for (int j = 0; j < this.sizeJ; j++){
                this.cells[i][j] = new Cell(board.getCells()[i][j]);
            }
        }
    }
}
