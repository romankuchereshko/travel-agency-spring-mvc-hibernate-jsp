package com.travel.agency.dto;

import com.travel.agency.dao.marker.Convertible;
import com.travel.agency.model.BedPreference;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@With
public class RoomDto implements Convertible {
    private Long hotelId;

    private Long price;

    private Integer guestsCount;

    private BedPreference bed;
}
