package com.bridgelabz.util;

import java.util.List;

public class Searching {
	
	public static int binarySearch(int[] inputArray, int key) {
		int start = 0;
		int end = inputArray.length - 1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(key == inputArray[mid]) 
				return mid;
			if(key < inputArray[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
	    return -1;
	}
	
	public static int binarySearch(String[] names, String key) {
		int first = 0;
		int last = names.length - 1;
		while(first <=  last) {
			int middle = (last + (last - first)) / 2;
			int result = key.compareTo(names[middle]);
			if(result == 0)
				return middle;
			if(result > 0)
				first = middle + 1;
			else
				last = middle - 1;
		}
		return -1;
	}
	
	public static <G> int linearSearch(List<G> list, G key) {
		for(int index = 0; index < list.size(); index++) {
			if(key.equals(list.get(index)))
				return index;
		}
		return -1;
	}
	
	public static <G> int linearSearch(G[] array, G key) {
		for(int index = 0; index < array.length; index++) {
			if(key.equals(array[index]))
				return index;
		}
		return -1;
	}
	
}
