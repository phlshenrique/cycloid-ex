package com.cycloid.epg.repository;

import com.cycloid.epg.model.Program;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {

    List<Program> findByChannelId(String channelId);
}
