import {BrowserModule} from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {APIModule} from './api/api.module';
import {RootStoreModule} from './root-store';
import {AppComponent} from './app.component';
import {apiMockDelayToken, apiUrlToken} from './api';
import {PackageSelectionModule} from './package-selection';
import {PackageCustomizationModule} from './package-customization';
import {PackageSummaryModule} from './package-summary';
import {registerLocaleData} from '@angular/common';
import localePl from '@angular/common/locales/pl';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatNativeDateModule} from '@angular/material/core';
import {MatStepperModule} from '@angular/material/stepper';
import {MatButtonModule} from '@angular/material/button';
import {MatDatepickerModule} from '@angular/material/datepicker';

registerLocaleData(localePl);

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatStepperModule,
    MatIconModule,
    RootStoreModule,
    APIModule,
    PackageSelectionModule,
    PackageCustomizationModule,
    PackageSummaryModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'pl-PL'},
    {provide: apiMockDelayToken, useValue: /* istanbul ignore next: with mock outside the tests */ () => 500 + 1500 * Math.random()},
    // {provide: apiUrlToken, useValue: '/telco-configurator/'},
    {provide: apiUrlToken, useValue: ''},
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
