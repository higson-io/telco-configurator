import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Action, ActionReducerMap, MetaReducer, StoreModule} from '@ngrx/store';
import {State} from './state';
import {environment} from '../../environments/environment';
import {StoreDevtoolsModule} from '@ngrx/store-devtools';
import {EffectsModule} from '@ngrx/effects';
import {DemoStoreModule} from './demo-store/demo-store.module';
import {DictionaryStoreModule} from './dictionary-store';
import {OfferStateModule} from './offer-store';


const metaReducers: MetaReducer<State>[] = !environment.production ? [] : [];
const reducers: ActionReducerMap<{}, Action> = {};

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forRoot(reducers, {metaReducers}),
    StoreDevtoolsModule.instrument({maxAge: 25, logOnly: environment.production}),
    EffectsModule.forRoot([]),
    DemoStoreModule,
    DictionaryStoreModule,
    OfferStateModule,
  ]
})
export class RootStoreModule {
}
