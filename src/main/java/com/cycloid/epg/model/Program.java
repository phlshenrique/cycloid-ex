package com.cycloid.epg.model;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;

public class Program {

    @Getter
    @Setter
    private String id;

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
