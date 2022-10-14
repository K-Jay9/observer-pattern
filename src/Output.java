import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Output implements Observer {

	List<String> res = new ArrayList<>();

	public void write(List<String> lines) {

		try {
			FileWriter fw = new FileWriter("kwic_output.txt");
			for (String line : lines) {
				res.add(line);
				fw.write(line);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Message mess) throws IllegalStateException {
		if (mess.str == null) {
			Message message = new Message();
			message.setMessage(res);
			throw new IllegalStateException();
		}

	}
}
