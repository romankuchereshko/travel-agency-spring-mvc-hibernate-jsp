package com.travel.agency.model;

import com.travel.agency.dao.marker.Convertible;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@ToString
public class Booking implements Convertible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
    private Long id;

    @Column(name = "checkin")
    private LocalDate checkIn;

    @Column(name = "checkout")
    private LocalDate checkOut;

    @Column (name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "hotel_id")
//    private Hotel hotel;
}
