/*
import {Inject, Optional} from '@angular/core';
import {Observable, SchedulerLike} from 'rxjs';
import {DictionaryModel} from '../../models';
import {AbstractDataServiceMock} from '../abstract-data-service.mock';
import {apiMockDelayToken, apiMockSchedulerToken, DelayMs} from '../api';
import {DictionaryDataService} from './dictionary.data-service';

export class DictionaryDataServiceMock extends AbstractDataServiceMock implements DictionaryDataService {

  constructor(@Optional() @Inject(apiMockSchedulerToken) testScheduler: SchedulerLike,
              @Inject(apiMockDelayToken) delayMs: DelayMs) {
    super(testScheduler, delayMs);
  }

  fetch(): Observable<DictionaryModel> {
    return this.toDelayedObservable({
      packages: [
        {
          publicName: 'jakosc w dobrej cenie',
          code: 'comfort',
          channelsSum: 114,
          details: [
            '59 kanalow HD',
            '13 kanalow filmowych',
            '7 kanalow sportowych'
          ],
          monthlyPrice: 39.99,
          promos: [
            {price: 29.99, duration: 3, unit: 'month'},
            {price: 19.99, duration: 6, unit: 'month'}
          ]
        },
        {
          publicName: 'ekonomiczny pakiet filmowy',
          code: 'comfort_with_hbo',
          channelsSum: 117,
          details: [
            '59 kanalow HD',
            '13 kanalow filmowych',
            '7 kanalow sportowych',
          ],
          monthlyPrice: 49.99,
          promos: [
            {price: 19.99, duration: 6, unit: 'month'},
          ]
        },
      ],
      extraChannels: [
        {
          code: 'HBOGO',
          name: 'HBO GO',
          description: 'lorem ipsum...'
        },
        {
          code: 'ELEVENSPORTS',
          name: 'ELEVEN SPORTS',
          description: 'lorem ipsum...'
        },
      ],
      hardware: [
        {
          code: 'CI',
          name: 'Moduł CI',
          description: 'Moduł CI ble ble Lorem Ipsum'
        },
      ]
    });

  }


}
*/
