import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {StoreModule} from '@ngrx/store';
import {EffectsModule} from '@ngrx/effects';

import {DemoEffects} from './effects';
import {demoReducer} from './reducer';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forFeature('demo', demoReducer),
    EffectsModule.forFeature([DemoEffects]),

  ],
  providers:[
    DemoEffects,
  ]
})
export class DemoStoreModule { }
