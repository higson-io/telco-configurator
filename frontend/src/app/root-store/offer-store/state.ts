import {OfferDataModel} from '../../models';

export interface State {
  model: OfferDataModel | null;
  isLoading: boolean;
  error: string;
  step: number;
}

export const initialState: State = {
  model: null,
  isLoading: false,
  error: null,
  step: 0,
};
