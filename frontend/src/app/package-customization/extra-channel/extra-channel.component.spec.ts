import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExtraChannelComponent } from './extra-channel.component';

describe('ExtraChannelComponent', () => {
  let component: ExtraChannelComponent;
  let fixture: ComponentFixture<ExtraChannelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExtraChannelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExtraChannelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
