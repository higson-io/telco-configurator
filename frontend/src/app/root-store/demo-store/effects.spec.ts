import {TestBed} from '@angular/core/testing';
import {provideMockActions} from '@ngrx/effects/testing';

import {Observable} from 'rxjs';

import {DemoEffects} from './effects';

describe('DemoEffects', () => {
  let actions$: Observable<any>;
  let effects: DemoEffects;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        DemoEffects,
        provideMockActions(() => actions$)
      ]
    });

    effects = TestBed.get(DemoEffects);
  });

  it('should be created', () => {
    expect(effects).toBeTruthy();
  });
});
