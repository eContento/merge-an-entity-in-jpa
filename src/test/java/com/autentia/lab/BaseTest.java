package com.autentia.lab;

import javax.inject.Inject;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract class BaseTest {
    
    @Inject
    Flyway flyway;

    @BeforeEach
    void migrate() {
        flyway.migrate();
    }

    @AfterEach
    void clean() {
        flyway.clean();
    }

}
