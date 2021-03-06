package com.udacity.datatest.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.udacity.datatest.data.Plant;
import com.udacity.datatest.data.PlantDTO;
import com.udacity.datatest.service.PlantService;
import com.udacity.datatest.view.Views;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plant")
public class PlantController {
    @Autowired
    private PlantService plantService;

    public PlantDTO getPlantDTO(String name) {
        return convertPlantToPlantDTO(plantService.getPlantByName(name));
    }

    @JsonView(Views.Public.class)
    public Plant getFilteredPlant(String name) {
        return plantService.getPlantByName(name);
    }

    private PlantDTO convertPlantToPlantDTO(Plant plant) {
        PlantDTO plantDTO = new PlantDTO();
        BeanUtils.copyProperties(plant, plantDTO);
        return plantDTO;
    }
}
