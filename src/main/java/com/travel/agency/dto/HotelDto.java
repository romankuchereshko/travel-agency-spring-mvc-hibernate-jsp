package com.travel.agency.dto;

import com.travel.agency.dao.marker.Convertible;
import com.travel.agency.model.AccommodationType;
import com.travel.agency.model.Country;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
//@Getter
@Data
public class HotelDto implements Convertible {
//    private Long id;

    private String name;

    private AccommodationType type;

    private Boolean hasWiFi = false;

    private Boolean hasPool = false;

    private Boolean isPetsAllowed = false;

    private Boolean canSmoke = false;

    private Integer rate;

    private Country country;
}
