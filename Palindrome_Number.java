public class Palindrome_Number {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNum = 0;
        while (x > reversedNum) {
            int lastDigit = x % 10;
            reversedNum = reversedNum * 10 + lastDigit;
            x /= 10; // Integer division in Java
        }

        return x == reversedNum || x == reversedNum / 10;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }
}
