import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PackageSummaryComponent} from './package-summary.component';
import {SharedModule} from '../shared';
import {MatTableModule} from '@angular/material';

@NgModule({
  declarations: [PackageSummaryComponent],
  exports: [PackageSummaryComponent],
  imports: [
    CommonModule,
    SharedModule,
    MatTableModule,
  ]
})
export class PackageSummaryModule {
}
