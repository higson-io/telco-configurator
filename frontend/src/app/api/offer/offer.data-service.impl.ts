import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {OfferDataModel} from '../../models';
import {apiUrlToken} from '../api';
import {OfferDataService} from './offer.data-service';

@Injectable({
  providedIn: 'root',
})
export class OfferDataServiceImpl implements OfferDataService {

  constructor(private http: HttpClient,
              @Inject(apiUrlToken) private api: string) {
  }

  create(code: string, duration: number) {
    return this.http.post<OfferDataModel>(`${this.api}offers`, {package: code, duration});
  }

  fetch(id: string) {
    return this.http.get<OfferDataModel>(`${this.api}offers/${id}`);
  }

  changeDuration(id: string, duration: number) {
    return this.http.post<OfferDataModel>(`${this.api}offers/${id}/duration`, {duration});
  }

  addChannel(id: string, code: string) {
    return this.http.post<OfferDataModel>(`${this.api}offers/${id}/extra-channels`, {code});
  }

  removeChannel(id: string, code: string) {
    return this.http.delete<OfferDataModel>(`${this.api}offers/${id}/extra-channels/${code}`);
  }

  addHardware(id: string, code: string) {
    return this.http.post<OfferDataModel>(`${this.api}offers/${id}/hardware`, {code});
  }

  removeHardware(id: string, code: string) {
    return this.http.delete<OfferDataModel>(`${this.api}offers/${id}/hardware/${code}`);
  }

  addService(id: string, code: string) {
    return this.http.post<OfferDataModel>(`${this.api}offers/${id}/service`, {code});
  }

  removeService(id: string, code: string) {
    return this.http.delete<OfferDataModel>(`${this.api}offers/${id}/service/${code}`);
  }

}
