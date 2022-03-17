package io.github.alantcote.fxutilities.javafx.windowprefs;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Test Case for {@link DelayedJob}.
 */
public class DelayedJobTest {

	/**
	 * Test method for {@link DelayedJob#DelayedJob(java.lang.Runnable)}.
	 */
	@Test
	public void testDelayedJobRunnable() {
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		DelayedJob fixture = new DelayedJob(testRunnable);
		
		assertEquals(testRunnable, fixture.taskProperty.get());
		assertEquals(DelayedJob.DEFAULT_DELAY, fixture.delayProperty.get());
	}

	/**
	 * Test method for {@link DelayedJob#DelayedJob(java.lang.Runnable, int)}.
	 */
	@Test
	public void testDelayedJobRunnableInt() {
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		int testDelay = 5;
		DelayedJob fixture = new DelayedJob(testRunnable, testDelay);
		
		assertEquals(testRunnable, fixture.taskProperty.get());
		assertEquals(testDelay, fixture.delayProperty.get());
	}

	/**
	 * Test method for {@link DelayedJob#getDelay()}.
	 */
	@Test
	public void testGetDelay() {
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		int testDelay = 5;
		DelayedJob fixture = new DelayedJob(testRunnable, testDelay);
		
		assertEquals(fixture.delayProperty.get(), fixture.getDelay());
	}

	/**
	 * Test method for {@link DelayedJob#getTask()}.
	 */
	@Test
	public void testGetTask() {
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		int testDelay = 5;
		DelayedJob fixture = new DelayedJob(testRunnable, testDelay);
		
		assertEquals(fixture.taskProperty.get(), fixture.getTask());
	}

	/**
	 * Test method for {@link DelayedJob#run()}.
	 */
	@Test
	public void testRun() {
		// There are 2 cases, an ordinary task and a null task.
		SimpleIntegerProperty traceProperty = new SimpleIntegerProperty(0);
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		int testDelay = 5;
		DelayedJob fixture;
		
		// Case 1: an ordinary task
		traceProperty.set(0);
		fixture = new DelayedJob(testRunnable, testDelay) {

			@Override
			protected void platformRunLater(Runnable task) {
				assertEquals(0, traceProperty.get());
				
				traceProperty.set(1);
			}
			
		};
		
		fixture.run();
		
		assertEquals(1, traceProperty.get());
		
		// Case 2: a null task
		traceProperty.set(0);
		fixture = new DelayedJob(null, testDelay);
		
		fixture.run();
		
		assertEquals(0, traceProperty.get());
	}

	/**
	 * Test method for {@link DelayedJob#setDelay(int)}.
	 */
	@Test
	public void testSetDelay() {
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		int testDelay = 5;
		DelayedJob fixture = new DelayedJob(testRunnable, testDelay);
		
		testDelay = 6;
		
		fixture.setDelay(testDelay);
		
		assertEquals(testDelay, fixture.delayProperty.get());
	}

	/**
	 * Test method for {@link DelayedJob#platformRunLater(java.lang.Runnable)}.
	 */
	@Test
	public void testPlatformRunLater() {
		// This is a trivial test hook, and needs no test.
	}

}
