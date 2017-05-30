import {Component, Input, Output, EventEmitter, OnChanges, OnInit} from '@angular/core';
import {CellModel} from "../../models/cell.model";
import {CellSheetItemModel} from "../../models/cellSheetItem.model";

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
  @Output() cellsUpdated = new EventEmitter();
  table: CellSheetItemModel[][] = [];

  ngOnInit(): void {
    this.parseCells();
  }

  ngOnChanges(): void {
    this.parseCells();
  }

  private updateCellsModel(): void {
    this.cells = [];

    for (let y=0; y<this.height; y++) {
      for (let x=0; x<this.width; x++) {
        if (this.table[y][x].isAlive) {
          let cell: CellModel = new CellModel(x,y);
          this.cells.push(cell);
        }
      }
    }
  }

  private toggleCell(cell: CellSheetItemModel) {
    cell.isAlive = !cell.isAlive;
    this.updateCellsModel();
    this.cellsUpdated.emit(this.cells);
  }

  private resetTable() {
    this.table = [];
    for (let y=0; y<this.height; y++) {
      this.table[y] = [];
      for (let x=0; x<this.width; x++) {
        this.table[y][x] = new CellSheetItemModel(false);
      }
    }
  }

  private parseCells(): void {
    this.resetTable();

    this.cells.forEach( (cell: CellModel) => {
      if (cell.x < this.width && cell.y<this.height) {
        this.table[cell.y][cell.x].isAlive = true;
      }
    });
  }
}
