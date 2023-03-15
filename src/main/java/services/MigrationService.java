package services;

import org.flywaydb.core.Flyway;

public class MigrationService {
    public void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/init_db4", "postgres", "postgres").load();
        flyway.migrate();
    }
}
