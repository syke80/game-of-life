package com.example.gameoflife.models;

import com.example.gameoflife.Helper;
import com.example.gameoflife.services.GenerationService;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * Created by syke on 30/05/2017.
 */
public class CellSheetTest {

  @RunWith(Parameterized.class)
  public static class NeighbourCellTest {
    @Parameter
    public Set<Cell> cells;

    @Parameters
    public static Collection data() {
      return Helper.getAllVariationOfOneCellAroundMainCell();
    }

    @Test
    public void shouldFindNeighbourCells() {
      CellSheet cellSheet = new CellSheet(cells);

      int result = cellSheet.getNeighboursCount(Helper.getMainCell());

      Assert.assertEquals(1, result);
    }
  }

  public static class EmptyTest {
    @Test
    public void shouldFindCellsEmptyNeighbourCoordinates() {
      List<Set<Cell>> data = Helper.getSampleAndEmptyNaighbourCoordinatesOfMain();
      Set<Cell> cells = data.get(0);
      Set<Cell> expected = data.get(1);

      CellSheet cellSheet = new CellSheet(cells);

      Set<Cell> result = cellSheet.getEmptyNeighbourCoordinates(Helper.getMainCell());

      Assert.assertEquals(expected, result);
    }
  }
}
