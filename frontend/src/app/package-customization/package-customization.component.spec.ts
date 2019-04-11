import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PackageCustomizationComponent } from './package-customization.component';

describe('PackageCustomizationComponent', () => {
  let component: PackageCustomizationComponent;
  let fixture: ComponentFixture<PackageCustomizationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PackageCustomizationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PackageCustomizationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
