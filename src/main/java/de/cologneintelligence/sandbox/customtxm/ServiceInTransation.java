package de.cologneintelligence.sandbox.customtxm;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by kmussawisade on 06.11.15.
 */
@Component
public class ServiceInTransation {
    private static final Logger LOG = getLogger(ServiceInTransation.class);

    @SimpleTransaction
    public void service() {
        LOG.info("do service");
    }

}
