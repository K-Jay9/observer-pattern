import java.util.List;

public class MasterControl {

	public static void main(String[] args) {
		MasterControl masterControl = new MasterControl();
		masterControl.start();
	}

	public void start() {
		Input input = new Input();
		Output output = new Output();
		CircularShifter circularShifter = new CircularShifter();
		Alphabetizer alphabetizer = new Alphabetizer();

		input.attach(circularShifter);
		circularShifter.attach(alphabetizer);
		List<String> inputData = input.read();

		List<String> circularData = circularShifter.shiftLines(inputData);

		List<String> alphaData = alphabetizer.sort(circularData);

		output.write(alphaData);

		input.removeObserver(circularShifter);
		circularShifter.removeObserver(alphabetizer);

	}

}
