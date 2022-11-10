package ch.zli.m223.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Rolle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String rollenname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRollenname() {
        return rollenname;
    }

    public void setRollenname(String rollenname) {
        this.rollenname = rollenname;
    }
}
