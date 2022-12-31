package model.enums;

public enum PieceValue {
    ROOK(5),
    KNIGHT(3),
    BISHOP(3),
    QUEEN(9),
    KING(Integer.MAX_VALUE - 110),
    PAWN(1);

    private int value;

    PieceValue(int value) {
        this.value = value;
    }
}
