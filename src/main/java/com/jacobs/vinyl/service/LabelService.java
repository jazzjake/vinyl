package com.jacobs.vinyl.service;

import com.jacobs.vinyl.model.Label;
import com.jacobs.vinyl.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class LabelService {

    private final LabelRepository labelRepository;

    @Autowired
    public LabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public Label createLabel(String labelName) {
        return labelRepository.save(new Label(labelName));
    }
    public List<Label> getAllLabels() {
        return StreamSupport.stream(labelRepository.findAll().spliterator(), false).toList();
    }
}
