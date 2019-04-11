/*
import {Inject, Optional} from '@angular/core';
import {interval, Observable, SchedulerLike} from 'rxjs';
import {async} from 'rxjs/internal/scheduler/async';
import {map, take} from 'rxjs/operators';
import {HttpHeaders} from '@angular/common/http';
import {apiMockDelayToken, DelayMs} from './api';

export abstract class AbstractDataServiceMock {

  protected constructor(@Optional() protected testScheduler: SchedulerLike,
              @Inject(apiMockDelayToken) protected delayMs: DelayMs) {
  }

  protected get scheduler() {

    return this.testScheduler ?
      this.testScheduler :
      /!* istanbul ignore next: Scheduler to use when mocking backend outside the tests *!/ async;
  }

  protected toDelayedObservable<T>(value: T, status = 200): Observable<T> {
    return interval(this.delayMs(), this.scheduler).pipe(
      take(1),
      map(() => {
        if (status >= 400) {
          throw this.createError(status);
        } else {
          return value;
        }
      }),
    );
  }

  protected createError(status: number) {
    return {
      headers: new HttpHeaders(),
      status,
      statusText: 'Bad Request',
      url: `url://zyx`,
      ok: false,
      name: 'HttpErrorResponse',
      message: `Http failure response for url://xyz at ${this.testScheduler.now()}`,
      error: {
        timestamp: `${this.testScheduler.now()}`,
        status,
        error: 'Bad Request',
        message: 'No message available',
        path: '//xyz'
      }
    }
  }


}
*/
