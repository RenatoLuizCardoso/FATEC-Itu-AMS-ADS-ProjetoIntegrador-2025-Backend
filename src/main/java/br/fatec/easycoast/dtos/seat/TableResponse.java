package br.fatec.easycoast.dtos.seat;

public class TableResponse {
    private Integer id;
    private TableStatus status;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TableStatus getStatus() {
        return status;
    }

    public void setStatus(TableStatus status) {
        this.status = status;
    }
}
