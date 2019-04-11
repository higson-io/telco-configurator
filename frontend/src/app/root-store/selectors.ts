import {OfferStoreSelectors} from './offer-store';
import {DictionaryStoreSelectors} from './dictionary-store';
import {createSelector, MemoizedSelector} from '@ngrx/store';
import {ExtraChannel, Hardware, InvoiceRow, Service, Summary} from '../models';
import {DemoStoreSelectors} from './demo-store';

export const selectError: MemoizedSelector<object, string> = createSelector(
  DemoStoreSelectors.selectDemoFeatureError,
  DictionaryStoreSelectors.selectDictionaryFeatureError,
  OfferStoreSelectors.selectOfferFeatureError,
  (demo:string, dictionary: string, offer: string) => demo || dictionary || offer
);

export const selectIsLoading: MemoizedSelector<object, boolean> = createSelector(
  DemoStoreSelectors.selectDemoFeatureIsLoading,
  DictionaryStoreSelectors.selectDictionaryFeatureIsLoading,
  OfferStoreSelectors.selectOfferFeatureIsLoading,
  (demo:boolean, dictionary: boolean, offer: boolean) => demo || dictionary || offer
);

export const selectOfferExtraChannels: MemoizedSelector<object, ExtraChannel[]> = createSelector(
  DictionaryStoreSelectors.selectDictionaryExtraChannels,
  OfferStoreSelectors.selectOfferDataModel,
  (channels, offer) => {
    if (!offer) {
      return [];
    }
    if (!channels) {
      return [];
    }
    const dict = makeDict(channels, 'code');
    return (offer.extraChannels || [])
      .filter(channel => dict[channel.code])
      .map(channel => ({
        ...channel,
        title: dict[channel.code].name,
        description: [dict[channel.code].description, ...dict[channel.code].details].join('\n'),
        oldPrice: channel.price,
      }));
  }
);

function makeDict<T>(arr: T[], field: keyof T): { [field: string]: T } {
  return Object.assign({}, ...(arr || []).map(item => ({[`${item[field]}`]: item})));
}

export const selectOfferHardwares: MemoizedSelector<object, Hardware[]> = createSelector(
  DictionaryStoreSelectors.selectDictionaryHardware,
  OfferStoreSelectors.selectOfferDataModel,
  (hardwares, offer) => {
    if (!offer) {
      return [];
    }
    if (!hardwares) {
      return [];
    }
    const dict = makeDict(hardwares, 'code');
    return (offer.hardware || [])
      .filter(hardware => dict[hardware.code])
      .map(hardware => ({
        code: hardware.code,
        selected: hardware.selected,
        multiRoom: hardware.multiRoom,
        title: dict[hardware.code].name,
        description: dict[hardware.code].description,
        price: hardware.montlyPayment || 0,
        activationPrice: hardware.activationPrice || 0,
      }));
  }
);

export const selectOfferServices: MemoizedSelector<object, Service[]> = createSelector(
  DictionaryStoreSelectors.selectDictionaryService,
  OfferStoreSelectors.selectOfferDataModel,
  (services, offer) => {
    if (!offer) {
      return [];
    }
    if (!services) {
      return [];
    }
    const dict = makeDict(services, 'code');
    return (offer.extraServices || [])
      .filter(service => dict[service.code])
      .map(service => ({
        code: service.code,
        selected: service.selected,
        title: dict[service.code].name,
        description: dict[service.code].description,
        price: service.monthlyPriceAfterDiscounts || 0,
        oldPrice: service.monthlyPrice || 0,
        activationPrice: service.activationPriceAfterDiscounts || 0,
        oldActivationPrice: service.activationPrice || 0,
      }));
  }
);

export const selectOfferSummary: MemoizedSelector<object, Summary> = createSelector(
  DictionaryStoreSelectors.selectDictionaryPackages,
  DictionaryStoreSelectors.selectDictionaryIntervals,
  OfferStoreSelectors.selectOfferDataModel,
  (packages, intervals, offer) => {
    if (!offer) {
      return null;
    }
    const packagesDict = makeDict(packages, 'code');
    const intervalsDict = makeDict(intervals, 'value');
    return {
      activationPrice: offer.activationPriceAfterDiscounts,
      oldActivationPrice: offer.activationPrice,
      price: offer.priceAfterDiscounts,
      oldPrice: offer.price,
      interval: `${offer.duration} ${intervalsDict[offer.duration].displayUnitValue}`,
      package: packagesDict[offer.package].publicName,
    };
  }
);

export const selectOfferInvoicesRows: MemoizedSelector<object, InvoiceRow[]> = createSelector(
  OfferStoreSelectors.selectOfferInvoices,
  (invoices) => invoices.map((invoice, index) => ({
    no: index + 1,
    date: invoice.paymentDate,
    price: invoice.valueAfterDiscounts || invoice.value,
    oldPrice: invoice.value || invoice.valueAfterDiscounts,
  }))
);
