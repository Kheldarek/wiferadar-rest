package pl.put.poznan.wiferadar.location;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonSerialize
@JsonDeserialize
public class Location {
   private Coordinate latitude, longitude;
}
