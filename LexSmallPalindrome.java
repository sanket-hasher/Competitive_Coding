package CompetitiveCoding;

public class LexSmallPalindrome {
    public static String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] result = new char[n];
        for (int i = 0; i < n / 2; i++) {
            char left = s.charAt(i);
            char right = s.charAt(n - 1 - i);
            result[i] = result[n - 1 - i] = (char) Math.min(left, right);
        }
        if (n % 2 == 1) {
            result[n / 2] = s.charAt(n / 2);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "seven";
        System.out.println(makeSmallestPalindrome(s));  // Output: "seven"
    }
}
