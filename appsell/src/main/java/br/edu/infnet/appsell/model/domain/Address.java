package br.edu.infnet.appsell.model.domain;

import javax.persistence.*;

@Entity
@Table(name = "adresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cep;
    /**
     * For compatibility reasons, the next properties must be in portuguese
     */
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public Address() {}

    public Address(String cep) {
        this();
        this.setCep(cep);
    }

    @Override
    public String toString() {
        return String.format("CEP (%s) - neighborhood (%s) - UF (%s)", cep, bairro, uf);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getLocalidade() {
        return localidade;
    }
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    public String getUf() {
        return uf;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }
}
