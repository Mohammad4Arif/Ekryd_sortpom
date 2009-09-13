package sortpom.util;

import junit.framework.TestCase;

import org.apache.maven.plugin.MojoFailureException;

public class LineSeparatorTest extends TestCase {
	public void testCharInput() throws MojoFailureException {
		assertEquals("\n", new LineSeparator("\n").toString());
		assertEquals("\r", new LineSeparator("\r").toString());
		assertEquals("\r\n", new LineSeparator("\r\n").toString());
	}

	public void testFailedInput1() throws MojoFailureException {
		try {
			new LineSeparator("\nn").toString();
			fail();
		} catch (MojoFailureException ex) {
			assertEquals("LineSeparator must be either \\n, \\r or \\r\\n, but separator characters were [10, 110]", ex
					.getMessage());
		}
	}

	public void testFailedInput2() throws MojoFailureException {
		try {
			new LineSeparator("\n\n").toString();
			fail();
		} catch (MojoFailureException ex) {
			assertEquals("LineSeparator must be either \\n, \\r or \\r\\n, but separator characters were [10, 10]", ex
					.getMessage());
		}
	}

	public void testFailedInput3() throws MojoFailureException {
		try {
			new LineSeparator("gurka").toString();
			fail();
		} catch (MojoFailureException ex) {
			assertEquals(
					"LineSeparator must be either \\n, \\r or \\r\\n, but separator characters were [103, 117, 114, 107, 97]",
					ex.getMessage());
		}
	}

	public void testFailedInput4() throws MojoFailureException {
		try {
			new LineSeparator("").toString();
			fail();
		} catch (MojoFailureException ex) {
			assertEquals("LineSeparator must be either \\n, \\r or \\r\\n, but separator characters were []", ex
					.getMessage());
		}
	}

	public void testMixedInput() throws MojoFailureException {
		assertEquals("\r\n", new LineSeparator("\\r\n").toString());
		assertEquals("\r\n", new LineSeparator("\r\\n").toString());
	}

	public void testStringInput() throws MojoFailureException {
		assertEquals("\n", new LineSeparator("\\n").toString());
		assertEquals("\r", new LineSeparator("\\r").toString());
		assertEquals("\r\n", new LineSeparator("\\r\\n").toString());
	}

}
