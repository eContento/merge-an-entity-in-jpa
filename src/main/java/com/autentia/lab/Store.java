package com.autentia.lab;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


@Entity
@Table(name = "store")
public class Store extends PanacheEntityBase {

    @Id
    @Column(name = "store_code")
    public Integer storeCode;

    @Column(name = "creation_date")
    public Instant creationDate;
    
    @OneToMany(
            mappedBy = "storeCode", 
            fetch = FetchType.EAGER, 
            cascade = CascadeType.ALL, 
            orphanRemoval = true)
    public List<ServiceStore> services;

}

