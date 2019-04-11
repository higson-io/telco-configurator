import {dictionaryReducer} from './reducer';
import {initialState} from './state';

describe('Dictionary Reducer', () => {
  describe('an unknown action', () => {
    it('should return the previous state', () => {
      const action = {} as any;

      const result = dictionaryReducer(initialState, action);

      expect(result).toBe(initialState);
    });
  });
});
