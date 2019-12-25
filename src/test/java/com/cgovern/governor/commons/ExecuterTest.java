/**
 * 
 */
package com.cgovern.governor.commons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jcraft.jsch.JSchException;

/**
 * @author vamsiravi
 *
 */
class ExecuterTest {

	List<String> commands = new ArrayList<String>();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		commands.add(0, "pwd");
		commands.add(1, "cd .");
		commands.add(2, "ls -alrt");
		commands.add(3, "pwd");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {

	}

	@Test
	void testMultipleCommandsExecution() throws JSchException, IOException {
		Executer.onWorkerMultipleCommands("test.rebex.net", "demo", "password", commands);
	}

	@Test
	void testSingleCommandExecution() throws JSchException, IOException {
		Executer.onWorkerSingleCommand("test.rebex.net", "demo", "password", "ls -alrt");
	}

	@Test
	void testWorkerHeartBeat() throws JSchException {
		Executer.getWorkerHeartBeat("test.rebex.net", "demo", "password");
	}

}
