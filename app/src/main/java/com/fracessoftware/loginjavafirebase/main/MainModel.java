package com.fracessoftware.loginjavafirebase.main;

class MainModel implements IMainMVP.Model {

    IMainMVP.PresenterModel presenter;
    IMainRepository repository;

    MainModel(IMainMVP.PresenterModel presenter) {
        this.presenter = presenter;
        repository = new MainRepository(this);
    }

    @Override
    public void logOutUser() {
        repository.signOutUser();
    }
}
