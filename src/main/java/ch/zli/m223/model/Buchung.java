package ch.zli.m223.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Buchung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime buchungszeit;

    @Column(nullable = false)
    private long zimmernummer;

    @Column(nullable = false)
    private boolean vollerTag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    

    public long getZimmernummer() {
        return zimmernummer;
    }

    public void setZimmernummer(long zimmernummer) {
        this.zimmernummer = zimmernummer;
    }

    public boolean isVollerTag() {
        return vollerTag;
    }

    public void setVollerTag(boolean vollerTag) {
        this.vollerTag = vollerTag;
    }

    public LocalDateTime getBuchungszeit() {
        return buchungszeit;
    }

    public void setBuchungszeit(LocalDateTime buchungszeit) {
        this.buchungszeit = buchungszeit;
    }
    
    
}
