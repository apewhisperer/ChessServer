package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.pieces.Piece;

@Getter
@Setter
@AllArgsConstructor
public class Field {

    private Piece piece;
    private Coordinates coords;
}
