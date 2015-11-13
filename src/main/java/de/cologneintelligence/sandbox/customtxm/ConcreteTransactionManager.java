package de.cologneintelligence.sandbox.customtxm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kmussawisade on 06.11.15.
 */
public class ConcreteTransactionManager implements TransactionManager {
    private static final Logger LOG = LoggerFactory.getLogger(ConcreteTransactionManager.class);

    public void beginTransaction() {
        LOG.info("beginTransaction");
    }

    public void endTransaction() {
        LOG.info("endTransaction");
    }
}
