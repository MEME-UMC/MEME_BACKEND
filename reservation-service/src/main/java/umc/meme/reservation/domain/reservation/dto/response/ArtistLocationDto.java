package umc.meme.reservation.domain.reservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import global.enums.MakeupLocation;
import global.enums.Region;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtistLocationDto {
    private MakeupLocation makeupLocation; //샵 재직 여부
    private String reservationLocation; //샵 위치
    private List<Region> region; //활동 가능 지역

    public static ArtistLocationDto from(Artist artist){
        return ArtistLocationDto.builder()
                .makeupLocation(artist.getMakeupLocation())
                .reservationLocation(artist.getShopLocation())
                .region(artist.getRegion())
                .build();
    }
}
