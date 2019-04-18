package com.fracessoftware.loginjavafirebase.main;

public interface IMainRepository {
    void signOutUser();
    void writeRTDatabase();
    boolean isUserAuthenticated();
    String getUserEmail();
    void updateRTChild(String child);
    void removeRTChild(String child);
}
