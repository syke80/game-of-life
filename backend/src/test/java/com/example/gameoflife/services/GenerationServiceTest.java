package com.example.gameoflife.services;

import com.example.gameoflife.Helper;
import com.example.gameoflife.models.Cell;
import com.example.gameoflife.models.CellSheet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GenerationServiceTest {
  @Test
  public void shouldGenerateTheRightTransformation() {
    GenerationService generationService = new GenerationService();
    List<Set<Cell>> data = Helper.getSampleTransformation();
    Set<Cell> cells = data.get(0);
    Set<Cell> expected = data.get(1);

    CellSheet cellSheet = new CellSheet(cells);

    Set<Cell> result = generationService.nextGeneration(cellSheet);

    Assert.assertEquals(expected, result);
  }
}
