package br.fatec.easycoast.dtos.seat;

public class SeatResponse {
    private Integer id;
    private SeatStatus status;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
