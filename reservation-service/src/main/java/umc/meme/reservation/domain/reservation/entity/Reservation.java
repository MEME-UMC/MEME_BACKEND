package umc.meme.reservation.domain.reservation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.meme.reservation.domain.common.BaseEntity;

import global.enums.Status;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User model;

    @ManyToOne
    @JoinColumn(name="portfolio_id", nullable = false)
    private Portfolio portfolio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "available_time_id")
    private AvailableTime availableTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private boolean isReview = false;

    @Column(nullable = false)
    private String location; //예약 장소

    public void updateReservation(Status status){
        if(status != null)
            this.status = status;
    }

    public void updateIsReview(boolean bool){
        this.isReview = bool;
    }

    public boolean isAvailableReview(){
        return !status.equals(Status.COMPLETE);
    }

    public static Reservation from(Model model, Portfolio portfolio, AvailableTime availableTime, String location){
        return Reservation.builder()
                .model(model)
                .portfolio(portfolio)
                .availableTime(availableTime)
                .status(Status.EXPECTED)
                .location(location)
                .build();
    }
}
