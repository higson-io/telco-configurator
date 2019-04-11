export interface DictionaryModel {
  packages: Partial<DictionaryPackageModel>[];
  extraChannels: Partial<DictionaryExtraChannelsModel>[];
  hardware: Partial<DictionaryHardwareModel>[];
  services: Partial<DictionaryServiceModel>[];
  intervals: Partial<DictionaryIntervalModel>[];
}
export  interface DictionaryIntervalModel {
  value: number;
  unit?: string;
  displayUnitValue: string;
}
export interface DictionaryPackageModel {
  publicName: string;
  code: string;
  channelsSum: number;
  details: string[];
  monthlyPrice: number;
  promos: Partial<DictionaryPackagePromoModel>[];
}

export interface DictionaryPackagePromoModel {
  price: number;
  duration: number;
  unit: string;
}

export interface DictionaryExtraChannelsModel {
  code: string;
  name: string;
  description?: string;
  details?: string[];
}

export interface DictionaryHardwareModel {
  code: string;
  name: string;
  description: string;
}

export interface DictionaryServiceModel {
  code: string;
  name: string;
  description: string;
}

export interface OfferHardwareModel {
  code: string;
  selected?: boolean;
  montlyPayment?: number;
  activationPrice?: number;
  multiRoom?: boolean;
}

export interface OfferExtraServiceModel {
  code: string;
  selected?: boolean;
  monthlyPrice?: number;
  monthlyPriceAfterDiscounts?: number;
  activationPrice?: number;
  activationPriceAfterDiscounts?: number;
}

export interface OfferExtraChannelsModel {
  code: string;
  price: number;
  selected: boolean;
}

export interface OfferInvoiceModel {
  value: number;
  valueAfterDiscounts?: number;
  paymentDate: string;
}

export interface OfferDataModel {
  id: string,
  duration: number,
  hardware: OfferHardwareModel[],
  extraServices: OfferExtraServiceModel[],
  extraChannels: OfferExtraChannelsModel[],
  price: number,
  priceAfterDiscounts: number,
  activationPrice: number,
  activationPriceAfterDiscounts: number,
  package: string,
  invoice: { values: OfferInvoiceModel[] };
}

export interface ExtraChannel {
  code: string;
  title: string;
  description: string;
  price: number;
  oldPrice: number;
  selected: boolean;
}

export interface Hardware {
  code: string;
  title: string;
  description: string;
  price: number;
  activationPrice: number;
  multiRoom: boolean;
  selected: boolean;
}

export interface Service {
  code: string;
  title: string;
  description: string;
  price: number;
  oldPrice: number;
  activationPrice: number;
  oldActivationPrice: number;
  selected: boolean;
}

export interface Summary {
  package: string;
  interval: string;
  price: number;
  oldPrice: number;
  activationPrice: number;
  oldActivationPrice: number;
}

export interface InvoiceRow {
  no: number;
  price: number;
  oldPrice: number;
  date: string;
}
