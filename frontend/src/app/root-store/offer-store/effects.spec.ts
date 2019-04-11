import {TestBed} from '@angular/core/testing';
import {provideMockActions} from '@ngrx/effects/testing';
import {Observable} from 'rxjs';

import {OfferEffects} from './effects';

describe('OfferEffects', () => {
  let actions$: Observable<any>;
  let effects: OfferEffects;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        OfferEffects,
        provideMockActions(() => actions$)
      ]
    });

    effects = TestBed.get(OfferEffects);
  });

  it('should be created', () => {
    expect(effects).toBeTruthy();
  });
});
