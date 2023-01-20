package utils;

import model.Board;
import model.Coordinates;
import model.Field;
import model.pieces.Piece;

import java.util.List;

public class MoveUtils {

    private static final Coordinates upper = new Coordinates(0, -1);
    private static final Coordinates lower = new Coordinates(0, 1);
    private static final Coordinates left = new Coordinates(1, 0);
    private static final Coordinates right = new Coordinates(-1, 0);
    private static final Coordinates upperLeft = new Coordinates(-1, -1);
    private static final Coordinates upperRight = new Coordinates(1, -1);
    private static final Coordinates lowerLef = new Coordinates(-1, 1);
    private static final Coordinates lowerRight = new Coordinates(1, 1);

    public static void findVerticallyAvailableFields(Board board, Coordinates coords, List<Field> fields) {
        checkNeighboringField(board, coords, fields, upper);
        checkNeighboringField(board, coords, fields, lower);
    }

    public static void findHorizontallyAvailableFields(Board board, Coordinates coords, List<Field> fields) {
        checkNeighboringField(board, coords, fields, left);
        checkNeighboringField(board, coords, fields, right);
    }

    public static void findDiagonallyAvailableFields(Board board, Coordinates coords, List<Field> fields) {
        checkNeighboringField(board, coords, fields, lowerRight);
        checkNeighboringField(board, coords, fields, lowerLef);
        checkNeighboringField(board, coords, fields, upperRight);
        checkNeighboringField(board, coords, fields, upperLeft);
    }

    public static boolean isFieldInKnightRange(Coordinates source, Coordinates target) {
        return (Math.abs(source.getX() - target.getX()) == 2 && Math.abs(source.getY() - target.getY()) == 1)
                || (Math.abs(source.getX() - target.getX()) == 1 && Math.abs(source.getY() - target.getY()) == 2);
    }

    private static void checkNeighboringField(Board board, Coordinates coords, List<Field> fields, Coordinates direction) {
        int x = coords.getX();
        int y = coords.getY();
        int xStep = direction.getX();
        int yStep = direction.getY();

        if (x + xStep == -1 || x + xStep == 8 || y + yStep == -1 || y + yStep == 8) {
            return;
        }

        Field field = board.findField(x + xStep, y + yStep);
        Piece piece = field.getPiece();

        if (piece == null) {
            fields.add(field);
            checkNeighboringField(board, field.getCoords(), fields, direction);
        } else {
            if (!piece.getColor().equals(board.getCurrentPlayer())) {
                fields.add(field);
            }
        }
    }

}
