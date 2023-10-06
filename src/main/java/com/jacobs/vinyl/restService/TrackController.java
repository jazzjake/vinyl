package com.jacobs.vinyl.restService;

import com.jacobs.vinyl.dto.ReleaseDTO;
import com.jacobs.vinyl.dto.TrackDTO;
import com.jacobs.vinyl.model.Track;
import com.jacobs.vinyl.service.TrackService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TrackController {

    TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }
    @GetMapping(value = "/tracks")
    public List<TrackDTO> getAllTracks() {
        return trackService.getAllTracks()
                .stream()
                .map(this::toTrackDTO)
                .collect(Collectors.toList());
    }

    private TrackDTO toTrackDTO(Track track) {
        TrackDTO trackDTO = new TrackDTO();
        BeanUtils.copyProperties(track, trackDTO);
        ReleaseDTO releaseDTO = new ReleaseDTO();
        BeanUtils.copyProperties(track.getRelease(), releaseDTO);
        trackDTO.setRelease(releaseDTO);
        return trackDTO;
    }
}
