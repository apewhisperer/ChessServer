package utils;

import model.Board;
import org.springframework.beans.factory.annotation.Value;

public class BoardFactory {

    @Value("${spring.defaults.board.start-index}")
    private static int startIndex;
    @Value("${spring.defaults.board.end-index}")
    private static int endIndex;
    public static Board getBoard(String testPreset){
        if ("emptyBoard".equals(testPreset)){
            return new Board(startIndex, endIndex);
        }
        return null;
    }
}
