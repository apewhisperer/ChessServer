package utils;

import model.Board;
import model.Coordinates;
import model.Field;
import model.enums.Color;
import model.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class MoveUtils {

    public static List<Field> findVerticallyAvailableFields(Board board, Coordinates coords, Color currentPLayer) {
        List<Field> availableFields = new ArrayList<>();
        checkUpperField(board, coords, currentPLayer, availableFields);
        checkLowerField(board, coords, currentPLayer, availableFields);
        return availableFields;
    }

    private static void checkUpperField(Board board, Coordinates coords, Color currentPLayer, List<Field> availableFields) {
        if (coords.getY() == 7) {
            return;
        }
        Field field = board.findField(coords.getX(), coords.getY() + 1);
        Piece piece = field.getPiece();
        if (piece == null) {
            availableFields.add(field);
            checkUpperField(board, field.getCoords(), currentPLayer, availableFields);
        } else {
            if (!piece.getColor().equals(currentPLayer)) {
                availableFields.add(field);
            }
        }
    }

    private static void checkLowerField(Board board, Coordinates coords, Color currentPLayer, List<Field> availableFields) {
        if (coords.getY() == 0) {
            return;
        }
        Field field = board.findField(coords.getX(), coords.getY() - 1);
        Piece piece = field.getPiece();
        if (piece == null) {
            availableFields.add(field);
            checkLowerField(board, field.getCoords(), currentPLayer, availableFields);
        } else {
            if (!piece.getColor().equals(currentPLayer)) {
                availableFields.add(field);
            }
        }
    }

}
