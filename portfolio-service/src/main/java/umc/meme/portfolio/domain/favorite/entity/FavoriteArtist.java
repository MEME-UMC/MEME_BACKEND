package umc.meme.portfolio.domain.favorite.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import umc.meme.portfolio.domain.common.BaseEntity;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FavoriteArtist extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteArtistId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Model model;

    private Long artistId;

    public static FavoriteArtist from(Artist artist, Model model){
        return FavoriteArtist.builder()
                .model(model)
                .artistId(artist.getUserId())
                .build();
    }
}
