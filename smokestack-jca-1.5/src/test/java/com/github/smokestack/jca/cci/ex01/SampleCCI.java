package com.github.smokestack.jca.cci.ex01;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.resource.ResourceException;
import javax.resource.cci.*;


public class SampleCCI {

	protected ConnectionFactory connectionFactory = null;

	public SampleCCI() throws NamingException {
		// Locate the application component and perform a JNDI lookup
		InitialContext ctx = new InitialContext();
		connectionFactory = (ConnectionFactory) ctx.lookup("java:comp/env/eis/myConnection");
	}

	public Record execute(Record inRec) throws ResourceException {
		Record outRec = null;
		Connection connection = null;
		Interaction interaction = null;
		try {

			// create a connection
			connection = connectionFactory.getConnection();

			// Create Interaction and an InteractionSpec
			interaction = connection.createInteraction();
			SampleInteractionSpec interactionSpec = new SampleInteractionSpec();
			interactionSpec.setFunctionName("GET");

			// Execute an interaction
			outRec = interaction.execute(interactionSpec, inRec);

		} finally {
			if (interaction != null) {
				try {
					interaction.close();
				} catch (Exception e) {/* ignore the exception */
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {/* ignore the exception */
				}
			}
		}
		return outRec;
	}
}
