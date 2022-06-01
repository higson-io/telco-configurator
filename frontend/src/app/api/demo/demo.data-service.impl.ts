import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {apiUrlToken} from '../api';
import {DemoDataService} from './demo.data-service';

@Injectable({
  providedIn: 'root',
})
export class DemoDataServiceImpl implements DemoDataService {

  constructor(private http: HttpClient,
              @Inject(apiUrlToken) private api: string) {
  }

  version(date: string) {
    const params = {date};
    return this.http.post<void>(`${this.api}version`, {date}, {params});
  }
}
