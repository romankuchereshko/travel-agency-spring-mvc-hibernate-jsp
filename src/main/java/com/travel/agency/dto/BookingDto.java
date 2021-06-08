package com.travel.agency.dto;

import com.travel.agency.dao.marker.Convertible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto implements Convertible {
    private Long roomId;

    private LocalDate checkIn;

    private LocalDate checkOut;
}
