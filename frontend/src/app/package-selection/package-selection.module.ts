import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PackageSelectionComponent} from './package-selection.component';
import {PackageComponent} from './package/package.component';
import {MatButtonModule, MatCardModule, MatProgressSpinnerModule} from '@angular/material';
import {SharedModule} from '../shared';

@NgModule({
  declarations: [
    PackageSelectionComponent,
    PackageComponent,
  ],
  exports: [
    PackageSelectionComponent,
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    MatProgressSpinnerModule,
    SharedModule,
  ]
})
export class PackageSelectionModule { }
