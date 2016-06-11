package quiz;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToUrlParamConverterTest {

    @Test
    public void convert_깊이1인_경우_key_equal_value_형태로_표현한다() {
        // Given
        MapToUrlParamConverter converter = new MapToUrlParamConverter();
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "value");

        // When
        String param = converter.convert(map);

        // Then
        Assert.assertEquals("key=value", param);
    }

    @Test
    public void convert_배열인_경우_key에_square_bracket을_붙여_표현한다() {
        // Given
        MapToUrlParamConverter converter = new MapToUrlParamConverter();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> value = Lists.newArrayList("hello", "world");
        map.put("key", value);

        // When
        String param = converter.convert(map);

        // Then
        Assert.assertEquals("key[]=hello&key[]=world", param);
    }
}
