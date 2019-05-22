import org.apache.log4j.Logger;

public class SizeInvalidException extends RuntimeException {

    public static Logger LOGGER = Logger.getLogger(SizeInvalidException.class);

    public SizeInvalidException() {
        super();
        LOGGER.error(" Negative size is not allowed ");
    }
}
