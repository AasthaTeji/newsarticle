import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class SignupPage {

    navigateToSignupPage() {
        return browser.get('/signup');
    }

    sendNameForSignup() {
        return element(by.id('signupname'));
    }

    sendEmailForSignup() {
        return element(by.id('signupemail'));
    }

    sendPasswordForSignup() {
        return element(by.id('signuppassword'));
    }
    sendLanguageForSignup() {
        return element(by.id('signuplanguage'));
    }
    getSignupButton() {
        return element(by.id('btn-signup'));
    }
    getSuccessMessage() {
        return element(by.className('alert alert-success message'));
    }
    getErrorMessage() {
        return element(by.className('col form-group alert alert-danger'));
    }

}
