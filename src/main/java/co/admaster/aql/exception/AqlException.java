package co.admaster.aql.exception;

/**
 * User: chenxiaojian
 * Date: 13-4-27
 * Time: 下午6:52
 */
public class AqlException extends Exception {

    public AqlException() {
        super();
    }

    public AqlException(String message) {
        super(message);
    }

    public AqlException(String message, Throwable cause) {
        super(message, cause);
    }


    public AqlException(Throwable cause) {
        super(cause);
    }
}
