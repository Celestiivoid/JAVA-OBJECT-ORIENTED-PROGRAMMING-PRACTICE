
public class ReturnMessage {
    public void logData(String message) {
        System.out.println("Log message: " + message);
    }
    public void logData(String message, int errorCode) {
        System.out.println("Log message: " + message + "| Error code: " + errorCode);
    }
    public static void main(String[] args) {

        ReturnMessage  log = new ReturnMessage();

        log.logData("System started successfully!");
        log.logData("System failed to start!", 404);
    }
}