package com.electrolux.appliance.service;

import com.electrolux.appliance.Enum.Status;
import com.electrolux.appliance.VO.ResponseTemplateVO;
import com.electrolux.appliance.VO.User;
import com.electrolux.appliance.entity.Appliance;
import com.electrolux.appliance.repository.ApplianceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ApplianceServiceTest {

    @Mock
    private ApplianceRepository applianceRepository;

    @Mock
    RestTemplate restTemplate;

    private Appliance appliance;
    private List<Appliance> appliances;
    private ResponseTemplateVO responseTemplateVO;

    @Mock
    private User user;

    @InjectMocks
    private ApplianceService applianceService;

    @BeforeEach
    void setUp() {
        appliance = new Appliance(102312L,"YS2R4X20005399401","ABC123",1L, Status.ACTIVE);
        appliances = Arrays.asList(appliance);
        responseTemplateVO = new ResponseTemplateVO();
        user = new User(1L,"Kalles Grustransporter","Cementvägen 8, 111 11 Södertälje");
    }

    @Test
    void saveAppliance() {
        Mockito.lenient().when(applianceRepository.save(appliance)).thenReturn(appliance);
        assertEquals(appliance,applianceService.saveAppliance(appliance));
    }

    @Test
    void findApplianceOfUserById() {
        Mockito.lenient().when(restTemplate.getForObject("http://USER-SERVICE/users/1", User.class)).thenReturn(user);
        Mockito.lenient().when(applianceRepository.findByUserId(1L)).thenReturn(appliances);

        assertNotNull(applianceService.findApplianceOfUserById(1L));

    }
}