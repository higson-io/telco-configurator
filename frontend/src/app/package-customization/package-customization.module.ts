import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {PackageCustomizationComponent} from './package-customization.component';
import {HardwareComponent} from './hardware/hardware.component';
import {ExtraChannelComponent} from './extra-channel/extra-channel.component';
import {SharedModule} from '../shared';
import {SummaryComponent} from './summary/summary.component';
import {ServiceComponent} from './service/service.component';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [PackageCustomizationComponent, HardwareComponent, ExtraChannelComponent, ServiceComponent, SummaryComponent],
  exports: [PackageCustomizationComponent],
  imports: [
    CommonModule,
    MatButtonModule,
    MatCardModule,
    SharedModule,
  ]
})
export class PackageCustomizationModule {
}
