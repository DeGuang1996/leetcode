package doubleweek56;

public class SumGame {

    public boolean sumGame(String num) {
        String left = num.substring(0, num.length() / 2);
        String right = num.substring(num.length() / 2);
        int leftValue = 0, leftCount = 0;
        int rightValue = 0, rightCount = 0;
        for (char a : left.toCharArray()) {
            if (Character.isDigit(a)) {
                leftValue += a - '0';
            } else {
                leftCount++;
            }
        }
        for (char b : right.toCharArray()) {
            if (Character.isDigit(b)) {
                rightValue += b - '0';
            } else {
                rightCount++;
            }
        }
        if (leftCount == rightCount) {
            return leftValue != rightValue;
        }
        if (leftCount > rightCount) {
            int temp = leftValue;
            leftValue = rightValue;
            rightValue = temp;
            temp = leftCount;
            leftCount = rightCount;
            rightCount = temp;
        }
        int dis = leftValue - rightValue;
        if (dis <= 0) {
            return true;
        }
        int count = rightCount - leftCount;
        if (count % 2 == 1) {
            return true;
        }
        return dis != (count / 2 * 9);
    }

    public static void main(String[] args) {
        SumGame sumGame = new SumGame();
        sumGame.sumGame("25??");
    }
}
