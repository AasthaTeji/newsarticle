import { LoginPage } from './login.po';
import { NewsPage } from '../news/news.po';
import { protractor, browser } from 'protractor';

describe('Login page', () => {
    let page: LoginPage;
    // tslint:disable-next-line:label-position
     let news = new NewsPage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });


    it('should be able to login', () => {
        page.sendEmailForLogin().sendKeys('archit@gmail.com');
        page.sendPasswordForLogin().sendKeys('111111');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(news.getTitle()));
        expect(news.getTitle().isPresent()).toBeTruthy();
        expect(browser.driver.getCurrentUrl()).toContain('/news');
    });

    it('should be not be able to login if email is wrong', () => {
        page.sendEmailForLogin().sendKeys('email@gmail.com');
        page.sendPasswordForLogin().sendKeys('A123456');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(page.getErrorMessage()));
        expect(page.getErrorMessage().getText()).toBe('Invalid Email Id or Password.');
    });
});



// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1