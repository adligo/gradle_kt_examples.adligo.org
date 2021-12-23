package org.adligo.javaSingle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

	public static void main(String [] args) {
		System.out.println("Hello World " + args);
		Logger log = LoggerFactory.getLogger(App.class);
		log.warn("Logback warn check");
	}
}
