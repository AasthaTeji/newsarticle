import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class NewsPage {

    getTitle() {
        return element(by.css('h2'));
    }

    sendEmailForLogin() {
        return element(by.id('loginemail'));
    }

    sendPasswordForLogin() {
        return element(by.id('loginpassword'));
    }
    getLoginButton() {
        return element(by.class('btn btn-primary'));
    }

}
