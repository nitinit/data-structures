package com.problems.general; /**
 * 
 */

/**
 * @author Raja Jain
 * 
 */
public class RearrangeAlternativePositiveNegativeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// int arr[] = { -5, 3, -4, -7, -1, -2, 6, 7 };
		int arr[] = { -5, -2, 5, 2, 4, 7, -1, 8, 0, -8 };
		int outOfPlace = -1;
		for (int index = 0; index < arr.length; index++) {
			if (outOfPlace >= 0) {
				if ((arr[index] >= 0 && (arr[outOfPlace] < 0))
						|| (arr[index] < 0 && arr[outOfPlace] >= 0)) {
					int tmp = arr[index];
					for (int i = index; i > outOfPlace; i--) {
						arr[i] = arr[i - 1];
					}
					arr[outOfPlace] = tmp;
					if (index - outOfPlace > 2) {
						outOfPlace = outOfPlace + 2;
					} else {
						outOfPlace = -1;
					}
				}
			}

			if (outOfPlace == -1) {
				if ((arr[index] >= 0 && (index & 0x01) == 0)
						|| ((arr[index] < 0 && (index & 0x01) == 1))) {
					outOfPlace = index;
				}
			}

		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}

	}

}
