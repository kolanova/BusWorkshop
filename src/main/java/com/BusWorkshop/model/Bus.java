package com.BusWorkshop.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Bus {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private LocalDateTime maintenanceDay;
    private BusType busType;
}
