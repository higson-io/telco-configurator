import {OfferActions, OfferActionTypes} from './actions';
import {initialState, State} from './state';

export function offerReducer(state = initialState, action: OfferActions): State {
  switch (action.type) {

    case OfferActionTypes.LoadOffer:
    case OfferActionTypes.ChangeDuration:
    case OfferActionTypes.AddChannel:
    case OfferActionTypes.RemoveChannel:
    case OfferActionTypes.AddHardware:
    case OfferActionTypes.RemoveHardware:
    case OfferActionTypes.AddService:
    case OfferActionTypes.RemoveService:
      return {
        ...state,
        isLoading: true,
        error: null,
      };

    case OfferActionTypes.LoadOfferSuccess:
      return {
        ...state,
        model: action.payload.data,
        isLoading: false,
        error: null,
      };

    case OfferActionTypes.LoadOfferFailure:
    case OfferActionTypes.CreateOfferFailure:
    case OfferActionTypes.ChangeDurationFailure:
    case OfferActionTypes.AddChannelFailure:
    case OfferActionTypes.RemoveChannelFailure:
    case OfferActionTypes.AddHardwareFailure:
    case OfferActionTypes.RemoveHardwareFailure:
    case OfferActionTypes.AddServiceFailure:
    case OfferActionTypes.RemoveServiceFailure:
      return {
        ...state,
        isLoading: false,
        error: action.payload.error,
      };

    case OfferActionTypes.CreateOffer:
      return {
        ...state,
        model: null,
        isLoading: true,
        error: null,
      };

    case OfferActionTypes.CreateOfferSuccess:
    case OfferActionTypes.ChangeDurationSuccess:
    case OfferActionTypes.AddChannelSuccess:
    case OfferActionTypes.RemoveChannelSuccess:
    case OfferActionTypes.AddHardwareSuccess:
    case OfferActionTypes.RemoveHardwareSuccess:
    case OfferActionTypes.AddServiceSuccess:
    case OfferActionTypes.RemoveServiceSuccess:
      return {
        ...state,
        model: action.payload.data,
        isLoading: false,
        error: null,
        step: 1,
      };

    case OfferActionTypes.MakeOrder:
      return {
        ...state,
        step: 2,
      };

    default:
      return state;
  }
}
