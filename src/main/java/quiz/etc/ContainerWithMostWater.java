package quiz.etc;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        var max = 0;
        var l = 0;
        var r = height.length - 1;

        while (l < r) {
            var w = r - l;
            var h = Math.min(height[l], height[r]);
            max = Math.max(max, w * h);

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return max;
    }

}
