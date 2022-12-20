package com.cycloid.epg.controller;

import com.cycloid.epg.model.Channel;
import com.cycloid.epg.model.Program;
import com.cycloid.epg.repository.ChannelRepository;
import com.cycloid.epg.repository.ProgramRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/programs")
public class ProgramController {

    private final ProgramRepository programRepository;
    private final ChannelRepository channelRepository;

    public ProgramController(ProgramRepository programRepository, ChannelRepository channelRepository) {
        this.programRepository = programRepository;
        this.channelRepository = channelRepository;
    }

    @PostMapping
    public ResponseEntity<Program> newProgram(@RequestBody Program program){
        Channel channel = channelRepository.findById(Long.parseLong(program.getChannelId())).orElse(null);
        if(channel == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(programRepository.save(program),HttpStatus.OK) ;
    }

    @GetMapping
    public Program findById(@RequestParam Long id){
        return programRepository.findById(id).get();
    }

    @GetMapping("/channel")
    public List<Program> findByChannelId(@RequestParam String id){
        return programRepository.findByChannelId(id);
    }

    @DeleteMapping
    void deleteProgram(@PathVariable Long id){
        Program program = programRepository.findById(id).get();
        programRepository.delete(program);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateResource(@RequestBody Program program, @PathVariable("id") Long id){
        Program programDB = programRepository.findById(id).orElse(null);
        if(programDB != null){
            programDB = program;
            programDB.setId(id);
            return new ResponseEntity<>(programRepository.save(program), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
