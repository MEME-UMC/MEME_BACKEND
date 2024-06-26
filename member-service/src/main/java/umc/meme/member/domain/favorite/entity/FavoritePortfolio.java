package umc.meme.member.domain.favorite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.meme.member.domain.common.BaseEntity;
import umc.meme.member.domain.model.entity.Model;
import umc.meme.member.domain.portfolio.entity.Portfolio;
import umc.meme.member.domain.user.User;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FavoritePortfolio extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoritePortfolioId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User model;

    @ManyToOne
    @JoinColumn(name="portfolio_id", nullable = false)
    private Portfolio portfolio;

    public static FavoritePortfolio from(Model model, Portfolio portfolio){
        return FavoritePortfolio.builder()
                .model(model)
                .portfolio(portfolio)
                .build();
    }
}
