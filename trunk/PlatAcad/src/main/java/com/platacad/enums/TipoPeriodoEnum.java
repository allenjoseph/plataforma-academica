package com.platacad.enums;

public enum TipoPeriodoEnum {
	IMPAR(3,"PERIODO I"),
	PAR(4,"PERIODO II");
	
	private final int id;
    private final String descripcion;
    
    private TipoPeriodoEnum(int id, String descripcion) {   
         this.id = id;
         this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }    
    
    public static TipoPeriodoEnum obtenerEnum(int id){
        switch(id){
            case 3:
                return IMPAR;
            case 4:
                return PAR;
            default:
            	return IMPAR;
        }           
    }
}
