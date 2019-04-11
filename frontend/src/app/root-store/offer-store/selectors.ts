import {createFeatureSelector, createSelector, MemoizedSelector} from '@ngrx/store';
import {OfferDataModel, OfferInvoiceModel} from '../../models';
import {State} from './state';

const getError = (state: State): any => state.error;

const getIsLoading = (state: State): boolean => state.isLoading;

const getStep = (state: State): number => state.step;
const getModel = (state: State): OfferDataModel => state.model;
const getModelId = (model: OfferDataModel): string => model && model.id;
const getModelDuration = (model: OfferDataModel): number => model && model.duration;
const getModelInvoices = (model: OfferDataModel): OfferInvoiceModel[] => (model && model.invoice && model.invoice.values) || [];


export const selectOfferState: MemoizedSelector<object, State> = createFeatureSelector<State>('offer');

export const selectOfferFeatureError: MemoizedSelector<object, any> = createSelector(selectOfferState, getError);
export const selectOfferFeatureIsLoading: MemoizedSelector<object, boolean> = createSelector(selectOfferState, getIsLoading);

export const selectOfferStep: MemoizedSelector<object, number> = createSelector(selectOfferState, getStep);
export const selectOfferDataModel: MemoizedSelector<object, OfferDataModel> = createSelector(selectOfferState, getModel);
export const selectOfferId: MemoizedSelector<object, string> = createSelector(selectOfferDataModel, getModelId);
export const selectOfferInterval: MemoizedSelector<object, number> = createSelector(selectOfferDataModel, getModelDuration);
export const selectOfferInvoices: MemoizedSelector<object, OfferInvoiceModel[]> = createSelector(selectOfferDataModel, getModelInvoices);
