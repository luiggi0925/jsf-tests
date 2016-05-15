package edu.ltmj.webrunner;

import java.io.File;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TomcatRunner {

	static final Logger logger = LoggerFactory.getLogger(TomcatRunner.class);

	public static void main(String[] args) {
		try {
			String webappDirLocation = "src/main/webapp/";
			Tomcat tomcat = new Tomcat();
			tomcat.setPort(8080);
			File webAppDir = new File(webappDirLocation);
			tomcat.addWebapp("/jsf-tests", webAppDir.getAbsolutePath());
			logger.info("configuring app with basedir: " + webAppDir.getAbsolutePath());

			tomcat.start();
			tomcat.getServer().await();
		} catch (Exception e) {
			logger.error("Error starting tomcat.", e);
		}
	}
}
