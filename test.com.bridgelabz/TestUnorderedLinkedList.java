

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.bridgelabz.dataStructure.ImplementingLinkedList;

class TestUnorderedLinkedList {

	ImplementingLinkedList<Integer> list = new ImplementingLinkedList<Integer>();

	@Test
	public void test_LinkedList_isEmpty_whenEmpty() {
		assertTrue(list.isEmpty());
	}

	@Test
	public void test_LinkedList_isEmpty_whenNotEmpty() {
		list.insertAtStart(10);
		assertFalse(list.isEmpty());
	}

	@Test
	public void test_LinkedList_length_whenEmpty() {
		assertEquals(0, list.length());
	}

	@Test
	public void test_LinkedList_insertAtStart_whenEmpty() {
		assertTrue(list.insertAtStart(10));
	}

	@Test
	public void test_LinkedList_insertAtStart_whenNotEmpty() {
		list.insertAtStart(20);
		assertTrue(list.insertAtStart(10));
	}

	@Test
	public void test_LinkedList_insertAtLast_whenEmpty() {
		assertTrue(list.insert(10));
	}

	@Test
	public void test_LinkedList_insertAtValidPosition_whenEmpty() {
		assertTrue(list.insert(10, 0));
	}

	@Test
	public void test_LinkedList_insertAtValidPosition_whenNotEmpty() {
		list.insert(20, 0);
		assertTrue(list.insert(10, 1));
	}

	@Test
	public void test_LinkedList_insertAtInvalidPosition_whenEmpty() {
		assertEquals(0, list.length());
		assertTrue(list.insert(10, 1));
	}

}
