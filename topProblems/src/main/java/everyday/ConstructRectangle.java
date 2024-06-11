package everyday;

public class ConstructRectangle {

    public int[] constructRectangle(int area) {
        int maxW = (int) Math.sqrt(area);
        for (int i = maxW; i >= 1; i--) {
            if (area % i == 0) {
                int l = area / i;
                return new int[]{l, i};
            }
        }
        return new int[]{};
    }
}
