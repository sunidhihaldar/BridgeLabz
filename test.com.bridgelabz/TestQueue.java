import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bridgelabz.dataStructure.Queue;

class TestQueue {

	Queue<Integer> queue = new Queue<Integer>();
	
	@Test
	public void test_Queue_emptyStatus() {
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void test_Queue_length_whenEmpty() {
		assertEquals(0, queue.size());
	}

	@Test
	public void test_Queue_length_whenNotEmpty() {
		queue.enqueue(10);
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void test_Queue_enqueue_whenNotEmpty() {
		queue.enqueue(20);
		assertEquals(1, queue.size());
		assertFalse(queue.isEmpty());
	}
	
/*	@Test
	public void test_Queue_dequeue_whenEmpty() {
		assertEquals("Queue is empty", queue.dequeue());
	} */
	
	@Test
	public void test_Queue_dequeue_whenNotEmpty() {
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(40);
		assertEquals(Integer.valueOf(10), queue.dequeue());
		assertEquals(Integer.valueOf(30), queue.dequeue());
		assertEquals(Integer.valueOf(40), queue.dequeue());
	}
	
	@Test
	public void test_Queue_First_whenNotEmpty() {
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(40);
		assertEquals(Integer.valueOf(10), queue.first());
	}
	
	@Test
	public void test_Queue_Last_whenNotEmpty() {
		queue.enqueue(10);
		queue.enqueue(30);
		queue.enqueue(40);
		assertEquals(Integer.valueOf(40), queue.last());
	}
	
}
