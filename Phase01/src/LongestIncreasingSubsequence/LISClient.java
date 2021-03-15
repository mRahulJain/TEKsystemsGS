package LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LISClient {

	static Scanner scn = new Scanner(System.in);
	static int curr_max;
	static int count_max;
	
	public static void main(String[] args) {
		System.out.print("Enter the number of element: ");
		int N = scn.nextInt();
		System.out.print("Enter "+N+" element(s): ");
		int[] inputArray = getArray(N);
		System.out.println();
		System.out.println("Here is the longest increasing subsequence -> ");
		List<Integer> seq = getLIS(inputArray, N);
		System.out.println("Size "+seq.size()+": "+seq.toString());
	}
	
	
	private static List<Integer> getLIS(int[] array, int size) {
		List<Integer> lis = new ArrayList<Integer>();
		List<Integer> lis_helper = new ArrayList<Integer>();
		count_max = 0;
		
		IntStream.range(0, size)
		.forEach(i -> {
			curr_max = Integer.MIN_VALUE;
			IntStream.range(i, size)
			.forEach(j -> {
				if(array[j] > curr_max) {
					lis_helper.add(array[j]);
					curr_max = array[j];
				}
			});
			if(count_max < lis_helper.size()) {
				lis.clear();
				count_max = lis_helper.size();
				lis.addAll(lis_helper);
			}
			lis_helper.clear();
		});
		
		return lis;
	}
	
	private static int[] getArray(int size) {
		int[] toReturnArray = new int[size];
		IntStream.range(0, size)
		.forEach(i -> {
			toReturnArray[i] = scn.nextInt();
		});
		return toReturnArray;
	}

}
