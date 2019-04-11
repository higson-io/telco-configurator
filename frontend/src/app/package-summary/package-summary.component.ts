import {Component} from '@angular/core';
import {Store} from '@ngrx/store';
import {RootStoreSelectors, RootStoreState} from '../root-store';
import {makeTrackerByField} from '../util';
import {map} from 'rxjs/operators';

@Component({
  selector: 'app-package-summary',
  templateUrl: './package-summary.component.html',
  styleUrls: ['./package-summary.component.scss']
})
export class PackageSummaryComponent {

  dataSource$ = this.store.select(RootStoreSelectors.selectOfferInvoicesRows);
  hasData$ = this.store.select(RootStoreSelectors.selectOfferInvoicesRows).pipe(
    map(rows => rows && rows.length)
  );

  readonly byNo = makeTrackerByField('no');

  constructor(private store: Store<RootStoreState.State>) {
  }

}
