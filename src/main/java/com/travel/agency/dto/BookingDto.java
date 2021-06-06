package com.travel.agency.dto;

import com.travel.agency.dao.marker.Convertible;
import com.travel.agency.model.Room;
import com.travel.agency.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDto implements Convertible {
    private Room room;

    private LocalDate checkIn;

    private LocalDate checkOut;

    private Status status;
}
