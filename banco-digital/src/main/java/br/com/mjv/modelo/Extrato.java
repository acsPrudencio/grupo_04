package br.com.mjv.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class Extrato {
    String extrato;
    LocalDateTime data;

}
