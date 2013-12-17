package com.platacad.model.entities;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class AuditLogger {

    @PrePersist
    public void prePresist(Auditable auditable){
    	auditable.prePresist();
    }
    
    @PreUpdate
    public void preUpdate(Auditable auditable){
    	auditable.preUpdate();
    }

}