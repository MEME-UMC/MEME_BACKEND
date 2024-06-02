package umc.meme.portfolio.domain.portfolio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import umc.meme.member.domain.artist.entity.Artist;
import umc.meme.portfolio.domain.favorite.entity.FavoritePortfolio;
import umc.meme.portfolio.domain.portfolio.entity.Portfolio;
import umc.meme.portfolio.global.enums.Category;
import umc.meme.portfolio.global.enums.MakeupLocation;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplePortfolioDto {
    private Long portfolioId;
    private String portfolioImg;
    private Category category;
    private String makeupName;
    private String artistName;
    private String artistEmail;
    private int price;
    private MakeupLocation makeupLocation; //샵 재직 여부
    private String averageStars; //별점

    public static SimplePortfolioDto from(FavoritePortfolio favoritePortfolio){
        Portfolio portfolio = favoritePortfolio.getPortfolio();
        Artist artist = portfolio.getArtist();

        return SimplePortfolioDto.builder()
                .portfolioId(portfolio.getPortfolioId())
                .portfolioImg(portfolio.getPortfolioImgList().get(0).getSrc())
                .category(portfolio.getCategory())
                .makeupName(portfolio.getMakeupName())
                .artistName(artist.getNickname())
                .artistEmail(artist.getEmail())
                .price(portfolio.getPrice())
                .makeupLocation(artist.getMakeupLocation())
                .averageStars(portfolio.getAverageStars())
                .build();
    }

    public static SimplePortfolioDto from(Portfolio portfolio){
        Artist artist = portfolio.getArtist();

        return SimplePortfolioDto.builder()
                .portfolioId(portfolio.getPortfolioId())
                .portfolioImg(portfolio.getPortfolioImgList().get(0).getSrc())
                .category(portfolio.getCategory())
                .makeupName(portfolio.getMakeupName())
                .artistName(artist.getNickname())
                .artistEmail(artist.getEmail())
                .price(portfolio.getPrice())
                .makeupLocation(artist.getMakeupLocation())
                .averageStars(portfolio.getAverageStars())
                .build();
    }

}
