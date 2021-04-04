package pojo;

import lombok.*;

@Getter
@Setter
public class Cell {
    private Item item;

    public Cell(){
        this.item = null;
    }

    public Cell(Item item){
        this.item = item;
    }

    public Cell(Cell cell){
        this.item = cell.item;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        if (this.item == Item.BALL){
            sb.append("O");
        }else if (this.item == Item.BASKET){
            sb.append("B");
        }else if (this.item == Item.WALL){
            sb.append("W");
        }else{
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cell)) return false;

        Cell cell = (Cell) o;

        return item == cell.item;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}
