import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {CellModel} from "../../models/cell.model";

@Component({
  moduleId: module.id,
  selector: 'cell-sheet',
  styleUrls: ['./cellsheet.component.css'],
  templateUrl: 'cellSheet.component.html'
})

export class CellSheetComponent implements OnInit, OnChanges {
  @Input() cells: CellModel[] = [];
  @Input() width: number = 0;
  @Input() height: number = 0;
  table: boolean[][] = [];

  ngOnInit(): void {
    this.parseCells();
  }

  ngOnChanges(): void {
    this.parseCells();
  }

  private resetTable() {
    this.table = [];
    for (let y=0; y<this.height; y++) {
      this.table[y] = [];
      for (let x=0; x<this.width; x++) {
        this.table[y][x] = false;
      }
    }
  }

  private parseCells(): void {
    this.resetTable();

    this.cells.forEach( (cell: CellModel) => {
      if (cell.x < this.width && cell.y<this.height) {
        this.table[cell.y][cell.x] = true;
      }
    });
  }
}
