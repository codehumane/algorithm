package data;

import java.io.Serializable;

/**
 * 정점
 *
 * @author chogh1211
 *
 */
public class CacheGraphVertex<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private final T value;

    CacheGraphVertex(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        @SuppressWarnings({"unchecked", "rawtypes"})
        CacheGraphVertex other = (CacheGraphVertex) obj;
        if (value == null) {
            if (other.value != null) {
                return false;
            }
        } else if (!value.equals(other.value)) {
            return false;
        }
        return true;
    }

}
