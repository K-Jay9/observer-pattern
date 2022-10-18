import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CircularShifter extends Subject implements Observer {

	List<String> test = new ArrayList<>();
	List<String> circular = new ArrayList<>();
	HashSet<String> hash;

	@Override
	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	public List<String> shiftLines(List<String> lines) {
		String res = "";
		for (String line : lines) {
			int k = line.length();
			String[] arr = new String[line.length()];
			arr = line.split(" ");
			while (k-- > 0) {
				String tmp = arr[0];
				for (int i = 1; i < arr.length; i++) {
					arr[i - 1] = arr[i];
				}
				arr[arr.length - 1] = tmp;
				for (String st : arr) {
					res += st + " ";
				}
				if (res.equals(line)) {
					break;
				}
				circular.add(res.trim());
				hash = new HashSet<>(circular);
				res = "";
			}
		}
		List<String> result = new ArrayList<>(hash);
		return result;
	}

	@Override
	public void update(Message message) {
		if (message.str == null) {
			List<String> shift = this.shiftLines(test);
			for (String re : shift) {
				this.notifyObserver(new Message(re));
			}
		}
		test.add(message.getString());

	}
}
