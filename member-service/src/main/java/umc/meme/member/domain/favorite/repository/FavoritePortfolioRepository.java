package umc.meme.member.domain.favorite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.meme.member.domain.favorite.entity.FavoritePortfolio;
import umc.meme.member.domain.model.entity.Model;
import umc.meme.member.domain.portfolio.entity.Portfolio;

import java.util.List;
import java.util.Optional;

public interface FavoritePortfolioRepository extends JpaRepository<FavoritePortfolio, Long> {
    List<FavoritePortfolio> findByModel(Model model);
    boolean existsByModelAndPortfolio(Model model, Portfolio portfolio);
    Optional<FavoritePortfolio> findByModelAndPortfolio(Model model, Portfolio portfolio);
}
