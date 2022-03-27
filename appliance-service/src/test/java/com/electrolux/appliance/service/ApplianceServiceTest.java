package com.electrolux.appliance.service;

import com.electrolux.appliance.Enum.Status;
import com.electrolux.appliance.entity.Appliance;
import com.electrolux.appliance.repository.ApplianceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import javax.validation.constraints.Null;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ApplianceServiceTest {

    @Mock
    private ApplianceRepository applianceRepository;

    @Mock
    private Appliance appliance;

    @Mock
    private ApplianceService applianceService;

    @BeforeEach
    void setUp() {
        appliance = new Appliance(Long.valueOf(102312),"YS2R4X20005399401","ABC123",Long.valueOf(1), Status.ACTIVE.toString());
    }

    @Test
    void saveAppliance() {
        Mockito.lenient().when(applianceRepository.save(appliance)).thenReturn(appliance);
        System.out.print(appliance);
        appliance = applianceService.saveAppliance(appliance);
        assertEquals(Appliance.class,appliance);

    }

    @Test
    void findApplianceOfUserById() {
    }
}