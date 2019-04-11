import {createFeatureSelector, createSelector, MemoizedSelector} from '@ngrx/store';
import {} from '../../models';
import {State} from './state';

const getError = (state: State): any => state.error;
const getIsLoading = (state: State): boolean => state.isLoading;


export const selectDemoState: MemoizedSelector<object, State> = createFeatureSelector<State>('demo');

export const selectDemoFeatureError: MemoizedSelector<object, any> = createSelector(selectDemoState, getError);
export const selectDemoFeatureIsLoading: MemoizedSelector<object, boolean> = createSelector(selectDemoState, getIsLoading);
