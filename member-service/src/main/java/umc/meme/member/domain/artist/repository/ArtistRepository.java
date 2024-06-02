package umc.meme.member.domain.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.meme.member.domain.artist.entity.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
