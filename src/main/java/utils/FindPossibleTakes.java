package utils;

import model.Board;
import model.Field;

import java.util.List;

public interface FindPossibleTakes {

    public List<Field> findPossibleTakes(Board board);

}
