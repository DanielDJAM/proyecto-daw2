package com.danieldjam.ecomer.models.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class OrderDTO {

    private Integer orderId;
    private Integer userId;
    private Date arrivalDate;
    private Date departureDate;
    private Date estimatedDate;
    private String finalLocation;
    private String initialLocation;
    private String statusOrder;

}
