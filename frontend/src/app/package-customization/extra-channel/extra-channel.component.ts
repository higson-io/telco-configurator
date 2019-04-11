import {Component, EventEmitter, HostBinding, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-extra-channel',
  templateUrl: './extra-channel.component.html',
  styleUrls: ['./extra-channel.component.scss']
})
export class ExtraChannelComponent {

  @Input() image: string;
  @Input() title: string;
  @Input() description: string;
  @Input() price: number;
  @Input() oldPrice: number;
  @HostBinding('class.selected')
  @Input() selected: boolean;

  @Output() selectedChange = new EventEmitter<boolean>();

}
