package com.autentia.lab;

import static javax.transaction.Transactional.TxType.REQUIRES_NEW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class ExampleTest extends BaseTest{
    
    @Inject
    ExampleService exampleService;
    

    @Test
    public void aunque_modifiquemos_stored_en_un_bloque_transaccional_updated_es_una_referencia_en_memoria_a_stored() {
        Store stored = Store.findById(55555);
        
        exampleService.updateCreationDate();
        
        Store updated = Store.findById(55555);

        assertEquals(stored, updated);
        assertNotNull(stored);
        assertFalse(stored.creationDate.isBefore(updated.creationDate));
    }
    
    
    
    
    @Test
    public void sin_embargo_si_no_buscamos_previamente_stored_eso_no_pasa() {
        
        Instant storedCreationDate = Instant.parse("2023-03-02T01:02:03.987654Z");
        
        exampleService.updateCreationDate();
        
        Store updated = Store.findById(55555);
       
        assertTrue(storedCreationDate.isBefore(updated.creationDate));
    }

    
    
    
    @Test
    public void eso_es_porque_al_hacer_un_find_comenzamos_un_bloque_transaccional() {
        
        Store stored = Store.findById(55555);
        
        exampleService.updateCreationDate();
        
        Store updated = findByIdNewTx();

        assertNotNull(stored);
        assertTrue(stored.creationDate.isBefore(updated.creationDate));
    }

    @Transactional(REQUIRES_NEW)
    public Store findByIdNewTx() {
        Store updated = Store.findById(55555);
        return updated;
    }
    
    
    
    
    @Test
    public void stored_viene_con_su_lista_de_servicios() {
        Store stored = Store.findById(55555);
        
        assertNotNull(stored);
        assertNotNull(stored.services);
        assertEquals(stored.services.size(),3);
    }
    
    
    
    @Test
    public void cuando_actualizamos_los_servicios_entonces_borra_los_que_sobran() {
        List<ServiceStore> services = new ArrayList<>();
        
        ServiceStore s1 = new ServiceStore();
        s1.storeCode = 55555;
        s1.serviceCode = 1;
        s1.creationDate = Instant.now();
        
        ServiceStore s2 = new ServiceStore();
        s2.storeCode = 55555;
        s2.serviceCode = 2;
        s2.creationDate = Instant.now();
        
        ServiceStore s5 = new ServiceStore();
        s5.storeCode = 55555;
        s5.serviceCode = 5;
        s5.creationDate = Instant.now();
        
        services.add(s1);
        services.add(s2);
        services.add(s5);
        
        exampleService.updateServices(55555,services);
        
        Store stored = Store.findById(55555);
        
        assertNotNull(stored);
        assertNotNull(stored.services);
        assertEquals(stored.services.size(),3);
        
        assertEquals(stored.services.get(2).serviceCode, 5);
    }
    
    
    
    
    
    

}