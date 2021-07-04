package string;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;

        int carry = 0;
        while (i >= 0 && j >= 0) {
            int temp = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            carry = temp / 10;
            temp = temp % 10;
            stringBuilder.append(temp);
            i--;
            j--;
        }
        while (i >= 0) {
            int temp = num1.charAt(i) - '0' + carry;
            carry = temp / 10;
            temp = temp % 10;
            stringBuilder.append(temp);
            i--;
        }
        while (j >= 0) {
            int temp = num2.charAt(j) - '0' + carry;
            carry = temp / 10;
            temp = temp % 10;
            stringBuilder.append(temp);
            j--;
        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
