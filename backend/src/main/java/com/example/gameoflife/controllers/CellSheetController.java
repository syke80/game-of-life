package com.example.gameoflife.controllers;

import com.example.gameoflife.models.Cell;
import com.example.gameoflife.models.CellSheet;
import com.example.gameoflife.services.GenerationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/cellsheet")
public class CellSheetController {
  @Autowired
  GenerationService generationService;

  @RequestMapping("/nextgeneration")
  public Set<Cell> getNextGeneration(@RequestParam String cellsJson) {
    ObjectMapper mapper = new ObjectMapper();
    Set<Cell> cells = new HashSet<>();

    try {
      System.out.println(cellsJson);
      Cell[] cellsArray = mapper.readValue(cellsJson, new TypeReference<Cell[]>() {});
      cells = new HashSet(Arrays.asList(cellsArray));
    } catch (IOException e) {
      e.printStackTrace();
    }

    CellSheet cellSheet = new CellSheet(cells);

    return generationService.nextGeneration(cellSheet);
  }

  @RequestMapping("/randomsheet")
  public Set<Cell> getRandomSheet() {
    // TODO: this logic should be moved to service layer
    Random random = new Random();
    int width = 15;
    int height = 15;
    int limit = 30;
    Set<Cell> cells = new HashSet<>();

    for (int i=0; i<limit; i++) {
      cells.add(new Cell(random.nextInt(width), random.nextInt(height)));
    }

    return cells;
  }
}
