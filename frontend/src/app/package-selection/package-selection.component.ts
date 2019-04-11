import {Component} from '@angular/core';
import {Store} from '@ngrx/store';
import {DictionaryStoreSelectors, OfferStoreActions, RootStoreState} from '../root-store';

@Component({
  selector: 'app-package-selection',
  templateUrl: './package-selection.component.html',
  styleUrls: ['./package-selection.component.scss']
})
export class PackageSelectionComponent {

  error$ = this.store.select(DictionaryStoreSelectors.selectDictionaryFeatureError);
  isLoading$ = this.store.select(DictionaryStoreSelectors.selectDictionaryFeatureIsLoading);
  packages$ = this.store.select(DictionaryStoreSelectors.selectDictionaryPackages);

  constructor(private store: Store<RootStoreState.State>) {
  }

  newOffer(code) {
    this.store.dispatch(new OfferStoreActions.CreateOffer({code}));
  }
}
