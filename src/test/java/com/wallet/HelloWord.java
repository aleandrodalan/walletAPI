package com.wallet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloWord {
	
	@Test
	public void testHelloWord() {
		Assertions.assertEquals(1, 1);
	}
}