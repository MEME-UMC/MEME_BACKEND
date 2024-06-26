package umc.meme.portfolio.domain.portfolio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import umc.meme.portfolio.domain.favorite.entity.FavoritePortfolio;
import umc.meme.portfolio.domain.portfolio.entity.Portfolio;
import global.enums.Category;
import global.enums.MakeupLocation;
import global.enums.Region;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioDto {
    private Long portfolioId;

    private Category category;

    private String artistNickName;
    private Long userId;

    private String makeupName;

    private int price;

    private MakeupLocation makeupLocation; //샵 재직 여부

    private String shopLocation; //샵 위치

    private List<Region> region; //활동 가능 지역

    private Boolean isBlock;

    private String averageStars;

    private int reviewCount; //리뷰 개수

    private List<PortfolioImgDto> portfolioImgDtoList;


    public static PortfolioDto from(Portfolio portfolio) {
        Artist artist = portfolio.getArtist();

        // PortfolioImg 리스트를 PortfolioImgDto 리스트로 변환
        List<PortfolioImgDto> portfolioImgDtoList = portfolio.getPortfolioImgList()
                .stream()
                .map(PortfolioImgDto::from)
                .toList();

        return PortfolioDto.builder()
                .portfolioId(portfolio.getPortfolioId())
                .userId(portfolio.getArtist().getUserId())
                .category(portfolio.getCategory())
                .artistNickName(artist.getNickname())
                .makeupName(portfolio.getMakeupName())
                .price(portfolio.getPrice())
                .makeupLocation(artist.getMakeupLocation())
                .shopLocation(artist.getShopLocation())
                .region(artist.getRegion())
                .isBlock(portfolio.isBlock())
                .portfolioImgDtoList(portfolioImgDtoList)
                .averageStars(portfolio.getAverageStars())
                .reviewCount(portfolio.getReviewList().size())
                .build();
    }

    //관심 메이크업
    public static PortfolioDto from(FavoritePortfolio favoritePortfolio){
        Portfolio portfolio = favoritePortfolio.getPortfolio();
        return PortfolioDto.builder()
                .portfolioId(portfolio.getPortfolioId())
                .category(portfolio.getCategory())
                .makeupName(portfolio.getMakeupName())
                .price(portfolio.getPrice())
                .isBlock(portfolio.isBlock())
                .averageStars(portfolio.getAverageStars())
                .reviewCount(portfolio.getReviewList().size())
                .build();
    }

}
