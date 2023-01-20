package model.pieces

import model.Coordinates
import model.enums.Color
import model.enums.PieceValue
import spock.lang.Specification
import utils.factory.BoardFactory
import utils.factory.PieceFactory

class QueenTest extends Specification {

    def 'Should find all available fields when queen is placed at #description'() {
        when:
        def possibleTakes = PieceFactory.getPiece(Color.WHITE, coordinates, PieceValue.QUEEN).findPossibleTakes(board)

        then:
        possibleTakes.size() == expected

        where:
        coordinates           | board                                          | expected | description
        new Coordinates(0, 0) | BoardFactory.getBoard("emptyBoard")            | 21       | '0,0 coordinates'
        new Coordinates(1, 1) | BoardFactory.getBoard("emptyBoard")            | 23       | '1,1 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("emptyBoard")            | 25       | '2,3 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Rook,w,4,1")            | 23       | '2,3 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Rook,b,4,1")            | 24       | '2,3 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Rook,b,4,1;Rook,w,4,5") | 21       | '2,3 coordinates'
    }


}
