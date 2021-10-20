package com.BusWorkshop.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class MaintenanceTeam {
    @Id
    private String id;
    @Indexed(unique = false)
    private String name;
    private boolean availability;
    }
