package model.service.utility;

import org.apache.log4j.Logger;

public class LoggerUtil {
    final static Logger logger = Logger.getLogger(String.valueOf(LoggerUtil.class));

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logError(String message, Exception ex) {
        logger.error(message, ex);
    }

    public void logWarn(String message) {
        logger.warn(message);
    }
}
