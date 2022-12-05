package ru.crazy.crazyHouseApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.crazy.crazyHouseApp.models.Position;
import ru.crazy.crazyHouseApp.services.PositionService;

import java.util.Optional;

@Controller
@RequestMapping("/positions")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public String getAllPositions(Model model) {
        model.addAttribute("positions", positionService.findAll());
        return "positions";
    }

    @GetMapping("/create")
    public String createPositionForm(Position position){
        return "positions-create";
    }

    @PostMapping("/create")
    public String createPosition(Position position){
        positionService.savePosition(position);
        return "redirect:/positions";
    }

    @GetMapping("/delete/{id}")
    public String deletePosition(@PathVariable(value = "id") Long id){
        positionService.deleteById(id);
        return "redirect:/positions";
    }

    @GetMapping("/update/{id}")
    public String updatePositionForm(@PathVariable("id") Long id, Model model){
        Optional<Position> position = positionService.findById(id);
        model.addAttribute("position", position);
        return "positions-update";
    }

    @PostMapping("/update")
    public String updatePosition(Position position){
        positionService.savePosition(position);
        return "redirect:/positions";
    }

}
