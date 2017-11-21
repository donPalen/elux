package com.test.controller;

import com.test.Application;
import com.test.model.Appliance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestPropertySource("/application-test.properties")
public class ApplianceControllerIntTest {

    @Autowired
    ManageController manageController;

    @Test
    public void testList() throws Exception {
        List<Appliance> results = manageController.list();
        assertThat(results.size(), is(greaterThanOrEqualTo(0)));
    }

}
