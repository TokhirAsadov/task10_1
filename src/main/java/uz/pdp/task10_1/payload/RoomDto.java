package uz.pdp.task10_1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.task10_1.entity.Hotel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private Long id;

    private Integer number;

    private String floor;

    private String size;

    private Hotel hotel;
}
