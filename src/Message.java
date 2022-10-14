import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

final class Message extends Observable {

	String str;
	boolean bool;
	boolean isFinished = false;
	private List<Observer> observers = new ArrayList<>();

	Message() {

	}

	Message(String s) {
		this.str = s;
		bool = false;
	}

	Message(boolean bool) {
		this.bool = bool;
		this.str = null;
	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void setMessage(List<String> str) {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

	String getString() throws IllegalStateException {
		if (this.str == null) {
			throw new IllegalStateException();
		}
		return this.str;
	}
}
