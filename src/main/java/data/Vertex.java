package data;

import lombok.ToString;
import lombok.Value;

@Value
@ToString
class Vertex {

    private final String value;

    static Vertex of(String value) {
        return new Vertex(value);
    }
}
