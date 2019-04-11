import {DictionaryActions, DictionaryActionTypes} from './actions';
import {initialState, State} from './state';


export function dictionaryReducer(state = initialState, action: DictionaryActions): State {
  switch (action.type) {

    case DictionaryActionTypes.LoadDictionary:
      return {
        ...state,
        isLoading: true,
        error: null,
      };

    case DictionaryActionTypes.LoadDictionarySuccess:
      return {
        ...state,
        model: action.payload.data,
        isLoading: false,
        error: null,
      };

    case DictionaryActionTypes.LoadDictionaryFailure:
      return {
        ...state,
        isLoading: action.payload.error,
        error: null,
      };

    default:
      return state;
  }
}
