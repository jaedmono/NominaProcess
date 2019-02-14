package com.smartservice.nomina.process.util;

public enum TypeContract {
    TERMINO_INDEFINIDO(1),
    OBRA_O_LABOR(2),
    POR_HORAS(3),
    SALARIO_INTEGRAL(4);

    private int type;

    private TypeContract(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
