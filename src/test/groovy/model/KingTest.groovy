package model

import model.enums.Color
import model.enums.PieceValue
import model.pieces.King
import spock.lang.Specification
import spock.lang.Unroll

class KingTest extends Specification {

    @Unroll
    def 'should find all possible moves when kings #description'() {
        when:
        def possibleTakes = new King(coordinates, Color.WHITE, PieceValue.KING, true).findPossibleTakes(board)

        then:
        possibleTakes.size() == expected

        where:
        coordinates           | board           | expected | description
        new Coordinates(1, 1) | new Board(0, 7) | 8        | 'coordinates are 1,1'
        new Coordinates(0, 0) | new Board(0, 7) | 3        | 'coordinates are 0,0'
        new Coordinates(0, 1) | new Board(0, 7) | 5        | 'coordinates are 0,1'
    }
}
