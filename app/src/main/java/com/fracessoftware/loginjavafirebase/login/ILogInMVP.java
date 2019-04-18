package com.fracessoftware.loginjavafirebase.login;

public interface ILogInMVP {

    interface View{

        String getEmail();
        String getPassword();
        void errorEmail();
        void errorPassword();
        void goToMainActivity();
        void errorLogInFailed();
    }

    interface PresenterView{

        void clickedLogIn();
    }

    interface PresenterModel{

        void userLogInSuccessful();
        void userLogInUnSuccessful();
    }

    interface Model{

        void sendData(String email, String password);
        void userLogInSuccessful();
        void userLogInUnSuccessful();
    }
}
