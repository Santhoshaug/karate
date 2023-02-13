package com.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

public class ParallelRunner {

	@Test
	public void featureFileRunner() {
		Results results = Runner.path("classpath:com/api/test").tags("~@ignore").outputCucumberJson(true).parallel(5);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
