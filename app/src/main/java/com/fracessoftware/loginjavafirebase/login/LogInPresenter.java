package com.fracessoftware.loginjavafirebase.login;

class LogInPresenter implements ILogInMVP.PresenterView, ILogInMVP.PresenterModel{

    ILogInMVP.View view;
    ILogInMVP.Model model;



    LogInPresenter(ILogInMVP.View view) {
        this.view = view;
        model = new LogInModel(this);
    }


    @Override
    public void clickedLogIn() {
        String email = view.getEmail();
        String password = view.getPassword();

        if (email.equals(""))
            view.errorEmail();
        else if (password.equals(""))
            view.errorPassword();
        else
            model.sendData(email, password);

    }

    @Override
    public void userLogInSuccessful() {
        view.goToMainActivity();
    }

    @Override
    public void userLogInUnSuccessful() {
        view.errorLogInFailed();
    }

    @Override
    public boolean isUserLoged() {
        return model.isUserLoged();
    }
}
