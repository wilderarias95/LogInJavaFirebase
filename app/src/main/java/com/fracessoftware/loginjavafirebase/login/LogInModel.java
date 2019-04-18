package com.fracessoftware.loginjavafirebase.login;

public class LogInModel implements ILogInMVP.Model{

    ILogInMVP.PresenterModel presenter;
    ILogInRepository repository;

    LogInModel(ILogInMVP.PresenterModel presenter){
        this.presenter = presenter;
        repository = new LogInRepository(this);
    }

    @Override
    public void sendData(String email, String password) {
        repository.authenticationFirebase(email, password);
    }

    @Override
    public void userLogInSuccessful() {
        presenter.userLogInSuccessful();
    }

    @Override
    public void userLogInUnSuccessful() {
        presenter.userLogInUnSuccessful();
    }
}
