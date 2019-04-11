import {DemoActions, DemoActionTypes} from './actions';
import {initialState, State} from './state';


export function demoReducer(state = initialState, action: DemoActions): State {
  switch (action.type) {

    case DemoActionTypes.SetVersionDemo:
      return {
        ...state,
        isLoading: true,
        error: null,
      };

    case DemoActionTypes.SetVersionDemoSuccess:
      return {
        ...state,
        isLoading: false,
        error: null,
      };

    case DemoActionTypes.SetVersionDemoFailure:
      return {
        ...state,
        isLoading: action.payload.error,
        error: null,
      };

    default:
      return state;
  }
}
