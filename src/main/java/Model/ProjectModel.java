package Model;

public class ProjectModel {


    private Integer id;
    private String projectName;
    private Integer status;
    private Integer userId;


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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
