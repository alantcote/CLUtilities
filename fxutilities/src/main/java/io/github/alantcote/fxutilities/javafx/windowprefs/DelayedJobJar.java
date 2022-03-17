package io.github.alantcote.fxutilities.javafx.windowprefs;

import java.util.LinkedList;
import java.util.List;

import javafx.animation.AnimationTimer;

/**
 * A queue of tasks to be run after delays.
 * 
 * Each task (a {@link Runnable}) is paired with a delay, measured in frames.
 * When the number of frames given by the delay have passed, the task is run in
 * the JavaFX application thread.
 */
public class DelayedJobJar extends AnimationTimer {
	/**
	 * The task queue.
	 */
	List<DelayedJob> queue = new LinkedList<DelayedJob>();

	/**
	 * Construct a new object.
	 */
	public DelayedJobJar() {
		super();
	}

	/**
	 * Add a task to the queue with a default delay.
	 * 
	 * @param task the task.
	 */
	public void add(Runnable task) {
		add(task, DelayedJob.DEFAULT_DELAY);
	}

	/**
	 * Add a task to the queue with a given delay.
	 * 
	 * @param task  the task.
	 * @param delay the delay.
	 */
	public void add(Runnable task, int delay) {
		if (queue.isEmpty()) {
			startTimer();
		}
		
		queue.add(newDelayedJob(task, delay));
	}
	
	/**
	 * Remove all the tasks from the queue.
	 */
	public void clear() {
		queue.clear();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Traverse the list of tasks, decrementing their delay values. When a delay
	 * value drops below 1, the corresponding task is run in the JavaFX application
	 * thread and the list entry is removed from the list.
	 */
	@Override
	public void handle(long now) {
		List<DelayedJob> expiredList = new LinkedList<DelayedJob>();

		// age the jobs in the queue
		for (DelayedJob job : queue) {
			int delay = job.getDelay() - 1;

			job.setDelay(delay);

			if (delay < 1) {
				expiredList.add(job);
			}
		}

		// remove expired entries from the queue
		queue.removeAll(expiredList);

		// dispatch the expired jobs
		for (DelayedJob job : expiredList) {
			jobRun(job);
		}
		
		// turn off the timer if the queue is empty
		if (queue.isEmpty()) {
			stopTimer();
		}
	}

	/**
	 * Run a job.
	 * @param job the job to run.
	 */
	protected void jobRun(DelayedJob job) {
		job.run();
	}

	/**
	 * Factory method for {@link DelayedJob} objects.
	 * 
	 * @param task  the task for the constructor.
	 * @param delay the delay for the constructor.
	 * @return a new object.
	 */
	protected DelayedJob newDelayedJob(Runnable task, int delay) {
		return new DelayedJob(task, delay);
	}

	/**
	 * Start the animation timer.
	 */
	protected void startTimer() {
		start();
	}

	/**
	 * Stop the animation timer.
	 */
	protected void stopTimer() {
		stop();
	}

}
