import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Output implements Observer {

	List<String> test = new ArrayList<>();

	public void write(List<String> lines) {
		try {
			FileWriter myObj = new FileWriter("kwic_output.txt");
			for (String line : lines) {
				myObj.write(line);
				myObj.write("\n");
			}
			myObj.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Message mess) {
		if (mess.str != null) {
			test.add(mess.getString());
			this.write(test);
		}

	}

}
