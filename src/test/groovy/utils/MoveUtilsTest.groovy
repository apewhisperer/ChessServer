package utils

import model.Coordinates
import spock.lang.Specification
import utils.factory.BoardFactory

class MoveUtilsTest extends Specification {

    def 'Should find all vertically available fields for piece placed at #description'() {
        given:
        def availableFields = new ArrayList()

        when:
        MoveUtils.findVerticallyAvailableFields(board, coordinates, availableFields)

        then:
        availableFields.size() == expected

        where:
        coordinates           | board                                      | expected | description
        new Coordinates(0, 0) | BoardFactory.getBoard("emptyBoard")        | 7        | '0,0 coordinates'
        new Coordinates(1, 1) | BoardFactory.getBoard("emptyBoard")        | 7        | '1,1 coordinates'
        new Coordinates(0, 1) | BoardFactory.getBoard("KingTopLeftCorner") | 6        | '0,1 coordinates'
        new Coordinates(0, 0) | BoardFactory.getBoard("Pawn,b,0,5")        | 5        | '0,0 coordinates'
        new Coordinates(0, 0) | BoardFactory.getBoard("Pawn,w,0,5")        | 4        | '0,0 coordinates'
    }

    def 'Should find all horizontally available fields for piece placed at #description'() {
        given:
        def availableFields = new ArrayList()

        when:
        MoveUtils.findHorizontallyAvailableFields(board, coordinates, availableFields)

        then:
        availableFields.size() == expected

        where:
        coordinates           | board                                       | expected | description
        new Coordinates(0, 0) | BoardFactory.getBoard("emptyBoard")         | 7        | '0,0 coordinates'
        new Coordinates(1, 1) | BoardFactory.getBoard("emptyBoard")         | 7        | '1,1 coordinates'
        new Coordinates(1, 0) | BoardFactory.getBoard("KingBotRightCorner") | 6        | '1,0 coordinates'
        new Coordinates(0, 0) | BoardFactory.getBoard("Pawn,b,5,0")         | 5        | '0,0 coordinates'
        new Coordinates(0, 0) | BoardFactory.getBoard("Pawn,w,5,0")         | 4        | '0,0 coordinates'
    }

    def 'Should find all diagonally available fields for piece placed at #description'() {
        given:
        def availableFields = new ArrayList()

        when:
        MoveUtils.findDiagonallyAvailableFields(board, coordinates, availableFields)

        then:
        availableFields.size() == expected

        where:
        coordinates           | board                                  | expected | description
        new Coordinates(0, 0) | BoardFactory.getBoard("emptyBoard")    | 7        | '0,0 coordinates'
        new Coordinates(1, 1) | BoardFactory.getBoard("emptyBoard")    | 9        | '1,1 coordinates'
        new Coordinates(2, 2) | BoardFactory.getBoard("KingBotMiddle") | 10       | '2,2 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Pawn,b,0,5")    | 11       | '0,0 coordinates'
        new Coordinates(2, 3) | BoardFactory.getBoard("Pawn,w,0,5")    | 10       | '0,0 coordinates'
    }
}
