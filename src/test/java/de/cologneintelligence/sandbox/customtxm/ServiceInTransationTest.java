package de.cologneintelligence.sandbox.customtxm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;

/**
 * Created by kmussawisade on 06.11.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Config.class})
public class ServiceInTransationTest {

    @Mock
    private TransactionManager transactionManager;

    @Autowired
    private ServiceInTransation serviceInTransation;

    @Autowired
    @InjectMocks
    private TransactionAspect transactionAspect;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testService() throws Exception {
        assertThat(transactionAspect,notNullValue());
        serviceInTransation.service();
        verify(transactionManager).beginTransaction();
        verify(transactionManager).endTransaction();
    }
}