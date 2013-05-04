/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guiatour.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Carlos
 */
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id_pessoa", nullable = false)
    private Long IdPessoa;
    @Column(name="nome", nullable = false, length = 80)
    private String nome;
    @Column(name="email", nullable = false, length = 100)
    private String email;
    @Column(name="data_cad")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataCad;
    @Column(name="data_nasc")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dataNasc;
    
    
}
