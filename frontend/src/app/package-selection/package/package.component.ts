import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {DictionaryPackageModel} from '../../models';

@Component({
  selector: 'app-package',
  templateUrl: './package.component.html',
  styleUrls: ['./package.component.scss']
})
export class PackageComponent  {

  @Input() image: string;
  @Input() data: DictionaryPackageModel;

  @Output() select = new EventEmitter<{code: string}>();
}
