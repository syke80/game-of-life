import {Component} from '@angular/core';
import {CellsService} from "./services/cells.service";
import {CellModel} from "./models/cell.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  cells: CellModel[] = [];

  constructor(private tableService:CellsService) {
  }

  private loadRandomTable():void {
    this.tableService.getRandomCells()
      .subscribe(
        (cells:CellModel[]) => this.cells = cells,
        (error:any) => this.handleError(error)
      );
  }

  private loadNextGeneration():void {
    this.tableService.getNextGeneration(this.cells)
      .subscribe(
        (cells:CellModel[]) => this.cells = cells,
        (error:any) => this.handleError(error)
      );
  }

  handleError(error: any) {
    console.log('Error in app component', error);
  }
}
