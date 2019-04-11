/*
import {Inject, Optional} from '@angular/core';
import {Observable, SchedulerLike} from 'rxjs';
import {OfferDataModel} from '../../models';
import {AbstractDataServiceMock} from '../abstract-data-service.mock';
import {apiMockDelayToken, apiMockSchedulerToken, DelayMs} from '../api';
import {OfferDataService} from './offer.data-service';

export class OfferDataServiceMock extends AbstractDataServiceMock implements OfferDataService {

  constructor(@Optional() @Inject(apiMockSchedulerToken) testScheduler: SchedulerLike,
              @Inject(apiMockDelayToken) delayMs: DelayMs) {
    super(testScheduler, delayMs);
  }

  create(code: string): Observable<OfferDataModel> {
    return this.toDelayedObservable({code: 'x'});
  }

  addChannel(id: string, code: string): Observable<OfferDataModel> {
    return this.toDelayedObservable({code: 'x'});
  }



}
*/
