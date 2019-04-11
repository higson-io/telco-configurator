import {Component, EventEmitter, HostBinding, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-hardware',
  templateUrl: './hardware.component.html',
  styleUrls: ['./hardware.component.scss']
})
export class HardwareComponent {

  @Input() image: string;
  @Input() title: string;
  @Input() description: string;
  @Input() price: number;
  @Input() activationPrice: number;
  @Input() multiroom: boolean;
  @HostBinding('class.selected')
  @Input() selected: boolean;

  @Output() selectedChange = new EventEmitter<boolean>();

}
