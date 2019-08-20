package de.codingchallenge;

import org.testcontainers.containers.GenericContainer;

abstract class ContainerBaseTest {
	static final GenericContainer MONGO_CONTAINER;

	static {
		MONGO_CONTAINER = new GenericContainer("mongo:latest").withExposedPorts(27017);
		MONGO_CONTAINER.start();
	}

	ContainerBaseTest() {
	}
}

