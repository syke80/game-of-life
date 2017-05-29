package com.example.gameoflife.services;

import com.example.gameoflife.models.Cell;
import java.util.Set;

public class SheetRenderer {
  public void render(Set<Cell> cellsToRender) {
    int x;
    int y;
    Cell testCell;

    for (y=0; y<=10; y++) {
      for (x=0; x<=10; x++) {
        testCell = new Cell(x, y);
        System.out.print(cellsToRender.contains(testCell) ? 'x' : '.');
      }
      System.out.println();
    }
  }


}
