package com.cycloid.epg.controller;

import com.cycloid.epg.model.Channel;
import com.cycloid.epg.repository.ChannelRepository;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channels")
public class ChannelController {

    private final ChannelRepository channelRepository;

    public ChannelController(ChannelRepository channelRepository){
        this.channelRepository = channelRepository;
    }

    @PostMapping
    Channel newChannel(@RequestBody Channel channel){
        return channelRepository.save(channel);
    }

    @GetMapping
    List<Channel> getAll(){
        return channelRepository.findAll();
    }

}
