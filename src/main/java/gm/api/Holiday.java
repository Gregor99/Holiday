package gm.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by Gregor on 6. 07. 2016.
 */

@Entity
@Table(name = "holiday")
@NamedQueries({
        @NamedQuery(name = "findAll",
        query = "select h from Holiday h")
})
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_holiday")
    private Integer idHoliday;

    @Column(name = "id_user")
    private Integer idUser;

    public Holiday() {}

    public Holiday(Integer idHoliday, Integer idUser) {
        this.idHoliday = idHoliday;
        this.idUser = idUser;
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
}
