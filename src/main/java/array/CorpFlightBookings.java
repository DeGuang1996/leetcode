package array;

public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] subPre = new int[n + 1];
        for (int i = 0; i < bookings.length; i++) {
            int left = bookings[i][0];
            int right = bookings[i][1];
            int num = bookings[i][2];

            subPre[left] += num;
            subPre[right + 1] -= num;
        }
        int[] res = new int[n];
        res[0] = subPre[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = subPre[i] + res[i - 1];
        }
        return res;
    }
}
