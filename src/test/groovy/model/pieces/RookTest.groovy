package model.pieces


import model.Coordinates
import model.enums.Color
import model.enums.PieceValue
import spock.lang.Specification
import utils.factory.BoardFactory
import utils.factory.PieceFactory

class RookTest extends Specification {

    def 'Should find all available fields when rook is placed at #description'() {
        when:
        def possibleTakes = PieceFactory.getPiece(Color.WHITE, coordinates, PieceValue.ROOK).findPossibleTakes(board)

        then:
        possibleTakes.size() == expected

        where:
        coordinates           | board                                               | expected | description
        new Coordinates(0, 0) | BoardFactory.getBoard("emptyBoard")                 | 14       | '0,0 coordinates'
        new Coordinates(1, 1) | BoardFactory.getBoard("emptyBoard")                 | 14       | '1,1 coordinates'
        new Coordinates(0, 1) | BoardFactory.generateBoard("King,w,0,7")            | 13       | '0,1 coordinates'
        new Coordinates(1, 0) | BoardFactory.generateBoard("King,w,4,0")            | 10       | '1,0 coordinates'
        new Coordinates(0, 0) | BoardFactory.generateBoard("Rook,b,0,5;Rook,w,5,0") | 9        | '1,0 coordinates'
    }
}
