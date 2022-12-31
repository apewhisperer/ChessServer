package model

import model.enums.Color
import model.enums.PieceValue
import spock.lang.Specification
import utils.BoardFactory

class BoardTest extends Specification {

    def 'should insert King at #description'() {
        given:
        Board board = new Board(0,7)

        when:
        board.upsertPiece(PieceValue.KING, Color.WHITE, coordinates)

        then:
        board.findField(coordinates).getPiece() != null

        where:
        coordinates           | expected | description
        new Coordinates(1, 1) | true     | '1,1 coordinates'
        new Coordinates(0, 0) | true     | '0,0 coordinates'
        new Coordinates(0, 1) | true     | '0,1 coordinates'
    }
}
