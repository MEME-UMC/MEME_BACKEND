package umc.meme.member.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.meme.member.domain.model.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
