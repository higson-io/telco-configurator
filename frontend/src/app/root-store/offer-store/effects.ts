import {Injectable} from '@angular/core';
import {Actions, Effect, ofType} from '@ngrx/effects';
import {catchError, concatMap, map, withLatestFrom} from 'rxjs/operators';
import {of} from 'rxjs';
import * as offerActions from './actions';
import {Action, Store} from '@ngrx/store';
import {OfferDataService} from '../../api';
import {selectOfferId} from './selectors'
import {DictionaryStoreSelectors} from '../dictionary-store'
import {DemoStoreActions} from '../demo-store';

@Injectable()
export class OfferEffects {

  @Effect()
  createOffer$ = this.actions$.pipe(
    ofType<offerActions.CreateOffer>(offerActions.OfferActionTypes.CreateOffer),
    withLatestFrom(this.store.select(DictionaryStoreSelectors.selectDictionaryIntervals)),
    concatMap(([{payload}, intervals]) => this.offerDataService.create(payload.code, intervals[intervals.length - 1].value).pipe(
      map(data => new offerActions.CreateOfferSuccess({data})),
      catchError(error => of(new offerActions.CreateOfferFailure({error})))
    )),
  );

  @Effect()
  loadOffer$ = this.actions$.pipe(
    ofType<offerActions.LoadOffer>(offerActions.OfferActionTypes.LoadOffer),
    concatMap(({payload}) => this.offerDataService.fetch(payload.id).pipe(
      map(data => new offerActions.LoadOfferSuccess({data})),
      catchError(error => of(new offerActions.LoadOfferFailure({error})))
    )),
  );

  @Effect()
  changeDuration$ = this.actions$.pipe(
    ofType<offerActions.ChangeDuration>(offerActions.OfferActionTypes.ChangeDuration),
    withLatestFrom(this.store.select(selectOfferId)),
    concatMap(([{payload}, id]) => this.offerDataService.changeDuration(id, payload.duration).pipe(
      map(data => new offerActions.ChangeDurationSuccess({data})),
      catchError(error => of(new offerActions.ChangeDurationFailure({error})))
    )),
  );

  @Effect()
  addChannel$ = this.actions$.pipe(
    ofType<offerActions.AddChannel>(offerActions.OfferActionTypes.AddChannel),
    withLatestFrom(this.store.select(selectOfferId)),
    concatMap(([{payload}, id]) => this.offerDataService.addChannel(id, payload.code).pipe(
      map(data => new offerActions.AddChannelSuccess({data})),
      catchError(error => of(new offerActions.AddChannelFailure({error})))
    )),
  );

  @Effect()
  removeChannel$ = this.actions$.pipe(
    ofType<offerActions.RemoveChannel>(offerActions.OfferActionTypes.RemoveChannel),
    withLatestFrom(this.store.select(selectOfferId)),
    concatMap(([{payload}, id]) => this.offerDataService.removeChannel(id, payload.code).pipe(
      map(data => new offerActions.RemoveChannelSuccess({data})),
      catchError(error => of(new offerActions.RemoveChannelFailure({error})))
    )),
  );

  @Effect()
  addHardware$ = this.actions$.pipe(
    ofType<offerActions.AddHardware>(offerActions.OfferActionTypes.AddHardware),
    withLatestFrom(this.store.select(selectOfferId)),
    concatMap(([{payload}, id]) => this.offerDataService.addHardware(id, payload.code).pipe(
      map(data => new offerActions.AddHardwareSuccess({data})),
      catchError(error => of(new offerActions.AddHardwareFailure({error})))
    )),
  );

  @Effect()
  removeHardware$ = this.actions$.pipe(
    ofType<offerActions.RemoveHardware>(offerActions.OfferActionTypes.RemoveHardware),
    withLatestFrom(this.store.select(selectOfferId)),
    concatMap(([{payload}, id]) => this.offerDataService.removeHardware(id, payload.code).pipe(
      map(data => new offerActions.RemoveHardwareSuccess({data})),
      catchError(error => of(new offerActions.RemoveHardwareFailure({error})))
    )),
  );

  @Effect()
  addService$ = this.actions$.pipe(
    ofType<offerActions.AddService>(offerActions.OfferActionTypes.AddService),
    withLatestFrom(this.store.select(selectOfferId)),
    concatMap(([{payload}, id]) => this.offerDataService.addService(id, payload.code).pipe(
      map(data => new offerActions.AddServiceSuccess({data})),
      catchError(error => of(new offerActions.AddServiceFailure({error})))
    )),
  );

  @Effect()
  removeService$ = this.actions$.pipe(
    ofType<offerActions.RemoveService>(offerActions.OfferActionTypes.RemoveService),
    withLatestFrom(this.store.select(selectOfferId)),
    concatMap(([{payload}, id]) => this.offerDataService.removeService(id, payload.code).pipe(
      map(data => new offerActions.RemoveServiceSuccess({data})),
      catchError(error => of(new offerActions.RemoveServiceFailure({error})))
    )),
  );

  @Effect()
  reloadOffer$ = this.actions$.pipe(
    ofType(DemoStoreActions.DemoActionTypes.SetVersionDemoSuccess),
    withLatestFrom(this.store.select(selectOfferId)),
    map(([, id]) => new offerActions.LoadOffer({id})),
  );


  constructor(private actions$: Actions<Action>,
              private offerDataService: OfferDataService,
              private store: Store<any>) {
  }

}
