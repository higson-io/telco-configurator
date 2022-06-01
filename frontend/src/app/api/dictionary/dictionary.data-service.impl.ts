import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DictionaryModel} from '../../models';
import {apiUrlToken} from '../api';
import {DictionaryDataService} from './dictionary.data-service';

@Injectable({
  providedIn: 'root',
})
export class DictionaryDataServiceImpl implements DictionaryDataService {

  constructor(private http: HttpClient,
              @Inject(apiUrlToken) private api: string) {
  }

  fetch() {
    return this.http.get<DictionaryModel>(`${this.api}dictionaries`);
  }
}
