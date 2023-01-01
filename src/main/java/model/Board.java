package model;

import logging.ChessServerLogger;
import lombok.Getter;
import model.enums.Color;
import model.enums.PieceValue;
import model.pieces.Piece;
import utils.PieceFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Board {

    private final List<Field> BOARD_AS_LIST;

    public Board(int startIndex, int endIndex) {
        this.BOARD_AS_LIST = createNewBoard(startIndex, endIndex);
    }

    public List<Field> createNewBoard(int startIndex, int endIndex) {
        return IntStream.rangeClosed(startIndex, endIndex)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(startIndex, endIndex)
                        .mapToObj(j -> new Field(null, new Coordinates(i, j))))
                .collect(Collectors.toList());
    }

    public void upsertPiece(PieceValue pieceValue, Color color, Coordinates coords) {
        Piece newPiece = PieceFactory.getPiece(pieceValue, color, coords);
        this.BOARD_AS_LIST.stream()
                .filter(field -> field.getCoords().equals(coords))
                .findFirst()
                .ifPresentOrElse(field -> field.setPiece(newPiece),
                        () -> ChessServerLogger.info(coords.toString() + " field not found"));
    }

    public Field findField(Coordinates coords) {
        return this.BOARD_AS_LIST.stream()
                .filter(field -> field.getCoords().equals(coords))
                .findFirst()
                .orElse(null);
    }
}
