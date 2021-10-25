package Utils;

import java.util.HashSet;
import java.util.Set;

public final class UserSession {

    private static UserSession instance = new UserSession(null,null,null,null);

    public String userName;
    public String userId;
    public String activeProject;
    public String activeColumn;

    private UserSession(String userName, String userId, String activeProject, String activeColumn) {
        this.userName = userName;
        this.userId = userId;
        this.activeProject = activeProject;
        this.activeColumn = activeColumn;
    }

    public static UserSession getInstance() {
        return instance;
    }

    public static void setInstance(UserSession instance) {
        UserSession.instance = instance;
    }

    public static void putUserDetails(String userName, String userId){
        instance.setUserId(userId);
        instance.setUserName(userName);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActiveProject() {
        return activeProject;
    }

    public void setActiveProject(String activeProject) {
        this.activeProject = activeProject;
    }

    public String getActiveColumn() {
        return activeColumn;
    }

    public void setActiveColumn(String activeColumn) {
        this.activeColumn = activeColumn;
    }

    public void cleanUserSession() {
        userName = "";
        userId = "";
        activeProject = "";
        activeColumn = "";
    }

//    @Override
//    public String toString() {
//        return "UserSession{" +
//                "userName='" + userName + '\'' +
//                ", privileges=" + privileges +
//                '}';
//    }
}
