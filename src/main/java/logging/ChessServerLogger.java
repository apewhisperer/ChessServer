package logging;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChessServerLogger {

    @ToString.Exclude
    static final Logger LOGGER = LoggerFactory.getLogger(ChessServerLogger.class);

    public static void info(String msg) {
        LOGGER.info(msg);
    }

    public static void debug(String msg) {
        LOGGER.debug(msg);
    }

    public static void error(String msg) {
        LOGGER.error(msg);
    }
}
