package io.github.alantcote.fxutilities.javafx.windowprefs;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Test case for {@link DelayedJobJar}.
 */
public class DelayedJobJarTest {

	/**
	 * Test method for {@link DelayedJobJar#add(java.lang.Runnable)}.
	 */
	@Test
	public void testAddRunnable() {
		SimpleIntegerProperty traceProperty = new SimpleIntegerProperty(0);
		DelayedJobJar fixture = new DelayedJobJar() {

			@Override
			protected void startTimer() {
				assertEquals(0, traceProperty.get());
				
				traceProperty.set(1);
			}
			
		};
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		
		assertNotNull(fixture);
		assertNotNull(fixture.queue);
		assertTrue(fixture.queue.isEmpty());
		
		fixture.add(testRunnable);
		
		assertEquals(1, traceProperty.get());
		assertEquals(1, fixture.queue.size());
		assertEquals(testRunnable, fixture.queue.get(0).getTask());
		assertEquals(DelayedJob.DEFAULT_DELAY, fixture.queue.get(0).getDelay());
	}

	/**
	 * Test method for {@link DelayedJobJar#add(java.lang.Runnable, int)}.
	 */
	@Test
	public void testAddRunnableInt() {
		SimpleIntegerProperty traceProperty = new SimpleIntegerProperty(0);
		DelayedJobJar fixture = new DelayedJobJar() {

			@Override
			protected void startTimer() {
				assertEquals(0, traceProperty.get());
				
				traceProperty.set(1);
			}
			
		};
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		int testDelay = 5;
		
		assertNotNull(fixture);
		assertNotNull(fixture.queue);
		assertTrue(fixture.queue.isEmpty());
		
		fixture.add(testRunnable, testDelay);
		
		assertEquals(1, traceProperty.get());
		assertEquals(1, fixture.queue.size());
		assertEquals(testRunnable, fixture.queue.get(0).getTask());
		assertEquals(testDelay, fixture.queue.get(0).getDelay());
	}

	/**
	 * Test method for {@link DelayedJobJar#clear()}.
	 */
	@Test
	public void testClear() {
		SimpleIntegerProperty traceProperty = new SimpleIntegerProperty(0);
		DelayedJobJar fixture = new DelayedJobJar() {

			@Override
			protected void startTimer() {
				assertEquals(0, traceProperty.get());
				
				traceProperty.set(1);
			}
			
		};
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		
		assertNotNull(fixture);
		assertNotNull(fixture.queue);
		assertTrue(fixture.queue.isEmpty());
		
		fixture.add(testRunnable);
		
		assertEquals(1, traceProperty.get());
		assertEquals(1, fixture.queue.size());
		assertEquals(testRunnable, fixture.queue.get(0).getTask());
		assertEquals(DelayedJob.DEFAULT_DELAY, fixture.queue.get(0).getDelay());
		
		fixture.clear();
		
		assertTrue(fixture.queue.isEmpty());
	}

	/**
	 * Test method for {@link DelayedJobJar#DelayedJobJar()}.
	 */
	@Test
	public void testDelayedJobJar() {
		DelayedJobJar fixture = new DelayedJobJar();
		
		assertNotNull(fixture);
		assertNotNull(fixture.queue);
		assertTrue(fixture.queue.isEmpty());
	}

	/**
	 * Test method for {@link DelayedJobJar#handle(long)}.
	 */
	@Test
	public void testHandle() {
		SimpleIntegerProperty traceProperty = new SimpleIntegerProperty(0);
		DelayedJobJar fixture = new DelayedJobJar() {

			@Override
			protected void startTimer() {
				assertEquals(0, traceProperty.get());
				
				traceProperty.set(1);
			}

			@Override
			protected void stopTimer() {
				assertEquals(2, traceProperty.get());
				
				traceProperty.set(3);
			}

			@Override
			protected void jobRun(DelayedJob job) {
				assertEquals(1, traceProperty.get());
				
				traceProperty.set(2);
			}
			
		};
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		int testDelay = 2;
		
		fixture.add(testRunnable, testDelay);
		assertEquals(1, traceProperty.get());
		
		// make sure that handle() decrements delays.
		fixture.handle(2);

		assertEquals(1, traceProperty.get());
		assertEquals(1, fixture.queue.get(0).getDelay());
		
		// make sure that handle() handles tasks with expired delays properly.
		fixture.handle(3);

		assertEquals(3, traceProperty.get());
		assertTrue(fixture.queue.isEmpty());
	}

	/**
	 * Test method for {@link DelayedJobJar#newDelayedJob(java.lang.Runnable, int)}.
	 */
	@Test
	public void testNewDelayedJob() {
		DelayedJobJar fixture = new DelayedJobJar();
		Runnable testRunnable = new Runnable() {

			@Override
			public void run() {
				// NOTHING
			}
			
		};
		int testDelay = 5;
		
		assertNotNull(fixture);
		
		DelayedJob testDelayedJob = fixture.newDelayedJob(testRunnable, testDelay);
		
		assertEquals(testRunnable, testDelayedJob.getTask());
		assertEquals(testDelay, testDelayedJob.getDelay());
	}

	/**
	 * Test method for {@link DelayedJobJar#startTimer()}.
	 */
	@Test
	public void testStartTimer() {
		// This trivial unit test shim needs no test.
	}

	/**
	 * Test method for {@link DelayedJobJar#stopTimer()}.
	 */
	@Test
	public void testStopTimer() {
		// This trivial unit test shim needs no test.
	}

}
