import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VechileRegistrationComponent } from './vechile-registration.component';

describe('VechileRegistrationComponent', () => {
  let component: VechileRegistrationComponent;
  let fixture: ComponentFixture<VechileRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VechileRegistrationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VechileRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
