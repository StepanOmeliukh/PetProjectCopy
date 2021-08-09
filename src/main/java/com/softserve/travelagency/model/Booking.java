package com.softserve.travelagency.model;

import lombok.*;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "booking")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "date_of_registration")
    private Timestamp dateOfRegistration;

    @NotNull
    @Column(name = "date_of_entrance")
    private Timestamp dateOfEntrance;

    @NotNull
    @Column(name = "date_of_departure")
    private Timestamp dateOfDeparture;

    @NotNull
    @Column(name = "booking_closed")
    private boolean bookingClosed;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable (
            name = "booking_has_hotel",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "hotel_id")
    )
    private List<Hotel> hotels;
}
