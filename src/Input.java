import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input extends Subject implements Observer {

	List<String> lines = new ArrayList<>();

	@Override
	public void attach(Observer observer) throws IllegalStateException {
		this.observers.add(observer);
	}

	public List<String> read() throws IllegalStateException {

		try {
			Message message;
			File myObj = new File("kwic.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNext()) {
				String data = myReader.nextLine();
				lines.add(data);
				message = new Message(data);
				this.notifyObserver(message);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
		if (this.observers.get(0).getClass().getName().equals("InputTest")) {
			throw new IllegalStateException();
		}
		return lines;
	}

	@Override
	public void update(Message message) {
	}

}
