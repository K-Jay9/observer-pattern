import java.util.ArrayList;
import java.util.List;

public class Alphabetizer implements Observer {

	List<String> res = new ArrayList<>();

	public void attach(Object alphabetizerTest) {
	}

	public List<String> sort(List<String> lines) {

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
