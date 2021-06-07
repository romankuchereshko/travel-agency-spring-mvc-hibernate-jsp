package com.travel.agency.dto;

import com.travel.agency.dao.marker.Convertible;
import com.travel.agency.model.BedPreference;
import com.travel.agency.service.HotelService;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@With
public class RoomDto implements Convertible {
    private Long hotelId;

    private Long price;

    private Integer guestCount;

    private BedPreference bed;
}
