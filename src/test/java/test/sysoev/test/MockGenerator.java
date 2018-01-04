package test.sysoev.test;


import java.util.Random;
import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import test.sysoev.Loggable;
import test.sysoev.NumberGenerator;
import test.sysoev.ThirteenDigits;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {
	@Inject
	private Logger logger;

	@Loggable
	public String generateNumber() {
		String mock = "MOCK" + Math.abs(new Random().nextInt());
		logger.info("lalala Mock: " + mock);
		return mock;
	}
}
