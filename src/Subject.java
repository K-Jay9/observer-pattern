import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	Message message = new Message();

	List<Observer> observers = new ArrayList<>();

	void attach(Observer observer) {
		observers.add(observer);
	}

	void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	void notifyObserver(Message message) {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}

}
