import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { NewsComponent } from './news/news.component';
import { HeaderComponent } from './header/header.component';
import { FindanalystComponent } from './findanalyst/findanalyst.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { APP_BASE_HREF } from '@angular/common';
import { Routes } from '@angular/router';

fdescribe('AppComponent', () => {
  const routes: Routes = [
    { path: 'signup', component: SignupComponent },
    { path: '', component: LoginComponent },
    { path: 'news', component: NewsComponent },
    { path: 'findanalyst', component: FindanalystComponent },
  ];
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        SignupComponent,
        LoginComponent,
        NewsComponent,
        HeaderComponent,
        FindanalystComponent
      ],
      imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        ReactiveFormsModule,
        HttpClientModule
      ],
      providers: [
        {provide : APP_BASE_HREF  , USE_VALUE:'/'}
      ]
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'newsarticle'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('newsarticle');
  });

});
