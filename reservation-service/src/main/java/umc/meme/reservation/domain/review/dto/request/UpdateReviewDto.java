package umc.meme.reservation.domain.review.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateReviewDto {
    @NotBlank(message = "modelId를 입력해주세요")
    private Long modelId;
    @NotBlank(message = "reviewId를 입력해주세요")
    private Long reviewId;
    private int star;
    private String comment;
    private List<String> reviewImgSrcList;
}
