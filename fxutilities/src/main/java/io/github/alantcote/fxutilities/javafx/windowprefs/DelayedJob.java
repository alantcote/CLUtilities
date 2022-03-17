package io.github.alantcote.fxutilities.javafx.windowprefs;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * A wrapper for a {@link Runnable} that will be run in the JavaFX application
 * thread after a delay.
 */
public class DelayedJob implements Runnable {
	/**
	 * The default delay.
	 */
	public static final int DEFAULT_DELAY = 3;

	/**
	 * The number of ticks to delay before running the task.
	 */
	protected SimpleIntegerProperty delayProperty =
			new SimpleIntegerProperty(DEFAULT_DELAY);

	/**
	 * The actual task to be run.
	 */
	protected SimpleObjectProperty<Runnable> taskProperty =
			new SimpleObjectProperty<Runnable>(null);

	/**
	 * Construct a new object with a given task and default delay.
	 * 
	 * @param task the task.
	 */
	public DelayedJob(Runnable task) {
		this(task, DEFAULT_DELAY);
	}

	/**
	 * Construct a new object with a given task and delay.
	 * 
	 * @param task  the task.
	 * @param delay the number of ticks to delay before running the task.
	 */
	public DelayedJob(Runnable task, int delay) {
		taskProperty.set(task);
		delayProperty.set(delay);
	}

	/**
	 * Get the delay.
	 * 
	 * @return the delay.
	 */
	public int getDelay() {
		return delayProperty.get();
	}

	/**
	 * Get the task.
	 * 
	 * @return the task.
	 */
	public Runnable getTask() {
		return taskProperty.get();
	}

	/**
	 * Run the task. If the task is {@code null}, do nothing.
	 */
	@Override
	public void run() {
		Runnable task = taskProperty.get();

		if (task != null) {
			platformRunLater(task);
		}
	}

	/**
	 * Set the delay.
	 * 
	 * @param delay the new delay.
	 */
	public void setDelay(int delay) {
		delayProperty.set(delay);
	}

	/**
	 * Run a task in the JavaFX application thread.
	 * @param task the task.
	 */
	protected void platformRunLater(Runnable task) {
		Platform.runLater(task);
	}

}
