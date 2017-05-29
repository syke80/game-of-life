package com.example.gameoflife.models;

import java.util.HashSet;
import java.util.Set;

public class CellSheet {
  private Set<Cell> cellsOnSheet;

  public CellSheet() {
    this(new HashSet<Cell>());
  }

  public CellSheet(Set<Cell> cellsOnSheet) {
    this.cellsOnSheet = cellsOnSheet;
  }

  public Set<Cell> getCellsOnSheet() {
    return cellsOnSheet;
  }

  public int getNeighboursCount(Cell cellToExamine) {
    int counter = 0;

    for (Cell cell: cellsOnSheet) {
      if (isCellsNeighbours(cell, cellToExamine)) {
        counter ++;
      }
    }

    return counter;
  }

  public Set<Cell> getEmptyNeighbourCoordinates(Cell cell) {
    Set<Cell> neighbourCoordinates = new HashSet<>();
    Cell neighbourCell;
    int x;
    int y;

    for (x=-1; x<=1; x++) {
      for (y=-1; y<=1; y++) {
        if (x!=0 || y!=0) {
          neighbourCell = new Cell(cell.getX() + x, cell.getY() + y);
          if (!cellsOnSheet.contains(neighbourCell)) {
            neighbourCoordinates.add(neighbourCell);
          }
        }
      }
    }

    return neighbourCoordinates;
  }

  private boolean isCellsNeighbours(Cell cell1, Cell cell2) {
    if (cell1.equals(cell2)) {
      return false;
    }

    int xDistance = cell1.getX() - cell2.getX();
    int yDistance = cell1.getY() - cell2.getY();

    if (xDistance>=-1 && xDistance<=1 && yDistance>=-1 && yDistance<=1){
      return true;
    } else {
      return false;
    }
  }
}
