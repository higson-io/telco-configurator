import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Summary} from '../../models';

@Component({
  selector: 'app-summary',
  templateUrl: './summary.component.html',
  styleUrls: ['./summary.component.scss']
})
export class SummaryComponent {
  @Input() data: Summary;

  @Output() order = new EventEmitter<void>();
}
