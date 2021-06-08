package com.travel.agency.dto;

import com.travel.agency.dao.marker.Convertible;
import com.travel.agency.model.AccommodationType;
import com.travel.agency.model.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDto implements Convertible {
    private String name;

    private AccommodationType type;

    private Boolean hasWiFi = false;

    private Boolean hasPool = false;

    private Boolean isPetsAllowed = false;

    private Boolean canSmoke = false;

    private Integer rate;

    private Country country;
}
