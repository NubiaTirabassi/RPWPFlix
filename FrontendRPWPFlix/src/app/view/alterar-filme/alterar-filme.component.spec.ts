import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlterarFilmeComponent } from './alterar-filme.component';

describe('AlterarFilmeComponent', () => {
  let component: AlterarFilmeComponent;
  let fixture: ComponentFixture<AlterarFilmeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlterarFilmeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AlterarFilmeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
