package com.travel.agency.model;

import com.travel.agency.dao.marker.Convertible;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@ToString
public class Hotel implements Convertible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column
    private Long id;

    @Column(name = "hotel_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private AccommodationType type;

    @Column(name = "rate")
    @Min(value = 1)
    @Max(value = 5)
    private Integer rate;

    @Column(name = "wifi")
    private Boolean hasWiFi;

    @Column(name = "pool")
    private Boolean hasPool;

    @Column(name = "pets")
    private Boolean isPetsAllowed;

    @Column(name = "smoking")
    private Boolean canSmoke;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Room> rooms;

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
//    private List<Booking> bookings;

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
//    private List<Room> rooms;
}
