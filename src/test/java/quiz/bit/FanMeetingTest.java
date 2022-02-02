package quiz.bit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import quiz.bit.FanMeeting;
import quiz.bit.FoolFanMeeting;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class FanMeetingTest<T extends FanMeeting> {

    private T fanMeeting;
    private Class<T> fanMeetingClass;

    public FanMeetingTest(Class<T> fanMeetingClass) {
        this.fanMeetingClass = fanMeetingClass;
    }

    @Parameterized.Parameters
    public static List<Class> fanMeetingClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(FoolFanMeeting.class);
//        classes.add(BitFanMeeting.class);
        return classes;
    }

    @Before
    public void setup() throws IllegalAccessException, InstantiationException {
        this.fanMeeting = fanMeetingClass.newInstance();
    }

    @Test
    public void count_멤버와_팬의_수가_동일하고_모두_남자인_경우() throws Exception {
        // Given
        String members = "MMM";
        String fans = "MMM";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assert.assertEquals(0, count);
    }

    @Test
    public void count_멤버와_팬의_수가_동일하고_모두_여자인_경우() throws Exception {
        // Given
        String members = "FFF";
        String fans = "FFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assert.assertEquals(1, count);
    }

    @Test
    public void count_멤버와_팬의_수가_동일하고_멤버와_팬에_남자가_포함되어_있지만_남자팬과_남자팬이_만나지는_않는_경우() throws Exception {
        // Given
        String members = "FMF";
        String fans = "MFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assert.assertEquals(1, count);
    }

    @Test
    public void case1() throws Exception {
        // Given
        String members = "FFFMMM";
        String fans = "MMMFFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assert.assertEquals(1, count);
    }

    @Test
    public void case2() throws Exception {
        // Given
        String members = "FFFFF";
        String fans = "FFFFFFFFFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assert.assertEquals(6, count);
    }

    @Test
    public void case3() throws Exception {
        // Given
        String members = "FFFFM";
        String fans = "FFFFFMMMMF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assert.assertEquals(2, count);
    }

    @Test
    public void case4() throws Exception {
        // Given
        String members = "MFMFMFFFMMMFMF";
        String fans = "MMFFFFFMFFFMFFFFFFMFFFMFFFFMFMMFFFFFFF";

        // When
        int count = fanMeeting.count(members, fans);

        // Then
        Assert.assertEquals(2, count);
    }
}