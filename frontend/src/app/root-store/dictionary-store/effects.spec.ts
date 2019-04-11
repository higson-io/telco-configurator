import {TestBed} from '@angular/core/testing';
import {provideMockActions} from '@ngrx/effects/testing';

import {Observable} from 'rxjs';

import {DictionaryEffects} from './effects';

describe('DictionaryEffects', () => {
  let actions$: Observable<any>;
  let effects: DictionaryEffects;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        DictionaryEffects,
        provideMockActions(() => actions$)
      ]
    });

    effects = TestBed.get(DictionaryEffects);
  });

  it('should be created', () => {
    expect(effects).toBeTruthy();
  });
});
