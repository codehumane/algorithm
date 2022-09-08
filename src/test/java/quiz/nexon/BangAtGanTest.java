package quiz.nexon;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static quiz.nexon.BangAtGan.Ingredient.*;

@Slf4j
class BangAtGanTest {

    @Test
    void name() {

        // 초기화
        var bangAtGan = new BangAtGan();

        // 뽑기 실행
        IntStream.rangeClosed(1, 10).forEach(x -> {
            bangAtGan.draw(FLOWER);
            bangAtGan.draw(RICE);
            bangAtGan.draw(HONEY);
        });

        // 뽑기 후 모인 재료 확인
        log.info("송편 만들기 전 재료: {}", bangAtGan.ingredients);

        // 송편 만들기
        var songPyeons = bangAtGan.make();
        log.info("만들어진 송편: {}", songPyeons);
        log.info("송편 만들기 후 재료: {}", bangAtGan.ingredients);
    }

}