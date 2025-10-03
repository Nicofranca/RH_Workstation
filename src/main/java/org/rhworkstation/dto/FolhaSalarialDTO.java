package org.rhworkstation.dto;

import java.time.LocalDate;

public record FolhaSalarialDTO(String nome, String cpf, double salarioBruto, double inss,double salarioLiquido,LocalDate dataFolhaSalarial) {
}
