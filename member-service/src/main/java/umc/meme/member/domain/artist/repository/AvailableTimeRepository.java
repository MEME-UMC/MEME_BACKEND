package umc.meme.member.domain.artist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.meme.member.domain.artist.entity.AvailableTime;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {
}
