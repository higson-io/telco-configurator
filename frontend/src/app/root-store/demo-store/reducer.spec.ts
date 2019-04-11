import {demoReducer} from './reducer';
import {initialState} from './state';

describe('Demo Reducer', () => {
  describe('an unknown action', () => {
    it('should return the previous state', () => {
      const action = {} as any;

      const result = demoReducer(initialState, action);

      expect(result).toBe(initialState);
    });
  });
});
