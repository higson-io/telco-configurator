import {Component, ViewChild} from '@angular/core';
import {OfferStoreSelectors, RootStoreSelectors, RootStoreState, DemoStoreActions} from './root-store';
import {Store} from '@ngrx/store';
import {tap} from 'rxjs/operators';
import { MatHorizontalStepper } from '@angular/material/stepper';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  @ViewChild('stepper') stepper: MatHorizontalStepper;

  step$ = this.store.select(OfferStoreSelectors.selectOfferStep).pipe(
    tap(step => this.switchStep(step))
  );
  loading$ = this.store.select(RootStoreSelectors.selectIsLoading);

  constructor(private store: Store<RootStoreState.State>) {
  }

  updateVersion(v: Date) {
    const version = `${v.getFullYear()}-${v.getMonth() < 9 ? '0' : ''}${v.getMonth() + 1}-${v.getDate() < 10 ? '0' : ''}${v.getDate()}`;
    this.store.dispatch(new DemoStoreActions.SetVersionDemo({version}));
  }

  private switchStep(step) {
    console.log(this.stepper);
    if (!this.stepper?.steps) {
      return;
    }

    // workaround to make time-travel debugging possible
    this.stepper.linear = false;
    this.stepper.steps.forEach((step) => step.completed = true);
    this.stepper.steps.forEach((step) => step.editable = true);
    this.stepper.selectedIndex = step;
    this.stepper.steps.forEach((step) => step.completed = false);
    this.stepper.steps.forEach((step) => step.editable = false);
    this.stepper.linear = true;
  }
}
