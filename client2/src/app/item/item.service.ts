import { Injectable } from '@angular/core';
import { Observable, of } from "rxjs";
import { catchError, map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Item } from "./item";

@Injectable({
    providedIn: 'root'
})
export class ItemService {

    airportsUrl = "http://localhost:8080" + "/items";

    constructor(private http: HttpClient) {
    }

    getItems (): Observable<Item[]> {
        return this.http.get<Item[]>(this.airportsUrl)
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
