package com.test.controller;

import com.test.model.Appliance;
import com.test.model.ResourceNotFoundException;
import com.test.model.Status;
import com.test.repository.ApplianceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by prokale on 2017-11-21.
 */
@RestController
@RequestMapping("api/v1/")
public class ManageController {
    private static final Logger LOGGER = Logger.getLogger(ManageController.class.getName());

    @Autowired
    private ApplianceRepository applianceRepository;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public List<Appliance> list() {
        return applianceRepository.findAll();
    }

    /**
     * Create appliance.
     *
     * @param appliance the appliance without id. If id is present in request, it will be ignored
     * @return the appliance with auto-geterated id
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Appliance create(@RequestBody Appliance appliance) {
        return applianceRepository.saveAndFlush(appliance);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Appliance get(@PathVariable Long id) {
        Appliance found = applianceRepository.findOne(id);
        if (found == null) {
            throw new ResourceNotFoundException();
        } else {
            return found;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public Appliance update(@PathVariable Long id, @RequestBody Appliance appliance) {
        Appliance existing = applianceRepository.findOne(id);
        BeanUtils.copyProperties(appliance, existing);
        return applianceRepository.saveAndFlush(existing);
    }

    @RequestMapping(value = "updateStatus/{id}", method = RequestMethod.PUT)
    public Appliance update(@PathVariable Long id, @RequestBody Status status) {
        Appliance existing = applianceRepository.findOne(id);
        existing.setStatus(status);//maybe add some logic for transition of states
        return applianceRepository.saveAndFlush(existing);
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> responce = new HashMap<>();
        responce.put("id", id);
        try {
            applianceRepository.delete(id);
            responce.put("status", "deleted");
            return responce;
        } catch (EmptyResultDataAccessException e) {
            responce.put("status", "id not found! Record not deleted.");
        } catch (Exception e) {//other errors
            responce.put("status", "error while deleting:" + e.getMessage());
            LOGGER.log(Level.WARNING, "error while deleting", e);
        }
        return responce;

    }
}
