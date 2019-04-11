import {Observable} from 'rxjs';
import {OfferDataModel} from '../../models';

export abstract class OfferDataService {

  abstract create(code: string, duration: number): Observable<OfferDataModel>;

  abstract fetch(id: string): Observable<OfferDataModel>;

  abstract changeDuration(id: string, duration: number): Observable<OfferDataModel>;

  abstract addChannel(id: string, code: string): Observable<OfferDataModel>;

  abstract removeChannel(id: string, code: string): Observable<OfferDataModel>;

  abstract addHardware(id: string, code: string): Observable<OfferDataModel>;

  abstract removeHardware(id: string, code: string): Observable<OfferDataModel>;

  abstract addService(id: string, code: string): Observable<OfferDataModel>;

  abstract removeService(id: string, code: string): Observable<OfferDataModel>;

}
