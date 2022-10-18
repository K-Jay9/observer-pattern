final class Message {

	String str;
	boolean bool;
	boolean state = false;

	Message() {

	}

	Message(String s) {
		this.str = s;
		this.bool = false;
	}

	Message(boolean b) {
		this.str = null;
		this.bool = b;
	}

	String getString() throws IllegalStateException {

		if (this.str == null) {
			throw new IllegalStateException(
					"Signals that a method has been invoked at an illegal or inappropriate time.");
		}
		return this.str;
	}
}
