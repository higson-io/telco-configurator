import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DictionaryDataService} from './dictionary/dictionary.data-service';
import {DictionaryDataServiceImpl} from './dictionary/dictionary.data-service.impl';
import {OfferDataService} from './offer/offer.data-service';
import {OfferDataServiceImpl} from './offer/offer.data-service.impl';
import {HttpClientModule} from '@angular/common/http';
import {DemoDataService} from './demo/demo.data-service';
import {DemoDataServiceImpl} from './demo/demo.data-service.impl';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,
  ],
  providers: [
    {provide: DemoDataService, useClass: DemoDataServiceImpl},
    {provide: DictionaryDataService, useClass: DictionaryDataServiceImpl},
    {provide: OfferDataService, useClass: OfferDataServiceImpl},
  ]
})
export class APIModule {
}
