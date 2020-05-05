package hackerrank.search;

public class MinimumTimeRequired {

    static long minTime(long[] machines, long goal) {
        long count = 0;
        int days = 0;

        while (count < goal) {

            days++;

            for (long machine : machines)
                if (days % machine == 0)
                    count++;

        }

        return days;
    }

}
