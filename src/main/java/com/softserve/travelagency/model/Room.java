package com.softserve.travelagency.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "room")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "room_types")
    private String roomsType;

    @NotNull
    @Column(name = "catering_service")
    private boolean cateringService;

    @NotNull
    @Column(name = "price")
    private Integer price;
//
//    @NotNull
//    @Column(name = "active")
//    private boolean booked;
//
//    @Column(name = "enter_time")
//    private String enterDateTime;
//
//    @Column(name = "departure_time")
//    private String departureDateTime;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private List<Booking> bookings;
}
