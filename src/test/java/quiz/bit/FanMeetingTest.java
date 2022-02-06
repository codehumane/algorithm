package quiz.bit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class FanMeetingTest {

    private static Stream<Arguments> fanMeetings() {
        return Stream.of(
                Arguments.of(new FoolFanMeeting())
//                Arguments.of(new BitFanMeeting())
        );
    }

    @ParameterizedTest
    @MethodSource("fanMeetings")
    public void count_멤버와_팬의_수가_동일하고_모두_남자인_경우(FanMeeting fanMeeting) throws Exception {
        // Given
        String members = "MMM";
        String fans = "MMM";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assertions.assertEquals(0, count);
    }

    @ParameterizedTest
    @MethodSource("fanMeetings")
    public void count_멤버와_팬의_수가_동일하고_모두_여자인_경우(FanMeeting fanMeeting) throws Exception {
        // Given
        String members = "FFF";
        String fans = "FFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assertions.assertEquals(1, count);
    }

    @ParameterizedTest
    @MethodSource("fanMeetings")
    public void count_멤버와_팬의_수가_동일하고_멤버와_팬에_남자가_포함되어_있지만_남자팬과_남자팬이_만나지는_않는_경우(FanMeeting fanMeeting) throws Exception {
        // Given
        String members = "FMF";
        String fans = "MFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assertions.assertEquals(1, count);
    }

    @ParameterizedTest
    @MethodSource("fanMeetings")
    public void case1(FanMeeting fanMeeting) throws Exception {
        // Given
        String members = "FFFMMM";
        String fans = "MMMFFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assertions.assertEquals(1, count);
    }

    @ParameterizedTest
    @MethodSource("fanMeetings")
    public void case2(FanMeeting fanMeeting) throws Exception {
        // Given
        String members = "FFFFF";
        String fans = "FFFFFFFFFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assertions.assertEquals(6, count);
    }

    @ParameterizedTest
    @MethodSource("fanMeetings")
    public void case3(FanMeeting fanMeeting) throws Exception {
        // Given
        String members = "FFFFM";
        String fans = "FFFFFMMMMF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assertions.assertEquals(2, count);
    }

    @ParameterizedTest
    @MethodSource("fanMeetings")
    public void case4(FanMeeting fanMeeting) throws Exception {
        // Given
        String members = "MFMFMFFFMMMFMF";
        String fans = "MMFFFFFMFFFMFFFFFFMFFFMFFFFMFMMFFFFFFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assertions.assertEquals(2, count);
    }

}