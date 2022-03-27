package com.electrolux.appliance.schedular;

import com.electrolux.appliance.Enum.Status;
import com.electrolux.appliance.entity.Appliance;
import com.electrolux.appliance.repository.ApplianceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Component
@Slf4j
public class ApplianceStatus {

    @Autowired
    ApplianceRepository applianceRepository;

    @Scheduled(cron = "0 0/1 * * * ?") // midnight 0 0 * * * * Live(everyFiveMintues) */300 * * * * * Running */15 * * * * *
    public void cronJobUpdateStatus() {
        log.info("Updating Appliance Status at:" + LocalDateTime.now());
        log.info("ApplianceStatus:" + getApplianceStatus());

        List<Appliance> appliances = applianceRepository.findAll();
        appliances.forEach(a -> a.setStatus(getApplianceStatus()));

        applianceRepository.saveAll(appliances);
    }

    private Status getApplianceStatus(){
        return Status.values()[new Random().nextInt(Status.values().length)];
    }

}
