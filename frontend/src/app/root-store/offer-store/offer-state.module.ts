import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { OfferEffects } from './effects';
import {offerReducer} from './reducer';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    StoreModule.forFeature('offer', offerReducer),
    EffectsModule.forFeature([OfferEffects])
  ]
})
export class OfferStateModule { }
