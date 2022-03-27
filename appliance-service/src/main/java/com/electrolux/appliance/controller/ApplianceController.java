package com.electrolux.appliance.controller;

import com.electrolux.appliance.VO.ResponseTemplateVO;
import com.electrolux.appliance.entity.Appliance;
import com.electrolux.appliance.service.ApplianceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appliances")
@Slf4j
public class ApplianceController {

    @Autowired
    private ApplianceService applianceService;

    @PostMapping("/save")
    public Appliance saveAppliance(@RequestBody Appliance appliance) {
        log.info("saveAppliance: ApplianceController");
        return  applianceService.saveAppliance(appliance);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO findApplianceOfUserById(@PathVariable("id") Long userId) {
        log.info("findApplianceOfUserById: ApplianceController");
        return applianceService.findApplianceOfUserById(userId);
    }
}
