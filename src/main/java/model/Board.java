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

    private List<Field> boardAsList;

    public Board(int startIndex, int endIndex) {
        this.boardAsList = createNewBoard(startIndex, endIndex);
    }

    public List<Field> createNewBoard(int startIndex, int endIndex) {
        return IntStream.rangeClosed(startIndex, endIndex)
                .boxed()
                .flatMap(i -> IntStream.range(startIndex, endIndex)
                        .mapToObj(j -> new Field(null, new Coordinates(i, j))))
                .collect(Collectors.toList());
    }

    public void upsertPiece(PieceValue pieceValue, Color color, Coordinates coords) {
        Piece newPiece = PieceFactory.getPiece(pieceValue, color, coords);
        this.boardAsList.stream()
                .filter(field -> field.getCoords().equals(coords))
                .findFirst()
                .ifPresentOrElse(field -> field.setPiece(newPiece),
                        () -> ChessServerLogger.info(coords.toString() + " field not found"));
    }

    public Field findField(Coordinates coords) {
        return this.boardAsList.stream()
                .filter(field -> field.getCoords().equals(coords))
                .findFirst()
                .orElse(null);
    }
}
