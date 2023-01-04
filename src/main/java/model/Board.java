package model;

import logging.ChessServerLogger;
import lombok.Getter;
import model.enums.Color;
import model.enums.PieceValue;
import model.pieces.Pawn;
import model.pieces.Piece;
import utils.factory.PieceFactory;

import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Board {

    private final List<Field> BOARD_AS_LIST;
    private Color currentPlayer = Color.WHITE;

    public Board(int startIndex, int endIndex) {
        this.BOARD_AS_LIST = prepareEmptyBoard(startIndex, endIndex);
    }

    public List<Field> prepareStartBoard(int startIndex, int endIndex) {
        final int[] count = {0};
        return prepareEmptyBoard(startIndex, endIndex).stream()
                .skip(8)
                .limit(8)
                .map(field -> new Field(
                        new Pawn(new Coordinates(1, count[0]), Color.BLACK, true),
                        new Coordinates(1, count[0]++)))
                .toList();
    }

    public List<Field> prepareEmptyBoard(int startIndex, int endIndex) {
        return IntStream.rangeClosed(startIndex, endIndex)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(startIndex, endIndex)
                        .mapToObj(j -> new Field(null, new Coordinates(i, j))))
                .toList();
    }

    public void upsertPiece(Color color, Coordinates coords, PieceValue value) {
        Piece newPiece = PieceFactory.getPiece(color, coords, value);
        this.BOARD_AS_LIST.stream()
                .filter(field -> field.getCoords().equals(coords))
                .findFirst()
                .ifPresentOrElse(field -> field.setPiece(newPiece),
                        () -> ChessServerLogger.error(coords.toString() + " field not found"));
    }

    public void upsertPiece(Piece piece) {
        this.BOARD_AS_LIST.stream()
                .filter(field -> field.getCoords().equals(piece.getCurrentPos()))
                .findFirst()
                .ifPresentOrElse(field -> field.setPiece(piece),
                        () -> ChessServerLogger.error(piece.getCurrentPos().toString() + " field not found"));
    }

    public Field findField(Coordinates coords) {
        return this.BOARD_AS_LIST.stream()
                .filter(field -> field.getCoords().equals(coords))
                .findFirst()
                .orElse(null);
    }

    public Field findField(int x, int y) {
        Coordinates coords = new Coordinates(x, y);
        return this.BOARD_AS_LIST.stream()
                .filter(field -> field.getCoords().equals(coords))
                .findFirst()
                .orElse(null);
    }

    public void swapPlayer(){
        if(this.currentPlayer.equals(Color.WHITE)){
            this.currentPlayer = Color.BLACK;
        } else {
            this.currentPlayer = Color.WHITE;
        }
    }

    private Board (BoardBuilder builder){
        this.BOARD_AS_LIST = builder.board.BOARD_AS_LIST;
    }

    public static class BoardBuilder {
        private Board board;

        public BoardBuilder(Board board) {
            this.board = board;
        }

        public BoardBuilder upsertPiece(Piece piece){
            board.upsertPiece(piece);
            return this;
        }

        public BoardBuilder upsertPiece(Color color, Coordinates coords, PieceValue value){
            board.upsertPiece(color, coords, value);
            return this;
        }

        public BoardBuilder swapPlayer(){
            board.swapPlayer();
            return this;
        }

        public Board build(){
            return new Board(this);
        }
    }
}
