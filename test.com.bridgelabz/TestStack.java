import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.bridgelabz.dataStructure.Stack;
import java.util.EmptyStackException;

class TestStack {

	Stack<Integer> stack = new Stack<Integer>();
	
	@Test
	public void test_Stack_emptyStatus() {
		assertTrue(stack.isEmpty());
	}

	@Test
	public void test_Stack_length_whenEmpty() {
		assertEquals(0, stack.size());
	}
	
	@Test
	public void test_Stack_length_whenNotEmpty() {
		stack.push(10);
		assertEquals(1, stack.size());
		assertFalse(stack.isEmpty());
	}
	
	@Test
	public void test_Stack_push_whenNotEmpty() {
		stack.push(10);
		assertEquals(1, stack.size());
	}
	
	@Test
	public void test_Stack_pop_whenNotEmpty() {
		stack.push(10);
		stack.push(20);
		stack.push(30);
		assertEquals(Integer.valueOf(30), stack.pop());
		assertEquals(Integer.valueOf(20), stack.pop());
		assertEquals(Integer.valueOf(10), stack.pop());
	}
	
	@Test
	public void test_Stack_peek_whenNotEmpty() {
//		stack.push(10);
//		stack.push(20);
//		assertEquals(Integer.valueOf(20), stack.peek());
		assertThrows(EmptyStackException.class,()-> stack.peek());
	}
	 
}
