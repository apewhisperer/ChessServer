package model.pieces

import model.Board
import model.enums.Color
import spock.lang.Specification
import spock.lang.Unroll

class PawnTest extends Specification {

    @Unroll
    def 'should fill board with black pawns on #row row'() {
        expect:
        board.prepareStartBoard(0, 7).stream()
                .filter(field -> field != null && field.getPiece().color == Color.BLACK)
                .count() == 8

        where:
        board           | row
        new Board(0, 7) | '2nd'
    }
}
