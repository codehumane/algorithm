package quiz.etc;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {

    private final Map<String, Integer> lastLogs = new HashMap<>();

    public LoggerRateLimiter() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (lastLogs.containsKey(message) && timestamp - lastLogs.get(message) < 10) {
            return false;
        }

        lastLogs.put(message, timestamp);
        return true;
    }

}
