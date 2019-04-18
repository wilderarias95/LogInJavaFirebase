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

    @Override
    public void writeRTDatabase() {
        repository.writeRTDatabase();
    }

    @Override
    public void writeRTDataSuccessful() {
        presenter.writeRTDataSuccessful();
    }

    @Override
    public void dataChange(String value) {
        presenter.dataChange(value);
    }

    @Override
    public void failedReadRT() {
        presenter.failedReadRT();
    }

    @Override
    public boolean isUserLoged() {
        return repository.isUserAuthenticated();
    }

    @Override
    public String sendUserEmail() {
        return repository.getUserEmail();
    }

    @Override
    public void updateChild(String child) {
        repository.updateRTChild(child);
    }

    @Override
    public void removeChild(String child) {
        repository.removeRTChild(child);
    }
}
