package pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;

        Board board = (Board) o;

        if (sizeI != board.sizeI) return false;
        if (sizeJ != board.sizeJ) return false;
        return Arrays.deepEquals(cells, board.cells);
    }

    @Override
    public int hashCode() {
        int result = sizeI;
        result = 31 * result + sizeJ;
        result = 31 * result + Arrays.deepHashCode(cells);
        return result;
    }
}
