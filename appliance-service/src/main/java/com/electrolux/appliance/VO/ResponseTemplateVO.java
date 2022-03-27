package com.electrolux.appliance.VO;

import com.electrolux.appliance.entity.Appliance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private User user;
    private List<Appliance> appliance;
}
