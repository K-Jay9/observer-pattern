import java.util.List;

public class MasterControl {

	public static void main(String[] args) {
		MasterControl mastercontrol = new MasterControl();
		mastercontrol.start();
	}

	void start() {
		Input input = new Input();
		List<String> input_data = input.read();

		CircularShifter circularShifter = new CircularShifter();
		List<String> circular_data = circularShifter.shiftLines(input_data);

		Alphabetizer alphabetizer = new Alphabetizer();
		List<String> alpha_data = alphabetizer.sort(circular_data);

		Message observable = new Message();

		observable.addObserver(input);
		observable.setMessage(input_data);

		observable.addObserver(circularShifter);
		observable.setMessage(circular_data);

		observable.addObserver(alphabetizer);
		observable.setMessage(alpha_data);

	}
}
