import {Component} from '@angular/core';
import {OfferStoreActions, OfferStoreSelectors} from '../root-store/offer-store';
import {Store} from '@ngrx/store';
import {DictionaryStoreSelectors, RootStoreSelectors, RootStoreState} from '../root-store';
import {makeTrackerByField} from '../util';

@Component({
  selector: 'app-package-customization',
  templateUrl: './package-customization.component.html',
  styleUrls: ['./package-customization.component.scss']
})
export class PackageCustomizationComponent {

  summary$ = this.store.select(RootStoreSelectors.selectOfferSummary);
  channels$ = this.store.select(RootStoreSelectors.selectOfferExtraChannels);
  hardwares$ = this.store.select(RootStoreSelectors.selectOfferHardwares);
  services$ = this.store.select(RootStoreSelectors.selectOfferServices);
  intervals$ = this.store.select(DictionaryStoreSelectors.selectDictionaryIntervals);
  selectedInterval$ = this.store.select(OfferStoreSelectors.selectOfferInterval);

  readonly byCode = makeTrackerByField('code');

  constructor(private store: Store<RootStoreState.State>) {
  }

  changeDuration(duration: number){
    this.store.dispatch(new OfferStoreActions.ChangeDuration({duration}));
  }

  removeChannel(code: string) {
    this.store.dispatch(new OfferStoreActions.RemoveChannel({code}))
  }

  addChannel(code: string) {
    this.store.dispatch(new OfferStoreActions.AddChannel({code}))
  }

  removeHardware(code: string) {
    this.store.dispatch(new OfferStoreActions.RemoveHardware({code}))
  }

  addHardware(code: string) {
    this.store.dispatch(new OfferStoreActions.AddHardware({code}))
  }

  removeService(code: string) {
    this.store.dispatch(new OfferStoreActions.RemoveService({code}))
  }

  addService(code: string) {
    this.store.dispatch(new OfferStoreActions.AddService({code}))
  }

  makeOrder(){
    this.store.dispatch(new OfferStoreActions.MakeOrder());
  }
}
