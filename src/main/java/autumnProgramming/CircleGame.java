package autumnProgramming;

import java.util.Arrays;

public class CircleGame {

    public int circleGame(int[][] toys, int[][] circles, int r) {
        Arrays.sort(circles, (circle1, circle2) -> {
            if (circle1[0] == circle2[0]) {
                return circle1[1] - circle2[1];
            }
            return circle1[0] - circle2[0];
        });
        int ans = 0;

        for (int[] toy : toys) {
            int x = toy[0];
            int y = toy[1];
            int rr = toy[2];

            if (rr <= r) {
                int minX = x - (r - rr);
                int maxX = x + (r - rr);
                int minY = y - (r - rr);
                int maxY = y + (r - rr);

                int left = 0, right = circles.length;
                left = binarySearchX(circles, left, right, minX);

                for (int i = left; i < circles.length; i++) {
                    if (circles[i][0] > maxX) {
                        break;
                    }
                    if (circles[i][1] >= minY && circles[i][1] <= maxY && isInclude(toy, circles[i], r)) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private boolean isInclude(int[] toy, int[] circle, int r) {
        double i = Math.sqrt((long) (circle[0] - toy[0]) * (long) (circle[0] - toy[0]) + (long) (circle[1] - toy[1]) * (long) (circle[1] - toy[1]));
        return i <= r - toy[2];
    }

    private int binarySearchX(int[][] circles, int left, int right, int value) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (circles[mid][0] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
