package com.smartservice.nomina.process.model;

import javax.persistence.*;

@Entity
@Table(name = "preference", schema = "public")
public class Preference {

    @Id
    @Column(name = "id_preference")
    @SequenceGenerator(name="preference_id_preference_seq", sequenceName="preference_id_preference_seq",allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="preference_id_preference_seq")
    private long idPreference;

    @Column(name = "description_preference")
    private String description;

    @Column(name = "value")
    private String value;

    public long getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(long idPreference) {
        this.idPreference = idPreference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
