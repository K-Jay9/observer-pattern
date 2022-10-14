import java.util.ArrayList;
import java.util.List;

public class CircularShifter implements Observer {

	List<String> res = new ArrayList<>();

	public void attach(Object circularShifterTest) {
	}

	public List<String> shiftLines(List<String> lines) {

		res = lines;

		return lines;
	}

	@Override
	public void update(Message mess) throws IllegalStateException {
		if (mess.str == null) {
			throw new IllegalStateException();
		}
		Message message = new Message();
		message.setMessage(res);
	}

}
