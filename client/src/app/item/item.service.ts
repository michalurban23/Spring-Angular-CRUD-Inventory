import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs/Observable';
import { catchError, map } from 'rxjs/operators';

import {Item} from './item';

@Injectable()
export class ItemService {

    constructor(private http: HttpClient) {}

    getItems (): Observable<Item[]> {
        return this.http.get<Item[]>('//localhost:8080/items')
            .pipe(
                catchError(this.handleError('get', []))
            );
    }

    private handleError<T> (operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(error);
            return of(result as T);
        };
    }
}
