package com.GameShop.GameShop.controller.game;

import com.GameShop.GameShop.domain.game.Description;
import com.GameShop.GameShop.service.game.DescriptionService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/description")
public class DescriptionController {
    @Autowired
    private DescriptionService descriptionService;


    private Logger log = LoggerFactory.getLogger(DescriptionController.class);

    @GetMapping
    public List<Description> findAll(){
        log.info("Find all: ");
        return descriptionService.getAll();
    }

    @GetMapping("/{id}")
    public Description findById(@PathVariable Long id){
        log.info("Find by:", descriptionService.getById(id));
        return descriptionService.getById(id);
    }

    @PostMapping
    public void save(@RequestBody Description description)throws BadRequestException {
        try {
            descriptionService.save(description);
            log.info("Save description: ", descriptionService.getById(description.getId()));
        }catch (BadRequestException e){
            log.error("Bad request");
        }
    }

    @PutMapping("/{}id")
    public void update(@PathVariable Long id, @RequestBody Description description){
        descriptionService.update(id,description);
        log.info("Update description: ", descriptionService.getById(description.getId()));
    }

    @DeleteMapping
    public void delete(@RequestBody Description description){
        log.info("Delete description: ");
    }

}
