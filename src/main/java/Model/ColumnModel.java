package Model;

public class ColumnModel {


    private final Integer id;
    private final String columnName;
    private final Integer status;
    private final Integer projectId;


    public ColumnModel(Integer id, String columntName, Integer status, Integer projectId) {
        this.id = id;
        this.columnName = columntName;
        this.status = status;
        this.projectId = projectId;
    }

    public Integer getId() {
        return id;
    }

    public String getColumnName() {
        return columnName;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getProjectId() {
        return projectId;
    }
}
