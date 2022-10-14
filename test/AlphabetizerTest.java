import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlphabetizerTest implements Observer {

	List<String> actual = new ArrayList<String>();
	Alphabetizer alphabetizer;

	@BeforeEach
	void setUp() throws Exception {
		alphabetizer = new Alphabetizer();
		alphabetizer.attach(this);
	}

	@Test
	void alpha_2_lines() {
		alphabetizer.update(new Message("hi bye foo"));
		alphabetizer.update(new Message("bye hi"));
		assertThrows(IllegalStateException.class, () -> {
			alphabetizer.update(new Message(true));
		});

		assertSame(2, actual.size());
		assertEquals("bye hi", actual.get(0));
		assertEquals("hi bye foo", actual.get(1));
	}

	@Override
	public void update(Message message) {
		actual.add(message.getString());
	}

}
