import {offerReducer} from './reducer';
import {initialState} from './state';

describe('Offer Reducer', () => {
  describe('an unknown action', () => {
    it('should return the previous state', () => {
      const action = {} as any;

      const result = offerReducer(initialState, action);

      expect(result).toBe(initialState);
    });
  });
});
