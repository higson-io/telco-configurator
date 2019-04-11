import {Injectable} from '@angular/core';
import {Actions, Effect, ofType, OnInitEffects, ROOT_EFFECTS_INIT} from '@ngrx/effects';
import {catchError, concatMap, map, mapTo, startWith, tap} from 'rxjs/operators';
import {of} from 'rxjs';
import * as dictionaryActions from './actions';
import {DemoStoreActions} from '../demo-store'
import {Action} from '@ngrx/store';
import {DictionaryDataService} from '../../api';


@Injectable()
export class DictionaryEffects implements OnInitEffects {

  @Effect()
  loadDictionary$ = this.actions$.pipe(
    ofType(dictionaryActions.DictionaryActionTypes.LoadDictionary),
    concatMap(() => this.dictionaryDataService.fetch().pipe(
      map(data => new dictionaryActions.LoadDictionarySuccess({data})),
      catchError(error => of(new dictionaryActions.LoadDictionaryFailure({error})))
    )),
  );

  @Effect()
  reloadDictionary$ = this.actions$.pipe(
    ofType(DemoStoreActions.DemoActionTypes.SetVersionDemoSuccess),
    mapTo(new dictionaryActions.LoadDictionary()),
  );

  constructor(private actions$: Actions<Action>,
              private dictionaryDataService: DictionaryDataService) {
  }

  ngrxOnInitEffects(): Action {
    return new dictionaryActions.LoadDictionary();
  }

}
