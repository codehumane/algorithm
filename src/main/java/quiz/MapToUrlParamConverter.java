package quiz;

import java.util.Map;

public class MapToUrlParamConverter {

    private static final String BRACKET_PAIR = "[]";
    private static final String EQUAL = "=";

    public <K, V> String convert(Map<K, V> map) {
        StringBuilder sb = new StringBuilder();
        for (K key : map.keySet()) {
            V value = map.get(key);
            appendKeyValue(key, value, sb);
        }

        return sb.toString();
    }

    private <K, V> void appendKeyValue(K key, V value, StringBuilder sb) {
        appendKey(key, value, sb);
        sb.append(EQUAL);
        appendValue(value, sb);
    }

    private <K, V> void appendKey(K key, V value, StringBuilder sb) {
        sb.append(String.valueOf(key));
        if (value instanceof Iterable) {
            sb.append(BRACKET_PAIR);
        }
    }

    private <V> void appendValue(V value, StringBuilder sb) {
        sb.append(String.valueOf(value));
    }

}
