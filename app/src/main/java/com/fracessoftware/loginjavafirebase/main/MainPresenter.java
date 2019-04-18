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

    @Override
    public void clickedWriteRT() {
        model.writeRTDatabase();
    }

    @Override
    public void writeRTDataSuccessful() {
        view.messageWriteSuccessful();
    }

    @Override
    public void dataChange(String value) {
        view.updateData(value);
    }

    @Override
    public void failedReadRT() {
        view.messageReadFailed();
    }

    @Override
    public boolean isUserLoged() {
        return model.isUserLoged();
    }

    @Override
    public String sendUserEmail() {
        return model.sendUserEmail();
    }

    @Override
    public void clickedUpdateChild(String child) {
        model.updateChild(child);
    }

    @Override
    public void clickedRemoveChild(String child) {
        model.removeChild(child);
    }
}
