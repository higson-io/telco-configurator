import { Action } from '@ngrx/store';

export enum DictionaryActionTypes {
  LoadDictionary = '[Dictionary] Load Dictionary',
  LoadDictionarySuccess = '[Dictionary] Load Dictionary Success',
  LoadDictionaryFailure = '[Dictionary] Load Dictionary Failure',
}

export class LoadDictionary implements Action {
  readonly type = DictionaryActionTypes.LoadDictionary;
}

export class LoadDictionarySuccess implements Action {
  readonly type = DictionaryActionTypes.LoadDictionarySuccess;
  constructor(public payload: { data: any }) { }
}

export class LoadDictionaryFailure implements Action {
  readonly type = DictionaryActionTypes.LoadDictionaryFailure;
  constructor(public payload: { error: any }) { }
}

export type DictionaryActions = LoadDictionary | LoadDictionarySuccess | LoadDictionaryFailure;

