package quiz.etc;

import java.util.*;
import java.util.stream.Collectors;

public class LoggerRateLimiter {

    private final MapSolution mapSolution = new MapSolution();
    private final QueueAndSetSolution queueAndSetSolution = new QueueAndSetSolution();
    private final MapSolutionSpaceManaged mapSolutionSpaceManaged = new MapSolutionSpaceManaged();

    public LoggerRateLimiter() {

    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        var byMap = mapSolution.shouldPrintMessage(timestamp, message);
        var byQueueAndSet = queueAndSetSolution.shouldPrintMessage(timestamp, message);
        var mapWithSpaceManaged = mapSolutionSpaceManaged.shouldPrintMessage(timestamp, message);

        assert byMap == byQueueAndSet;
        assert byMap == mapWithSpaceManaged;
        return byMap;
    }

    static class QueueAndSetSolution {

        private final Set<String> set = new HashSet<>();
        private final Deque<TimedMessage> deque = new ArrayDeque<>();

        public boolean shouldPrintMessage(int timestamp, String message) {

            while (!deque.isEmpty()) {
                if (timestamp - deque.peek().timestamp < 10) break;

                var old = deque.poll();
                set.remove(old.message);
            }

            if (!set.contains(message)) {
                set.add(message);
                deque.offer(new TimedMessage(timestamp, message));
                return true;
            }

            return false;
        }

        static class TimedMessage {
            final int timestamp;
            final String message;

            TimedMessage(int timestamp, String message) {
                this.timestamp = timestamp;
                this.message = message;
            }
        }
    }

    static class MapSolution {
        private final Map<String, Integer> lastLogs = new HashMap<>();

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (lastLogs.containsKey(message) && timestamp - lastLogs.get(message) < 10) {
                return false;
            }

            lastLogs.put(message, timestamp);
            return true;
        }
    }

    static class MapSolutionSpaceManaged {
        private final Map<String, Integer> lastLogs = new HashMap<>();

        public boolean shouldPrintMessage(int timestamp, String message) {

            var expired = lastLogs
                    .entrySet()
                    .stream()
                    .filter(e -> timestamp - e.getValue() >= 10)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toSet());

            for (String e : expired) {
                lastLogs.remove(e);
            }

            if (lastLogs.containsKey(message)) {
                return false;
            }

            lastLogs.put(message, timestamp);
            return true;
        }
    }

}
