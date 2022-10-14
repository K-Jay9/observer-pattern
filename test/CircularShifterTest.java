import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularShifterTest implements Observer {

	List<String> actual = new ArrayList<String>();
	CircularShifter circularShifter;

	@BeforeEach
	void setUp() throws Exception {
		circularShifter = new CircularShifter();
		circularShifter.attach(this);
	}

	@Test
	void shift_2_lines_completely() {
		circularShifter.update(new Message("hi bye foo"));
		circularShifter.update(new Message("hi bye"));
		assertThrows(IllegalStateException.class, () -> {
			circularShifter.update(new Message(true));
		});

		assertSame(5, actual.size());
		assertTrue(actual.contains("bye hi"));
		assertTrue(actual.contains("hi bye"));
		assertTrue(actual.contains("foo hi bye"));
		assertTrue(actual.contains("bye foo hi"));
		assertTrue(actual.contains("hi bye foo"));
	}

	@Override
	public void update(Message message) {
		actual.add(message.getString());
	}

}
