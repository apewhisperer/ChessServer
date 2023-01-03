package utils


import model.Coordinates
import model.enums.Color
import spock.lang.Specification

class MoveUtilsTest extends Specification {

    def 'Should find all available fields for piece placed at #description'() {
        when:
        def availableFields = MoveUtils.findVerticallyAvailableFields(board, coordinates, Color.WHITE)

        then:
        availableFields.size() == expected

        where:
        coordinates           | board                                        | expected | description
        new Coordinates(0, 0) | BoardFactory.getBoard("emptyBoard")          | 7        | '0,0 coordinates'
        new Coordinates(1, 1) | BoardFactory.getBoard("emptyBoard")          | 7        | '1,1 coordinates'
        new Coordinates(0, 1) | BoardFactory.getBoard("KingAtTopLeftCorner") | 6        | '0,1 coordinates'
    }
}
