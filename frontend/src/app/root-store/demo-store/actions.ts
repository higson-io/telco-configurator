import { Action } from '@ngrx/store';

export enum DemoActionTypes {
  SetVersionDemo = '[Demo] Set Version Demo',
  SetVersionDemoSuccess = '[Demo] Set Version Demo Success',
  SetVersionDemoFailure = '[Demo] Set Version Demo Failure',
}

export class SetVersionDemo implements Action {
  readonly type = DemoActionTypes.SetVersionDemo;
  constructor(public payload: { version: string }) { }
}

export class SetVersionDemoSuccess implements Action {
  readonly type = DemoActionTypes.SetVersionDemoSuccess;
  constructor(public payload: { data: any }) { }
}

export class SetVersionDemoFailure implements Action {
  readonly type = DemoActionTypes.SetVersionDemoFailure;
  constructor(public payload: { error: any }) { }
}

export type DemoActions = SetVersionDemo | SetVersionDemoSuccess | SetVersionDemoFailure;

