package com.example.java.mockito;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Iterator;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class TestWithMockito {

	@Test
	public void testQuery() {

		Iterator iterator = mock(Iterator.class);
		when(iterator.next()).thenReturn("hi").thenReturn("Rahul");

		String result = iterator.next() + " " + iterator.next();

		AssertJUnit.assertEquals("hi Rahul", result);
	}
}