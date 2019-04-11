import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';

import {DictionaryEffects} from './effects';
import {dictionaryReducer} from './reducer';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forFeature('dictionary', dictionaryReducer),
    EffectsModule.forFeature([DictionaryEffects]),

  ],
  providers:[
    DictionaryEffects,
  ]
})
export class DictionaryStoreModule { }
