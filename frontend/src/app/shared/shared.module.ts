import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PriceComponent} from './price/price.component';
import {IntervalSelectComponent} from './interval-select/interval-select.component';
import {MatRadioModule} from '@angular/material';


const components = [
  IntervalSelectComponent,
  PriceComponent
];

@NgModule({
  declarations: [
    ...components,
  ],
  exports: [
    ...components,
  ],
  imports: [
    CommonModule,
    MatRadioModule,
  ]
})
export class SharedModule {
}
