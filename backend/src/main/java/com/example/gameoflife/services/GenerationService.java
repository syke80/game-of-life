package com.example.gameoflife.services;

import com.example.gameoflife.models.Cell;
import com.example.gameoflife.models.CellSheet;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class GenerationService {
  public HashSet<Cell> nextGeneration(CellSheet cellSheet) {
    HashSet<Cell> nextCells = new HashSet<>();

    nextCells.addAll(getSurvivors(cellSheet));
    nextCells.addAll(getBornCells(cellSheet));

    return nextCells;
  }

  private boolean isHealthy(CellSheet cellSheet, Cell cell) {
    int neighboursCount = cellSheet.getNeighboursCount(cell);
    return (neighboursCount == 2 || neighboursCount == 3);
  }

  private Set<Cell> getSurvivors(CellSheet cellSheet) {
    HashSet<Cell> survivors = new HashSet<>();
    Set<Cell> cellsOnSheet = cellSheet.getCellsOnSheet();

    for (Cell cell: cellsOnSheet) {
      if (isHealthy(cellSheet, cell)) {
        survivors.add(cell);
      }
    }

    return survivors;
  }

  private Set<Cell> getBornCells(CellSheet cellSheet) {
    Set<Cell> bornCells = new HashSet<>();
    Set<Cell> possibleBornCells = getPossibleBornCells(cellSheet);

    for (Cell cell : possibleBornCells) {
      if (cellSheet.getNeighboursCount(cell) == 3) {
        bornCells.add(cell);
      }
    }

    return bornCells;
  }

  private Set<Cell> getPossibleBornCells(CellSheet cellSheet) {
    Set<Cell> possibleBornCells = new HashSet<>();
    Set<Cell> cellsOnSheet = cellSheet.getCellsOnSheet();

    for (Cell cell: cellsOnSheet) {
      possibleBornCells.addAll(cellSheet.getEmptyNeighbourCoordinates(cell));
    }

    return possibleBornCells;
  }

}
