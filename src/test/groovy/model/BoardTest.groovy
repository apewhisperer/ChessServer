package model

import model.enums.Color
import model.enums.PieceValue
import spock.lang.Specification
import spock.lang.Unroll
import utils.factory.BoardFactory

class BoardTest extends Specification {

    @Unroll
    def 'should insert King at #description'() {
        given:
        Board board = BoardFactory.getBoard("emptyBoard")

        when:
        board.upsertPiece(Color.WHITE, coordinates, PieceValue.KING)

        then:
        board.findField(coordinates).getPiece() != null

        where:
        coordinates           | expected | description
        new Coordinates(1, 1) | true     | '1,1 coordinates'
        new Coordinates(0, 0) | true     | '0,0 coordinates'
        new Coordinates(0, 1) | true     | '0,1 coordinates'
    }

    def 'should create chessboard with #fieldNumber fields'() {
        expect:
        new Board(startIndex, endIndex).BOARD_AS_LIST.size() == fieldNumber

        where:
        startIndex | endIndex | fieldNumber
        0          | 7        | 64
    }

    def 'generator test'() {
        when:
        def board = BoardFactory.generateBoard("King,w,0,0;pawn,w,0,1")

        then:
        board.findField(new Coordinates(0,0)).getPiece() != null
        board.findField(new Coordinates(0,1)).getPiece() != null
    }
}
