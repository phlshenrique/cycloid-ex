package com.cycloid.epg.model;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Program {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String channelId;

    @Getter
    @Setter
    private String imageUrl;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Instant startTime;

    @Getter
    @Setter
    private Instant endTime;

}
