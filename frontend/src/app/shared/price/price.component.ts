import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-price',
  templateUrl: './price.component.html',
  styleUrls: ['./price.component.scss']
})
export class PriceComponent {

  @Input() value: number;
  @Input() oldValue: number;
  @Input() currency = 'zł';
  @Input() type = 'mth';
  @Input() places = 2;

  get minorValue() {
    return this.minor(this.value || this.oldValue);
  }

  get majorValue() {
    return this.major(this.value || this.oldValue);
  }

  get minorOldValue() {
    return this.minor(this.oldValue || this.value);
  }

  get majorOldValue() {
    return this.major(this.oldValue || this.value);
  }

  private minor(value) {
    return (value || 0).toFixed(this.places).split('.')[1];
  }

  private major(value) {
    return (value || 0).toFixed(this.places).split('.')[0];
  }

}
