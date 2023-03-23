package com.autentia.lab;

import java.time.Instant;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ExampleService {

    @Transactional
    public void updateCreationDate() {
        int storeCode = 55555;
        
        Store stored = Store.findById(storeCode);
        stored.creationDate = Instant.now();
    }
    
    @Transactional
    public void updateServices(int storeCode, List<ServiceStore> services) {
        Store store = new Store();
        store.storeCode = storeCode;
        store.creationDate = Instant.now();
        store.services = services;
        
        Store.getEntityManager().merge(store);
    }
    
}