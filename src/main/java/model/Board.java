package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {


    private List<Field> boardAsList = new ArrayList<>();


    public Board() {
        this.boardAsList = createNewBoard();
    }

    public List<Field> createNewBoard() {
        ArrayList<Field> board = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.add(new Field(null, new Coordinates(i, j)));
            }
        }
        return board;
    }

}
