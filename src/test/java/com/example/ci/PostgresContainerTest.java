package com.example.ci;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Demonstrates a real PostgreSQL container during tests.
 * Requires Docker Desktop (or another working Docker-compatible runtime).
 */
@Testcontainers(disabledWithoutDocker = true)
class PostgresContainerTest {
    @Container
    static final PostgreSQLContainer<?> postgres =
        new PostgreSQLContainer<>("postgres:16-alpine")
            .withDatabaseName("ci_demo")
            .withUsername("ci_user")
            .withPassword("ci_password");

    @Test
    void postgresContainerStarts() {
        assertTrue(postgres.isRunning());
        assertTrue(postgres.getJdbcUrl().startsWith("jdbc:postgresql:"));
    }
}
