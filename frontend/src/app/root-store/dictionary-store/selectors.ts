import {createFeatureSelector, createSelector, MemoizedSelector} from '@ngrx/store';
import {
  DictionaryExtraChannelsModel,
  DictionaryHardwareModel,
  DictionaryIntervalModel,
  DictionaryPackageModel,
  DictionaryServiceModel
} from '../../models';
import {State} from './state';

const getError = (state: State): any => state.error;

const getIsLoading = (state: State): boolean => state.isLoading;

const getPackages = (state: State): any => (state.model && state.model.packages) || [];
const getHardware = (state: State): any => state.model && state.model.hardware;
const getService = (state: State): any => state.model && state.model.services;
const getIntervals = (state: State): any => state.model && state.model.intervals;
const getExtraChannels = (state: State): any => state.model && state.model.extraChannels;


export const selectDictionaryState: MemoizedSelector<object, State> = createFeatureSelector<State>('dictionary');

export const selectDictionaryFeatureError: MemoizedSelector<object, any> = createSelector(selectDictionaryState, getError);
export const selectDictionaryFeatureIsLoading: MemoizedSelector<object, boolean> = createSelector(selectDictionaryState, getIsLoading);

export const selectDictionaryPackages: MemoizedSelector<object, DictionaryPackageModel[]> = createSelector(selectDictionaryState, getPackages);
export const selectDictionaryHardware: MemoizedSelector<object, DictionaryHardwareModel[]> = createSelector(selectDictionaryState, getHardware);
export const selectDictionaryService: MemoizedSelector<object, DictionaryServiceModel[]> = createSelector(selectDictionaryState, getService);
export const selectDictionaryIntervals: MemoizedSelector<object, DictionaryIntervalModel[]> = createSelector(selectDictionaryState, getIntervals);
export const selectDictionaryExtraChannels: MemoizedSelector<object, DictionaryExtraChannelsModel[]> = createSelector(selectDictionaryState, getExtraChannels);
