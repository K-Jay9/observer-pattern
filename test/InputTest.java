import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputTest implements Observer {

	List<String> actual = new ArrayList<String>();
	Input input;

	@BeforeEach
	void setUp() throws FileNotFoundException {
		input = new Input();
		input.attach(this);
	}

	@Test
	void input_from_scanner() throws IOException {
		List<String> lines = new ArrayList<String>();
		lines.add("Descent of Man");
		lines.add("The Ascent of Man");
		lines.add("The Old Man and The Sea");
		lines.add("A Portrait of The Artist As a Young Man");
		FileWriter fileWriter = new FileWriter("kwic.txt");
		for (String line : lines) {
			fileWriter.write(line);
			fileWriter.write("\n");
		}
		fileWriter.close();

		assertThrows(IllegalStateException.class, () -> {
			input.read();
		});

		assertSame(4, actual.size());
		assertEquals("Descent of Man", actual.get(0));
		assertEquals("The Ascent of Man", actual.get(1));
		assertEquals("The Old Man and The Sea", actual.get(2));
		assertEquals("A Portrait of The Artist As a Young Man", actual.get(3));
	}

	@Override
	public void update(Message message) {
		actual.add(message.getString());
	}

}
