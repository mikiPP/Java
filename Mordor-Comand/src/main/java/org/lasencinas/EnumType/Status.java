package org.lasencinas.EnumType;

public  enum  Status {

    ACEPTADO ("ACEPTADO"),
    RECHAZADO ("RECHAZADO");


    private String status = null;

     private Status(String status){
         this.status = status;
     }

    public String getStatus() {
        return this.status;
    }
}
