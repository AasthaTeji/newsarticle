import { SignupPage } from './signup.po';
import { LoginPage } from '../login/login.po';
import { protractor, browser } from 'protractor';

describe('Signup page', () => {
    let page: SignupPage;
    // tslint:disable-next-line:label-position
     let login = new LoginPage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new SignupPage();
        page.navigateToSignupPage();
    });


    it('should be able to signup', () => {
        page.sendNameForSignup().sendKeys('kiran');
        page.sendEmailForSignup().sendKeys('aastha@gmail.com');
        page.sendPasswordForSignup().sendKeys('A123456');
         page.sendLanguageForSignup().sendKeys("english");
        page.getSignupButton().click();
        browser.wait(EC.visibilityOf(page.getSuccessMessage()));
        expect(page.getSuccessMessage().isPresent()).toBeTruthy();
        
    });
});

  /*   it('should be not be able to login if email is wrong', () => {
        page.sendEmailForLogin().sendKeys('email@gmail.com');
        page.sendPasswordForLogin().sendKeys('A123456');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(page.getErrorMessage()));
        expect(page.getErrorMessage().getText()).toBe('Invalid Email Id or Password.');
    });
});
 */


// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1