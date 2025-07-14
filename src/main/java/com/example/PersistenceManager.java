/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Asus
 */
public class PersistenceManager {

    public static final boolean DEBUG = true;

    private static final PersistenceManager SINGLETON = new PersistenceManager();

    protected EntityManagerFactory emf;

    private PersistenceManager() {
    }

    public static PersistenceManager getInstance() {
        return SINGLETON;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            createEntityManagerFactory();
        }
        return emf;
    }

    public void createEntityManagerFactory() {
        this.emf = Persistence.createEntityManagerFactory("competitorPU", System.getProperties());
        if (DEBUG) {
            System.out.println("Persistencia inicializada en: " + new java.util.Date());
        }
    }

    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
        if (DEBUG) {
            System.out.println("Persistencia finailzada en: " + new java.util.Date());
        }
    }
}
