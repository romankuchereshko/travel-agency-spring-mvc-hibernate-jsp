package com.travel.agency.model;

import com.travel.agency.dao.marker.Convertible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@ToString
public class Room implements Convertible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
    private Long id;

    @Column(name = "room_price")
    private Long price;

    @Column(name = "guests_count")
    private Integer guestsCount;

    @Enumerated(EnumType.STRING)
    @Column(name = "bed_preference")
    private BedPreference bed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room", fetch = FetchType.EAGER)
    private List<Booking> bookings;
}
