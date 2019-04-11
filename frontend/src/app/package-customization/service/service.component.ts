import {Component, EventEmitter, HostBinding, Input, Output} from '@angular/core';

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.scss']
})
export class ServiceComponent {

  @Input() image: string;
  @Input() title: string;
  @Input() description: string;
  @Input() price: number;
  @Input() oldPrice: number;
  @Input() activationPrice: number;
  @Input() oldActivationPrice: number;
  @HostBinding('class.selected')
  @Input() selected: boolean;

  @Output() selectedChange = new EventEmitter<boolean>();

}
