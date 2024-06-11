package string;

public class Convert {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows && i < s.length(); i++) {
            boolean isDown = true;
            int begin = i;
            int downInterval = (numRows - i - 1) * 2;
            int upInterval = i * 2;
            ans.append(s.charAt(begin));
            while (begin < s.length()) {
                if (isDown) {
                    isDown = false;
                    if (downInterval > 0) {
                        begin += downInterval;
                        if (begin < s.length()) {
                            ans.append(s.charAt(begin));
                        }
                        continue;
                    }
                }
                if (!isDown) {
                    isDown = true;
                    if (upInterval > 0) {
                        begin += upInterval;
                        if (begin < s.length()) {
                            ans.append(s.charAt(begin));
                        }
                        continue;
                    }
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        convert.convert("PAYPALISHIRING", 3);
    }
}
