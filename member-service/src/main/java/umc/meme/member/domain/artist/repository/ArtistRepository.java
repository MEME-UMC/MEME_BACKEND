package umc.meme.member.domain.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.meme.member.domain.artist.entity.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
