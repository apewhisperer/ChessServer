package utils;

import model.Coordinates;

public class StreamUtils {

    public static boolean isInRange(Coordinates source, Coordinates destination, int range) {
        return isInVerticalRange(source, destination, range)
                || isInDiagonalRange(source, destination, range)
                || isInHorizontalRange(source, destination, range);
    }

    private static boolean isInVerticalRange(Coordinates source, Coordinates destination, int range) {
        return Math.abs(source.getX() - destination.getX()) == 0
                && Math.abs(source.getY() - destination.getY()) == range;
    }

    private static boolean isInHorizontalRange(Coordinates source, Coordinates destination, int range) {
        return Math.abs(source.getX() - destination.getX()) == range
                && Math.abs(source.getY() - destination.getY()) == 0;
    }

    private static boolean isInDiagonalRange(Coordinates source, Coordinates destination, int range) {
        return Math.abs(source.getX() - destination.getX()) == range
                && Math.abs(source.getY() - destination.getY()) == range;
    }


}
