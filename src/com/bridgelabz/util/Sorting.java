package com.bridgelabz.util;

import java.util.List;

public class Sorting {
	public static String[] insertionSort(String[] array) {
		for(int i = 0; i < array.length; i++) {
			for(int  j = i + 1; j < array.length; j++) {
				if(array[i].compareTo(array[j]) > 0) {
					String temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public static int[] insertionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int valueToSort = array[i];
			int  j = i;
			while(j > 0 && array[j -1] > valueToSort) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = valueToSort;
		}
		return array;
	}
	
	public static int[] bubbleSort(int[] array) {
		int n  = array.length;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - i -1; j++) {
				if(array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
	
	public static <G extends Comparable<G>> void swap(List<G> list, int firstPosition, int secondPosition) {
		G temp = list.get(firstPosition);
		list.set(firstPosition, list.get(secondPosition));
		list.set(secondPosition, temp);
	}
	
	public static <G extends Comparable<G>> List<G> selectionSort(List<G> list) {
		for(int i = 0; i < list.size(); i++) {
			int minPosition = -1;
			G minValue = list.get(i);
			for(int j = i + 1; j < list.size(); j++) {
				G secondPosition = list.get(j);
				if(minValue.compareTo(secondPosition) > 0) {
					minPosition = j;
					minValue = list.get(j);
				}
			}
			if(minPosition >= 0) {
				swap(list, i, minPosition);
			}
		}
		return list;
	}
}
