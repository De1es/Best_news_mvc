package by.delesevich.bestnews.exception;

public class NewsDAOException extends Exception{

  public NewsDAOException(String message, Throwable cause) {
    super(message, cause);
  }

  public NewsDAOException() {
    super();
  }
}
