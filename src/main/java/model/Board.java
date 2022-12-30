package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
@Setter
public class Board {

    private List<Field> boardAsList;

    public Board(int startIndex, int endIndex) {
        this.boardAsList = createNewBoard(startIndex, endIndex);
    }

    public List<Field> createNewBoard(int startIndex, int endIndex) {
        return IntStream.rangeClosed(startIndex, endIndex)
                .boxed()
                .flatMap(i -> IntStream.range(startIndex, endIndex).mapToObj(j -> new Field(null, new Coordinates(i, j))))
                .collect(Collectors.toList());
    }
}
