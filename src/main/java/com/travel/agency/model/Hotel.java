package com.travel.agency.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@ToString
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_name", nullable = false, unique = true)
    private String name;

    @Column(name = "country", nullable = false)
    @Enumerated(EnumType.STRING)
    private Country country;

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
//    private List<Booking> bookings;
//
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
//    private List<Room> rooms;
}
