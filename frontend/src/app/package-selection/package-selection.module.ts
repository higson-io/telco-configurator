import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PackageSelectionComponent} from './package-selection.component';
import {PackageComponent} from './package/package.component';
import {SharedModule} from '../shared';
import {MatCardModule} from '@angular/material/card';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatButtonModule} from '@angular/material/button';

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
