package org.icodeit.bookmarks.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class AppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        return null;
    }
}
