package Model;

public class SessionModel {
    String userId;
    String projectId;
    String columnId;

    public SessionModel(String userId, String projectId, String columnId) {
        this.userId = userId;
        this.projectId = projectId;
        this.columnId = columnId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }
}
