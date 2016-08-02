package gm.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Created by Gregor on 6. 07. 2016.
 */

@Entity
@Table(name = "holiday")
@NamedQueries({
        @NamedQuery(name = "findAll",
        query = "select h from Holiday h"),

        @NamedQuery(name = "findByUser",
        query = "select h from Holiday h where idUser = :idUser")
})
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_holiday")
    private Integer idHoliday;

    @Column(name = "id_user")
    private Integer idUser;



    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public Holiday() {}

    public Holiday(Integer idHoliday) {
        this.idHoliday = idHoliday;
    }

    public Holiday(Integer idHoliday, Integer idUser, LocalDate startDate, LocalDate endDate) {
        this.idHoliday = idHoliday;
        this.idUser = idUser;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @JsonProperty
    public Integer getIdHoliday() {
        return this.idHoliday;
    }

    @JsonProperty
    public void setIdHoliday(Integer idHoliday) {
        this.idHoliday = idHoliday;
    }

    @JsonProperty
    public Integer getIdUser() {
        return this.idUser;
    }

    @JsonProperty
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @JsonProperty
    public LocalDate getStartDate() { return this.startDate; }

    @JsonProperty
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    @JsonProperty
    public LocalDate getEndDate() { return this.endDate; }

    @JsonProperty
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
