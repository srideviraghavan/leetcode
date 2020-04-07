import java.lang.Math;

class Solution {
	public int divideTimeOut(int dividend, int divisor) {
		if (divisor == 0) {
			throw new RuntimeException("Divisor cannot be zero");
		}
		int sign = Integer.signum(dividend) * Integer.signum(divisor);

		if (dividend <= Integer.MIN_VALUE)
			dividend = Integer.MAX_VALUE;
		if (divisor <= Integer.MIN_VALUE)
			divisor = Integer.MAX_VALUE;
		int quotient = 0;

		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while (dividend >= divisor) {
			quotient++;
			dividend = (Math.abs(dividend) - Math.abs(divisor));
		}
		return quotient * sign;
	}

	public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			throw new RuntimeException("Divisor cannot be zero");
		}

		long quotient = 0;
		int sign = Integer.signum(dividend) * Integer.signum(divisor);

		long dividendLong = Math.abs((long) dividend);
		long divisorLong = Math.abs((long) divisor);

		while (dividendLong >= divisorLong) {
			long temp = divisorLong;
			int shift = 0;
			while (dividendLong >= temp) {
				shift++;
				temp <<= 1;
			}
			quotient += (long) 1 << (shift - 1);
			temp >>= 1;
			dividendLong -= temp;
		}

		quotient = quotient * sign;

		if (quotient >= Integer.MAX_VALUE) {
			quotient = Integer.MAX_VALUE;
		} else if (quotient <= Integer.MIN_VALUE) {
			quotient = Integer.MIN_VALUE;
		}

		return (int) quotient;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.divide(-2147483648, -1));
	}
}