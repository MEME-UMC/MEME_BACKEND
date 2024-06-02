package umc.meme.member.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.meme.member.domain.model.entity.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
}
