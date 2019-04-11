import {DemoStoreState} from './demo-store';
import {DictionaryStoreState} from './dictionary-store';
import {OfferStoreState} from './offer-store';

export interface State {
  demo: DemoStoreState.State;
  dictionary: DictionaryStoreState.State;
  offer: OfferStoreState.State;
}
