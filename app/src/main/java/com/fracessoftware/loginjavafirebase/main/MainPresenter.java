package com.fracessoftware.loginjavafirebase.main;

class MainPresenter implements IMainMVP.PresenterView, IMainMVP.PresenterModel {

    IMainMVP.View view;
    IMainMVP.Model model;

    MainPresenter(IMainMVP.View view){
        this.view = view;
        model = new MainModel(this);
    }

    @Override
    public void logOutUser() {
        model.logOutUser();
    }
}
