package week252;

public class MinimumPerimeter {

    public long minimumPerimeter(long neededApples) {
        long edgeLength = 2;
        long totalApples = 0;
        while (totalApples < neededApples) {
            totalApples += 6 * edgeLength;
            long begin = edgeLength - 1;
            long end = edgeLength / 2 + 1;
            if (begin >= end) {
                totalApples += (begin + end) * (begin - end + 1) * 4;
            }
            if (totalApples >= neededApples) {
                return 4 * edgeLength;
            }
            edgeLength += 2;
        }
        return 4 * edgeLength;
    }
}
