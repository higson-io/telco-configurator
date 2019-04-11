import {Component, EventEmitter, Input, Output} from '@angular/core';
import {DictionaryIntervalModel} from '../../models';

@Component({
  selector: 'app-interval-select',
  templateUrl: './interval-select.component.html',
  styleUrls: ['./interval-select.component.scss']
})
export class IntervalSelectComponent  {

  @Input() intervals: Partial<DictionaryIntervalModel>[];
  @Input() selected: number;
  @Output() selectedChange = new EventEmitter<number>();

}
