import java.util.Scanner;

public class Solution {

	private static int targetValue;
	private static int numberOfCoinValues;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		targetValue = scanner.nextInt();
		numberOfCoinValues = scanner.nextInt();

		int[] coinValues = new int[numberOfCoinValues];

		for (int i = 0; i < numberOfCoinValues; i++) {
			coinValues[i] = scanner.nextInt();
		}
		scanner.close();

		long result = totalWaysToComposeTargetValue(coinValues);
		System.out.println(result);
	}

	private static long totalWaysToComposeTargetValue(int[] coinValues) {
		long[] waysToMakeChange = new long[targetValue + 1];
		waysToMakeChange[0] = 1;

		for (int i = 0; i < numberOfCoinValues; i++) {
			for (int j = coinValues[i]; j <= targetValue; j++) {
				waysToMakeChange[j] += waysToMakeChange[j - coinValues[i]];
			}
		}
		return waysToMakeChange[targetValue];
	}
}
