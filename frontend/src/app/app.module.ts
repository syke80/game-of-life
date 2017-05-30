import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { CellSheetComponent } from './components/cellSheet/cellSheet.component';
import { CellsService } from './services/cells.service';

@NgModule({
  declarations: [
    AppComponent,
    CellSheetComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [
    CellsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
