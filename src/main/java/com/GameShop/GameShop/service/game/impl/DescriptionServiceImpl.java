package com.GameShop.GameShop.service.game.impl;

import com.GameShop.GameShop.domain.game.Description;
import com.GameShop.GameShop.repository.game.DescriptionRepository;
import com.GameShop.GameShop.service.game.DescriptionService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionServiceImpl implements DescriptionService {
    private Logger log = LoggerFactory.getLogger(DescriptionServiceImpl.class);

    @Autowired
    private DescriptionRepository descriptionRepository;

    @Override
    public List<Description> getAll() {
        log.info("Find all: {}",descriptionRepository.findAll());
        return descriptionRepository.findAll();
    }

    @Override
    public void save(Description description) throws BadRequestException {
        descriptionRepository.save(description);
        log.info("Save description: {}",descriptionRepository.findById(description.getId()));
    }

    @Override
    public void update(Long id, Description description) {
        if(!descriptionRepository.findById(id).isEmpty()){
            Description updateDescription = descriptionRepository.findById(id).orElse(null);

            updateDescription.setDescription(description.getDescription());

            descriptionRepository.save(description);
            log.info("Update description: {}",descriptionRepository.findById(description.getId()));
        }
    }

    @Override
    public void delete(Description description) {
        log.info("Delete description: {}",descriptionRepository.findById(description.getId()));
        descriptionRepository.delete(description);
    }

    @Override
    public Description getById(Long id) {
        log.info("Find description: {}",descriptionRepository.findById(id));
        return descriptionRepository.findById(id).orElse(null);
    }
}
