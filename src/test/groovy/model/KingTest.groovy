package model

import spock.lang.Specification

class KingTest extends Specification {
    def 'should find all possible moves when #description'() {
        given:
        def king = new King(coordinates, Color.WHITE, PieceValue.KING, true)


        when:
        def possibleTakes = king.findPossibleTakes(board)

        then:
        possibleTakes.size() == expected
        where:
        coordinates           | board       | expected | description
        new Coordinates(1, 1) | new Board() | 8        | ' coordinates are 1,1'
        new Coordinates(0, 0) | new Board() | 3        | ' coordinates are 1,1'
    }
}
