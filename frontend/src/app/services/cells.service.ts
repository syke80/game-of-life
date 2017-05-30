import {Injectable} from '@angular/core';
import {Headers, Http, Response, RequestOptions, URLSearchParams} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {CellModel} from "../models/cell.model";

@Injectable()

export class CellsService {
  private serviceEndpointUrl:string = 'http://localhost:8080/api/v1/cellsheet';

  constructor(private http:Http) {
  }

  getRandomCells():Observable<CellModel[]> {
    let resourceUrl: string = this.serviceEndpointUrl + '/randomsheet';

    return this.http.get(resourceUrl, {headers: this.getHeaders()})
      .map((response:Response) => this.extractResponse(response))
      .catch(this.handleError);
  }

  getNextGeneration(cells: CellModel[]):Observable<CellModel[]> {
    let resourceUrl: string = this.serviceEndpointUrl + '/nextgeneration',
      options: any,
      params: URLSearchParams;

    params = new URLSearchParams();
    params.append('cellsJson', JSON.stringify(cells));

    options = {
      headers: this.getHeaders,
      search: params
    };

    return this.http.get(resourceUrl, options)
      .map((response:Response) => this.extractResponse(response))
      .catch(this.handleError);
  }

  private getHeaders():Headers {
    return new Headers({
      'Content-Type': 'application/json'
    });
  }

  private extractResponse(response:Response):CellModel[] {
    return response.json();
  }

  private handleError(error:Response) {
    return Observable.throw('Error fetching user endpoint.');
  }
}
