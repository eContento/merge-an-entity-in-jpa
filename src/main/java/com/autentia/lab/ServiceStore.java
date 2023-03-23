package com.autentia.lab;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;


@Entity
@Table(name = "services_by_store")
@IdClass(value = ServiceStore.IdClass.class)
public class ServiceStore extends PanacheEntityBase {

    @Id
    @Column(name = "store_code")
    public Integer storeCode;
    
    @Id
    @Column(name = "service_code")
    public Integer serviceCode;
    
    @Column(name = "creation_date")
    public Instant creationDate;

    
    @RegisterForReflection
    public static class IdClass implements Serializable {
        private static final long serialVersionUID = 2L;

        public Integer storeCode;
        public Integer serviceCode;

        public IdClass() {
            super();
        }

        public IdClass(Integer storeCode, Integer serviceCode) {
            super();
            this.storeCode = storeCode;
            this.serviceCode = serviceCode;
        }
    }
    
}

