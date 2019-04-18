package com.fracessoftware.loginjavafirebase.main;

public interface IMainMVP {
    
    interface View{
        void messageWriteSuccessful();
        void updateData(String value);
        void messageReadFailed();
    }
    
    interface PresenterView{

        void logOutUser();
        void clickedWriteRT();
        boolean isUserLoged();
        String sendUserEmail();
        void clickedUpdateChild(String child);
        void clickedRemoveChild(String child);
    }
    
    interface PresenterModel{
        void writeRTDataSuccessful();
        void dataChange(String value);
        void failedReadRT();
    }
    
    interface Model{

        void logOutUser();
        void writeRTDatabase();
        void writeRTDataSuccessful();
        void dataChange(String value);
        void failedReadRT();
        boolean isUserLoged();
        String sendUserEmail();
        void updateChild(String child);
        void removeChild(String child);
    }
}
