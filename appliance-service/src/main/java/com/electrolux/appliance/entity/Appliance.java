package com.electrolux.appliance.entity;

import com.electrolux.appliance.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appliance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applianceId;

    @NotNull(message = "ApplianceNumber can not null")
    private String applianceNumber;
    private String factoryNumber;

    @NotNull(message = "UserId can not be null")
    private Long userId;

    private Status status;
}
