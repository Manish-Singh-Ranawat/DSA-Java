// Armstrong Number - https://www.naukri.com/code360/problems/armstrong-number_1462443

// You are given an integer ‘NUM’ . Your task is to find out whether this number is an Armstrong number or not.
// A k-digit number ‘NUM’ is an Armstrong number if and only if the k-th power of each digit sums to ‘NUM’.

// 153 = 1^3 + 5^3 + 3^3.
// Therefore 153 is an Armstrong number.

public class ArmstrongNumber {
    public static boolean isArmstrong(int num) {
        int k = String.valueOf(num).length();
		int sum = 0;
		int n = num;
		while (n > 0) {
			int lastDigit = n % 10;
			n /= 10;
			sum += Math.pow(lastDigit, k);
			if (sum > num) {
				return false;
			}
		}
		return num == sum;
    }

    public static void main(String[] args) {
        int num = 153;
        System.out.println(isArmstrong(num));
		// true
    }
}
