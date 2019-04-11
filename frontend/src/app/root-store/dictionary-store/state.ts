import {DictionaryModel} from '../../models';

export interface State {
  model: DictionaryModel | null;
  isLoading: boolean;
  error: string;
}

export const initialState: State = {
  model: null,
  isLoading: false,
  error: null,
};
