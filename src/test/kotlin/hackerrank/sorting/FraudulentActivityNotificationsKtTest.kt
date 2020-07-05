package hackerrank.sorting

import org.junit.Assert.assertEquals
import org.junit.Test

class FraudulentActivityNotificationsKtTest {

    @Test
    fun activityNotifications() {
        assertEquals(2, activityNotifications(arrayOf(2, 3, 4, 2, 3, 6, 8, 4, 5), 5))
        assertEquals(0, activityNotifications(arrayOf(1, 2, 3, 4, 4), 4))
        assertEquals(1, activityNotifications(arrayOf(4, 2, 3, 6, 5), 3))
    }

}