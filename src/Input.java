
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input implements Observer {

	String mess;

	@Override
	public void update(Message message) {

	}

	public void attach(Object inputTest) {
	}

	public List<String> read() {

		List<String> red = new ArrayList<>();

		try {
			File file = new File("kwic.txt");
			Scanner reader = new Scanner(file);
			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				red.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return red;

	}
}
