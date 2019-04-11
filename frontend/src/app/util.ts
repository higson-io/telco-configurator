import {TrackByFunction} from '@angular/core';

export function makeTrackerByField<T>(field: keyof T): TrackByFunction<T> {
  return (i: number, x: T) => x[field];
}
