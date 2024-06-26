package umc.meme.reservation.domain.review.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.meme.reservation.domain.common.BaseEntity;

import umc.meme.reservation.domain.review.dto.request.UpdateReviewDto;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name="portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User model;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
    private List<ReviewImg> reviewImgList;

    @Column(nullable = false)
    private int star;

    @Column(nullable = true, length = 200)
    private String comment;

    public void updateReview(UpdateReviewDto patchReviewDto){
        if(patchReviewDto.getStar() > 0)
            this.star = patchReviewDto.getStar();
        if(patchReviewDto.getComment() != null)
            this.comment = patchReviewDto.getComment();
    }

    public void updateReviewImgList(List<ReviewImg> reviewImgList){this.reviewImgList = reviewImgList;}

    public static Review from(Model model, Portfolio portfolio, ReviewDto dto){
        return Review.builder()
                .model(model)
                .portfolio(portfolio)
                .star(dto.getStar())
                .comment(dto.getComment())
                .reviewImgList(new ArrayList<ReviewImg>())
                .build();
    }

    public void addReviewImg(ReviewImg reviewImg) {
        this.reviewImgList.add(reviewImg);
        reviewImg.setReview(this);
    }
}
