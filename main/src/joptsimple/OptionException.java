package joptsimple;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class OptionException extends RuntimeException {
	private static final long serialVersionUID = -1L;
	private final List<String> options = new ArrayList();

	protected OptionException(Collection<String> options) {
		this.options.addAll(options);
	}

	protected OptionException(Collection<String> options, Throwable cause) {
		super(cause);

		this.options.addAll(options);
	}

	public Collection<String> options() {
		return Collections.unmodifiableCollection(this.options);
	}

	protected final String singleOptionMessage() {
		return singleOptionMessage((String) this.options.get(0));
	}

	protected final String singleOptionMessage(String option) {
		return "'" + option + "'";
	}

	protected final String multipleOptionMessage() {
		StringBuilder buffer = new StringBuilder("[");
		for (Iterator<String> iter = this.options.iterator(); iter.hasNext();) {
			buffer.append(singleOptionMessage((String) iter.next()));
			if (iter.hasNext()) {
				buffer.append(", ");
			}
		}
		buffer.append(']');

		return buffer.toString();
	}

	static OptionException unrecognizedOption(String option) {
		return new UnrecognizedOptionException(option);
	}
}