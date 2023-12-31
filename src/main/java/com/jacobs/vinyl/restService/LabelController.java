package com.jacobs.vinyl.restService;

import com.jacobs.vinyl.dto.LabelDTO;
import com.jacobs.vinyl.dto.ReleaseDTO;
import com.jacobs.vinyl.model.Label;
import com.jacobs.vinyl.model.Release;
import com.jacobs.vinyl.service.LabelService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LabelController {

    private LabelService labelService;

    @Autowired
    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @PostMapping(value = "/label")
    public LabelDTO createLabel(@Valid @RequestBody LabelDTO newLabel) {
        Label label =labelService.createLabel(newLabel.getLabelName());
        return toLabelDTO(label);
    }

    @GetMapping(value = "/labels")
    public List<LabelDTO> getAllLables() {
        return labelService.getAllLabels()
                .stream()
                .map(this::toLabelDTO)
                .collect(Collectors.toList());
    }

    private LabelDTO toLabelDTO(Label label) {
        LabelDTO labelDTO = new LabelDTO();
        BeanUtils.copyProperties(label, labelDTO);
        for(Release release : label.getReleases()) {
            ReleaseDTO releaseDTO = new ReleaseDTO();
            BeanUtils.copyProperties(release, releaseDTO );
            labelDTO.getReleases().add(releaseDTO);
        }
        return labelDTO;
    }
}
