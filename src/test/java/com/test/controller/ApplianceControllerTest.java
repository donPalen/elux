package com.test.controller;

import com.test.model.Appliance;
import com.test.repository.ApplianceRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplianceControllerTest {

    // Mockito is now managing the fixture (no need to explicitly instntiate it in test)
    @InjectMocks
    private ManageController fixture;

    // Mockito framework is now also managing the repository dependency that fixture has
    @Mock
    private ApplianceRepository mockApplianceRepository;

    @Before
    public void setup() throws Exception {
        // Initialize all mock objects when test runs.
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGet() throws Exception {
        Long id = 123L;
        Appliance appliance = new Appliance();
        appliance.setId(id)
                .setName("foo")
                .setDescription("foo test");
        when(mockApplianceRepository.findOne(id)).thenReturn(appliance);

        Appliance result = fixture.get(id);

        // hamcrest assertion
        assertThat(result.getId(), is(123L));

        verify(mockApplianceRepository).findOne(id);
    }

}