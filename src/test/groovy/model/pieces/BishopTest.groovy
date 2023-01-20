package model.pieces

import model.Coordinates
import model.enums.Color
import model.enums.PieceValue
import spock.lang.Specification
import utils.factory.BoardFactory
import utils.factory.PieceFactory

class BishopTest extends Specification {

    def 'Should find all available fields when bishop is placed at #description'() {
        when:
        def possibleTakes = PieceFactory.getPiece(Color.WHITE, coordinates, PieceValue.BISHOP).findPossibleTakes(board)

        then:
        possibleTakes.size() == expected

        where:
        coordinates           | board                                          | expected | description
        new Coordinates(0, 0) | BoardFactory.getBoard("emptyBoard")            | 7        | '0,0 coordinates'
        new Coordinates(1, 1) | BoardFactory.getBoard("emptyBoard")            | 9        | '1,1 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("emptyBoard")            | 11       | '2,3 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Rook,w,4,1")            | 9        | '2,3 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Rook,b,4,1;Rook,w,4,5") | 7        | '2,3 coordinates'
    }

}
