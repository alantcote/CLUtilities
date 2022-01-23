package io.github.alantcote.clutilities.jmock;

import org.jmock.Mockery;
import org.jmock.Sequence;
import org.jmock.imposters.ByteBuddyClassImposteriser;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.Before;

/**
 * A superclass for JUnit test cases that use JMock.
 * 
 * {@link ByteBuddyClassImposteriser} is the imposterizer used, in order to
 * enable mocking classes as well as interfaces.
 */
public abstract class TestCaseWithJMock {
	/**
	 * The {@link Mockery}.
	 */
	protected Mockery context;

	/**
	 * The {@link Sequence}.
	 */
	protected Sequence sequence;

	/**
	 * Ensure all the expectations are satisfied.
	 * 
	 * @throws Exception if the expectations are not properly satisfied.
	 */
	@After
	public void runAfterTests() throws Exception {
		context.assertIsSatisfied();
	}

	/**
	 * Set up {@link #context} and {@link sequence}.
	 * 
	 * @throws Exception when appropriate.
	 */
	@Before
	public void runBeforeTests() throws Exception {
		context = new Mockery() {
			{
				setThreadingPolicy(new Synchroniser());
				setImposteriser(ByteBuddyClassImposteriser.INSTANCE);
			}
		};

		sequence = context.sequence(getClass().getName());
	}
}
