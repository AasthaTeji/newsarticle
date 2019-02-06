import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { DebugElement } from '@angular/core';
import { By, BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from '../app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from '../signup/signup.component';
import { NewsComponent } from '../news/news.component';
import { FindanalystComponent } from '../findanalyst/findanalyst.component';
import { LoginService } from './login.service';

fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let de : DebugElement;
  let el : HTMLElement;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent, SignupComponent, NewsComponent, FindanalystComponent ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule
      ],
      providers : [ LoginService]
    })
    .compileComponents().then(() =>{
      fixture = TestBed.createComponent(LoginComponent);
      component = fixture.componentInstance;

      de = fixture.debugElement.query(By.css('form'));
      el = de.nativeElement;

    });
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form should valid when field is not empty',async(()=> {
    //accessing controls
    component.loginForm.controls['email'].setValue('Rahulkamble01@gmail.com');
    component.loginForm.controls['password'].setValue('Rahulkamble01');
    expect(component.loginForm.valid).toBeTruthy();
  }));

  it('form should invalid when empty',async(()=> {
    //accessing controls
    component.loginForm.controls['email'].setValue('');
    component.loginForm.controls['password'].setValue('');
    expect(component.loginForm.valid).toBeFalsy();
  }));

  it('should call the login method', async(()=> {
    fixture.detectChanges();
    spyOn(component, 'login');
    el =fixture.debugElement.query(By.css('button')).nativeElement;
    el.click();
    expect(component.login).toHaveBeenCalledTimes(1);
  }));

});
