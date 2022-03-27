package com.electrolux.appliance.service;

import com.electrolux.appliance.VO.ResponseTemplateVO;
import com.electrolux.appliance.VO.User;
import com.electrolux.appliance.entity.Appliance;
import com.electrolux.appliance.repository.ApplianceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ApplianceService {

    @Autowired
    private ApplianceRepository applianceRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Appliance saveAppliance(Appliance appliance) {
        return applianceRepository.save(appliance);
    }

    public ResponseTemplateVO findApplianceOfUserById(Long userId) {
        User user =  restTemplate.getForObject("http://USER-SERVICE/users/" + userId, User.class);
        ResponseTemplateVO responseTemplateVO =  new ResponseTemplateVO(user,applianceRepository.findByUserId(user.getUserId()));

        return responseTemplateVO;
    }
}
