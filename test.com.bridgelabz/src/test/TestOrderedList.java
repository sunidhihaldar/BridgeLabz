package src.test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.bridgelabz.dataStructure.ImplementingLinkedList;

import com.bridgelabz.dataStructure.OrderedList;

class TestOrderedList {
	
		ImplementingLinkedList<Integer> list = new ImplementingLinkedList<Integer>();

		@Test
		public void test_orderedList_RemoveOperation_whenValueIsPresentInList() {
			list.insert(10);
			list.insert(20);
			list.insert(30);
			list.insert(40);
			OrderedList.addRemoveOperation(30, list);
			assertFalse(list.search(30));

		}
		
		@Test
		public void test_orderedList_RemoveOperation_atLastValue_whenValueIsPresentInList() {
			list.insert(10);
			list.insert(20);
			list.insert(30);
			list.insert(40);
			OrderedList.addRemoveOperation(40, list);
			assertFalse(list.search(40));

		}

		@Test
		public void test_orderedList_AdditionOperation_atLast_whenValueNotPresentInList() {
			list.insert(10);
			list.insert(20);
			OrderedList.addRemoveOperation(40, list);
			list.insert(50);
			assertTrue(list.search(20));
		}

		@Test
		public void test_orderedList_AdditionOperation_whenValueNotPresentInList() {
			list.insert(10);
			list.insert(20);
			OrderedList.addRemoveOperation(40, list);
			assertTrue(list.search(40));
		}
		
		@Test
		public void test_orderedList_AdditionOperation_atStart_whenListIsEmpty() {
			
			OrderedList.addRemoveOperation(40, list);
			assertTrue(list.search(40));
		}
	
}
