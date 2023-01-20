package model.pieces

import model.Coordinates
import model.enums.Color
import model.enums.PieceValue
import spock.lang.Specification
import utils.factory.BoardFactory
import utils.factory.PieceFactory

class KnightTest extends Specification {

    def 'Should find all available fields when knight is placed at #description'() {
        when:
        def possibleTakes = PieceFactory.getPiece(Color.WHITE, coordinates, PieceValue.KNIGHT).findPossibleTakes(board)

        then:
        possibleTakes.size() == expected

        where:
        coordinates           | board                                          | expected | description
        new Coordinates(0, 0) | BoardFactory.getBoard("emptyBoard")            | 2        | '0,0 coordinates'
        new Coordinates(1, 1) | BoardFactory.getBoard("emptyBoard")            | 4        | '1,1 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("emptyBoard")            | 8        | '2,3 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Rook,w,1,1")            | 7        | '2,3 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Rook,b,1,1;Rook,w,3,1") | 7        | '2,3 coordinates'
    }


}
