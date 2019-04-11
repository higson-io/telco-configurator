import {Action} from '@ngrx/store';

export enum OfferActionTypes {
  LoadOffer = '[Offer] Load Offer',
  LoadOfferSuccess = '[Offer] Load Offer Success',
  LoadOfferFailure = '[Offer] Load Offer Failure',
  CreateOffer = '[Offer] Create Offer',
  CreateOfferSuccess = '[Offer] Create Offer Success',
  CreateOfferFailure = '[Offer] Create Offer Failure',
  ChangeDuration = '[Offer] Change Duration',
  ChangeDurationSuccess = '[Offer] Change Duration Success',
  ChangeDurationFailure = '[Offer] Change Duration Failure',
  AddChannel = '[Offer] Add Channel',
  AddChannelSuccess = '[Offer] Add Channel Success',
  AddChannelFailure = '[Offer] Add Channel Failure',
  RemoveChannel = '[Offer] Remove Channel',
  RemoveChannelSuccess = '[Offer] Remove Channel Success',
  RemoveChannelFailure = '[Offer] Remove Channel Failure',
  AddHardware = '[Offer] Add Hardware',
  AddHardwareSuccess = '[Offer] Add Hardware Success',
  AddHardwareFailure = '[Offer] Add Hardware Failure',
  RemoveHardware = '[Offer] Remove Hardware',
  RemoveHardwareSuccess = '[Offer] Remove Hardware Success',
  RemoveHardwareFailure = '[Offer] Remove Hardware Failure',
  AddService = '[Offer] Add Service',
  AddServiceSuccess = '[Offer] Add Service Success',
  AddServiceFailure = '[Offer] Add Service Failure',
  RemoveService = '[Offer] Remove Service',
  RemoveServiceSuccess = '[Offer] Remove Service Success',
  RemoveServiceFailure = '[Offer] Remove Service Failure',
  MakeOrder = '[Offer] Make Order',
}

export class LoadOffer implements Action {
  readonly type = OfferActionTypes.LoadOffer;

  constructor(public payload: { id: string }) {
  }
}

export class LoadOfferSuccess implements Action {
  readonly type = OfferActionTypes.LoadOfferSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class LoadOfferFailure implements Action {
  readonly type = OfferActionTypes.LoadOfferFailure;

  constructor(public payload: { error: any }) {
  }
}

export class CreateOffer implements Action {
  readonly type = OfferActionTypes.CreateOffer;

  constructor(public payload: { code: string }) {
  }
}

export class CreateOfferSuccess implements Action {
  readonly type = OfferActionTypes.CreateOfferSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class CreateOfferFailure implements Action {
  readonly type = OfferActionTypes.CreateOfferFailure;

  constructor(public payload: { error: any }) {
  }
}

export class ChangeDuration implements Action {
  readonly type = OfferActionTypes.ChangeDuration;

  constructor(public payload: { duration: number }) {
  }
}

export class ChangeDurationSuccess implements Action {
  readonly type = OfferActionTypes.ChangeDurationSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class ChangeDurationFailure implements Action {
  readonly type = OfferActionTypes.ChangeDurationFailure;

  constructor(public payload: { error: any }) {
  }
}

export class AddChannel implements Action {
  readonly type = OfferActionTypes.AddChannel;

  constructor(public payload: { code: string }) {
  }
}

export class AddChannelSuccess implements Action {
  readonly type = OfferActionTypes.AddChannelSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class AddChannelFailure implements Action {
  readonly type = OfferActionTypes.AddChannelFailure;

  constructor(public payload: { error: any }) {
  }
}

export class RemoveChannel implements Action {
  readonly type = OfferActionTypes.RemoveChannel;

  constructor(public payload: { code: string }) {
  }
}

export class RemoveChannelSuccess implements Action {
  readonly type = OfferActionTypes.RemoveChannelSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class RemoveChannelFailure implements Action {
  readonly type = OfferActionTypes.RemoveChannelFailure;

  constructor(public payload: { error: any }) {
  }
}

export class AddHardware implements Action {
  readonly type = OfferActionTypes.AddHardware;

  constructor(public payload: { code: string }) {
  }
}

export class AddHardwareSuccess implements Action {
  readonly type = OfferActionTypes.AddHardwareSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class AddHardwareFailure implements Action {
  readonly type = OfferActionTypes.AddHardwareFailure;

  constructor(public payload: { error: any }) {
  }
}

export class RemoveHardware implements Action {
  readonly type = OfferActionTypes.RemoveHardware;

  constructor(public payload: { code: string }) {
  }
}

export class RemoveHardwareSuccess implements Action {
  readonly type = OfferActionTypes.RemoveHardwareSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class RemoveHardwareFailure implements Action {
  readonly type = OfferActionTypes.RemoveHardwareFailure;

  constructor(public payload: { error: any }) {
  }
}

export class AddService implements Action {
  readonly type = OfferActionTypes.AddService;

  constructor(public payload: { code: string }) {
  }
}

export class AddServiceSuccess implements Action {
  readonly type = OfferActionTypes.AddServiceSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class AddServiceFailure implements Action {
  readonly type = OfferActionTypes.AddServiceFailure;

  constructor(public payload: { error: any }) {
  }
}

export class RemoveService implements Action {
  readonly type = OfferActionTypes.RemoveService;

  constructor(public payload: { code: string }) {
  }
}

export class RemoveServiceSuccess implements Action {
  readonly type = OfferActionTypes.RemoveServiceSuccess;

  constructor(public payload: { data: any }) {
  }
}

export class RemoveServiceFailure implements Action {
  readonly type = OfferActionTypes.RemoveServiceFailure;

  constructor(public payload: { error: any }) {
  }
}

export class MakeOrder implements Action {
  readonly type = OfferActionTypes.MakeOrder;

  constructor() {
  }
}

export type OfferActions = LoadOffer
  | LoadOfferSuccess
  | LoadOfferFailure
  | CreateOffer
  | CreateOfferSuccess
  | CreateOfferFailure
  | ChangeDuration
  | ChangeDurationSuccess
  | ChangeDurationFailure
  | AddChannel
  | AddChannelSuccess
  | AddChannelFailure
  | RemoveChannel
  | RemoveChannelSuccess
  | RemoveChannelFailure
  | AddHardware
  | AddHardwareSuccess
  | AddHardwareFailure
  | RemoveHardware
  | RemoveHardwareSuccess
  | RemoveHardwareFailure
  | AddService
  | AddServiceSuccess
  | AddServiceFailure
  | RemoveService
  | RemoveServiceSuccess
  | RemoveServiceFailure
  | MakeOrder
  ;

