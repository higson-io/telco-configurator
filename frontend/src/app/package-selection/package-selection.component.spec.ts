import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PackageSelectionComponent } from './package-selection.component';
import { Store, StoreModule } from '@ngrx/store';

describe('PackageSelectionComponent', () => {
  let component: PackageSelectionComponent;
  let fixture: ComponentFixture<PackageSelectionComponent>;
  let store: Store<any>;

  beforeEach(async() => {
    TestBed.configureTestingModule({
      imports: [ StoreModule.forRoot({}) ],
      declarations: [ PackageSelectionComponent ]
    });

    await TestBed.compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PackageSelectionComponent);
    component = fixture.componentInstance;
    store = TestBed.get(Store);

    spyOn(store, 'dispatch').and.callThrough();
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
