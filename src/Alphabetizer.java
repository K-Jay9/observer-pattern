import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Alphabetizer extends Subject implements Observer {

	List<String> ts_res;
	List<String> test = new ArrayList<>();

	@Override
	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	public List<String> sort(List<String> lines) {
		TreeSet<String> tree_set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
		for (String line : lines) {
			tree_set.add(line);
		}
		ts_res = new ArrayList<>(tree_set);
		return ts_res;
	}

	@Override
	public void update(Message mess) {
		if (mess.str == null) {
			List<String> result = this.sort(test);
			for (String ts : result) {
				this.notifyObserver(new Message(ts));
				this.observers.remove(this);
			}
		}
		test.add(mess.getString());

	}

}
