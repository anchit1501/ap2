package Model;

public class ProjectModel {


    private final Integer id;
    private final String projectName;
    private final Integer status;
    private final Integer userId;


    public ProjectModel(Integer id, String projectName, Integer status, Integer userId) {
        this.id = id;
        this.projectName = projectName;
        this.status = status;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getUserId() {
        return userId;
    }
}
