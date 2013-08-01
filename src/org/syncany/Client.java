package org.syncany;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.syncany.config.Config;
import org.syncany.operations.SyncDownOperation;
import org.syncany.operations.SyncUpOperation;

public class Client {
	protected static final Logger logger = Logger.getLogger(Client.class.getSimpleName());	
	protected Config config;
	
	public Client() {
		// Fressen
	}
	
	public void setConfig(Config config) {
		this.config = config;
	}
	
	public Config getConfig() {
		return config;
	}

	public void createDirectories() throws Exception {   
		logger.log(Level.INFO, "Creating profile directories ...");
		
		config.getAppDir().mkdirs();
		config.getAppCacheDir().mkdirs();
		config.getAppDatabaseDir().mkdirs();
	}		
	
	public void up() throws Exception {
		logger.log(Level.INFO, "Running UP operation...");
		new SyncUpOperation(config).execute();
	}
	
	public void down() throws Exception {
		logger.log(Level.INFO, "Running DOWN operation...");
		new SyncDownOperation(config).execute();
	}
}
