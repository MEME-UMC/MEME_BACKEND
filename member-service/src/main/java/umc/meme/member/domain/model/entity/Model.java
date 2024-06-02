package umc.meme.member.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import umc.meme.member.domain.favorite.entity.FavoriteArtist;
import umc.meme.member.domain.favorite.entity.FavoritePortfolio;
import umc.meme.member.domain.model.dto.request.ModelProfileDto;
import umc.meme.member.domain.reservation.entity.Reservation;
import umc.meme.member.domain.review.entity.Review;
import umc.meme.member.domain.user.User;
import umc.meme.member.global.enums.PersonalColor;
import umc.meme.member.global.enums.Provider;
import umc.meme.member.global.enums.SkinType;
import umc.meme.member.global.enums.UserStatus;

import java.util.List;

@SuperBuilder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model extends User {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkinType skinType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PersonalColor personalColor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private List<FavoritePortfolio> favoritePortfolioList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private List<FavoriteArtist> favoriteArtistList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private List<Reservation> reservationList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "model")
    private List<Review> reviewList;

    public void updateModel(ModelProfileDto request) {
        if(request.getProfileImg() != null){
            this.profileImg = request.getProfileImg();
        }
        if(request.getNickname() != null){
            this.nickname = request.getNickname();
        }
        if(request.getGender() != null){
            this.gender = request.getGender();
        }
        if(request.getSkinType() != null){
            this.skinType = request.getSkinType();
        }
        if(request.getPersonalColor() != null){
            this.personalColor = request.getPersonalColor();
        }
    }

    public void updateFavoriteArtistList(FavoriteArtist artist){
        this.favoriteArtistList.add(artist);
    }

    public void updateFavoritePortfolioList(FavoritePortfolio portfolio){
        this.favoritePortfolioList.add(portfolio);
    }
    public void updateReservationList(Reservation reservation){
        this.reservationList.add(reservation);
    }

    public void updateReviewList(Review review){
        this.reviewList.add(review);
    }


    //temp create model builder
    public static Model from(ModelProfileDto dto){
        return Model.builder()
                .profileImg(dto.getProfileImg())
                .nickname(dto.getNickname())
                .gender(dto.getGender())
                .skinType(dto.getSkinType())
                .personalColor(dto.getPersonalColor())
                .build();
    }

    public void tempMethod(){
        this.username = "name";
        this.email="";
        this.password="";
        this.role="MODEL";
        this.userStatus = UserStatus.ACTIVE;
        this.provider = Provider.KAKAO;
    }
}