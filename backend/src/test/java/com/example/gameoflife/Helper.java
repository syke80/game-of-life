package com.example.gameoflife;

import com.example.gameoflife.models.Cell;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Helper {
  private final static Cell MAIN_CELL = new Cell(5,5);
  private final static Cell TOP_LEFT = new Cell(4,4);
  private final static Cell TOP = new Cell(5,4);
  private final static Cell TOP_RIGHT = new Cell(6,4);
  private final static Cell LEFT = new Cell(4,5);
  private final static Cell RIGHT = new Cell(6,5);
  private final static Cell BOTTOM_LEFT = new Cell(4,6);
  private final static Cell BOTTOM = new Cell(5,6);
  private final static Cell BOTTOM_RIGHT = new Cell(6,6);

  public static Cell getMainCell() {
    return MAIN_CELL;
  }

  public static Collection getAllVariationOfOneCellAroundMainCell() {
    ArrayList<Set<Cell>> data = new ArrayList<>();
    Set<Cell> cells;

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, TOP_LEFT));
    data.add(cells);

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, TOP));
    data.add(cells);

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, TOP_RIGHT));
    data.add(cells);

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, LEFT));
    data.add(cells);

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, RIGHT));
    data.add(cells);

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, BOTTOM_LEFT));
    data.add(cells);

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, BOTTOM));
    data.add(cells);

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, BOTTOM_RIGHT));
    data.add(cells);

    return data;
  }

  public static List<Set<Cell>> getSampleTransformation() {
    ArrayList<Set<Cell>> data = new ArrayList<>();
    Set<Cell> cells;

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, TOP_LEFT, TOP_RIGHT, BOTTOM));
    data.add(cells);
    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, TOP, LEFT, RIGHT));
    data.add(cells);

    return data;
  }

  public static List<Set<Cell>> getSampleAndEmptyNaighbourCoordinatesOfMain() {
    ArrayList<Set<Cell>> data = new ArrayList<>();
    Set<Cell> cells;

    cells = new HashSet<Cell>(Arrays.asList(MAIN_CELL, TOP, TOP_RIGHT));
    data.add(cells);
    cells = new HashSet<Cell>(Arrays.asList(TOP_LEFT, LEFT, RIGHT, BOTTOM_LEFT, BOTTOM, BOTTOM_RIGHT));
    data.add(cells);

    return data;
  }

  private static Set<Cell> convertCoordinatesToCells(int[][] coordinatesList) {
    Set<Cell> cells = new HashSet<>();
    Cell cell;

    for (int[] coordinates: coordinatesList) {
      cell=new Cell(coordinates[0], coordinates[1]);
      cells.add(cell);
    }

    return cells;
  }
}
