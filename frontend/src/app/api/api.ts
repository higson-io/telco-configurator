import {InjectionToken} from '@angular/core';
import {SchedulerLike} from 'rxjs';

export type DelayMs = () => number;

export const apiUrlToken = new InjectionToken<string>('Api url prefix');
export const apiMockDelayToken = new InjectionToken<DelayMs>('Api delay function');
export const apiMockSchedulerToken = new InjectionToken<SchedulerLike>('Api ngrx scheduler');
