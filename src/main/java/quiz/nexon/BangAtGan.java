package quiz.nexon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class BangAtGan {

    enum Ingredient {
        RICE,
        HONEY,
        FLOWER
    }

    @Getter
    @AllArgsConstructor
    enum Color {
        YELLOW(5),
        PINK(15),
        WHITE(30),
        GREEN(50);

        private final int weight;
    }

    @Value
    static class SongPyeon {
        Color color;
        int count;
    }

    final Map<Ingredient, Map<Color, Integer>> ingredients;
    SortedMap<Color, Integer> prefixSums;

    public BangAtGan() {
        this.ingredients = initIngredients();
        this.prefixSums = initPrefixSums();
    }

    private Map<Ingredient, Map<Color, Integer>> initIngredients() {
        return Arrays
                .stream(Ingredient.values())
                .collect(Collectors.toMap(i -> i, i -> initColors()));
    }

    private Map<Color, Integer> initColors() {
        return Arrays
                .stream(Color.values())
                .collect(Collectors.toMap(c -> c, c -> 0));
    }

    private SortedMap<Color, Integer> initPrefixSums() {
        var prefixSums = new TreeMap<Color, Integer>();
        var sum = 0;

        for (Color color : Color.values()) {
            sum += color.weight;
            prefixSums.put(color, sum);
        }

        return prefixSums;
    }

    public void draw(Ingredient ingredient) {
        var drawnPoint = prefixSums.get(prefixSums.lastKey()) * Math.random();

        var drawnColor = prefixSums
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > drawnPoint)
                .findFirst()
                .orElseThrow()
                .getKey();

        log.debug("prefixSums: {}, point: {}, drawnColor: {}", prefixSums, drawnPoint, drawnColor);

        ingredients
                .get(ingredient)
                .computeIfPresent(drawnColor, (color, sum) -> sum + 1);
    }

    public Set<SongPyeon> make() {
        var songPeons = makeSongPyeons();
        subtractIngredientsCountFor(songPeons);
        return songPeons;
    }

    private Set<SongPyeon> makeSongPyeons() {
        return Arrays
                .stream(Color.values())
                .map(color -> new SongPyeon(color, minColorCountOfIngredients(color)))
                .collect(Collectors.toSet());
    }

    private Integer minColorCountOfIngredients(Color color) {
        return ingredients
                .values()
                .stream()
                .map(colors -> colors.get(color))
                .min(Integer::compareTo)
                .orElseThrow();
    }

    private void subtractIngredientsCountFor(Set<SongPyeon> songPeons) {
        ingredients.forEach((ingredients, colors) -> {
            for (SongPyeon songPeon : songPeons) {
                colors.computeIfPresent(
                        songPeon.color,
                        (color, count) -> count - songPeon.getCount()
                );
            }
        });
    }

}
