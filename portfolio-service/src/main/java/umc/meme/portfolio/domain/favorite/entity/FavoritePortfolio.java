package umc.meme.portfolio.domain.favorite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.meme.portfolio.domain.common.BaseEntity;

import umc.meme.portfolio.domain.portfolio.entity.Portfolio;


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
