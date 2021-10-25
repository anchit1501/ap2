package Model;

public class TaskModel {
    private Integer id;
    private String taskName;
    private String dueDate;
    private String completed;
    private String description;
    private Integer columnId;

    public TaskModel(Integer id, String taskName, String dueDate, String completed, String description, Integer columnId) {
        this.id = id;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.completed = completed;
        this.description = description;
        this.columnId = columnId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }
}
