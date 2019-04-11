import {Injectable} from '@angular/core';
import {Actions, Effect, ofType} from '@ngrx/effects';
import {catchError, concatMap, map} from 'rxjs/operators';
import {of} from 'rxjs';
import * as demoActions from './actions';
import {Action} from '@ngrx/store';
import {DemoDataService} from '../../api';


@Injectable()
export class DemoEffects {

  @Effect()
  loadDemo$ = this.actions$.pipe(
    ofType<demoActions.SetVersionDemo>(demoActions.DemoActionTypes.SetVersionDemo),
    concatMap(({payload}) => this.demoDataService.version(payload.version).pipe(
      map(data => new demoActions.SetVersionDemoSuccess({data})),
      catchError(error => of(new demoActions.SetVersionDemoFailure({error})))
    )),
  );

  constructor(private actions$: Actions<Action>,
              private demoDataService: DemoDataService) {
  }
}
