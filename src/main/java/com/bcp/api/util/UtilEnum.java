package com.bcp.api.util;

public class UtilEnum {
   
    public static enum RESULT_MESSAGE{
        OK("Ok"),
        EMPTY("No se han encontrado resultados"),
        ERROR("A ocurrido un error"),
        ;
        private final String value;
        private RESULT_MESSAGE(String value){
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public static enum RESULT_CODE{
        OK(1),
        EMPTY(0),
        ERROR(-1),
        EXCEPTION(10),
        ;
        private final int codigo;
        private RESULT_CODE(int estado){
            this.codigo = estado;
        }
        public int getCode() {
            return codigo;
        }
    }
}
