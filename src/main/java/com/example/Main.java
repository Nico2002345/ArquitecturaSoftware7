package com.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * This class launches the web application in an embedded Jetty container. This
 * is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 *
 */
public class Main {

    /**
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String webappDirLocation = "src/main/webapp/";
        String webport = System.getenv("PORT");

        if (webport == null || webport.isEmpty()) {
            webport = "8081";
        }

        Server server = new Server(Integer.valueOf(webport));
        WebAppContext root = new WebAppContext();
        PersistenceManager.getInstance().getEntityManagerFactory();
        root.setContextPath("/");
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
        root.setParentLoaderPriority(true);
        server.setHandler(root);
        server.start();
        server.join();
        server.stop();
    }

}