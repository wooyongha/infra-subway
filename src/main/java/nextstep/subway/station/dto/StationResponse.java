package nextstep.subway.station.dto;

import lombok.Getter;
import nextstep.subway.station.domain.Station;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class StationResponse {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Long id;
    private String name;
    private String createdDate;
    private String modifiedDate;

    public static StationResponse of(Station station) {
        return new StationResponse(station.getId(), station.getName(), station.getCreatedDate(), station.getModifiedDate());
    }

    public StationResponse() {
    }

    public StationResponse(Long id, String name, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate.format(DATE_TIME_FORMATTER);
        this.modifiedDate = modifiedDate.format(DATE_TIME_FORMATTER);
    }
}
