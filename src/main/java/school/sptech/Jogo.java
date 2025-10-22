package school.sptech;

import school.sptech.exception.JogoInvalidoException;

import java.time.LocalDate;

public class Jogo {
    private String codigo;
    private String nome;
    private String genero;
    private Double preco;
    private Double avaliacao;
    private LocalDate dataLancamento;

    public Jogo() {
    }

    public String getAvaliacaoDescricao(){
        if (avaliacao >= 4.5){
            return "EXCELENTE";
        } else if (avaliacao >= 3.5) {
            return "BOM";
        } else if (avaliacao >= 2.5) {
            return "REGULAR";
        }

        return "RUIM";
    }

    public String getCodigo() {
        return codigo;
    }

    public Jogo setCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Jogo setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public Jogo setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public Double getPreco() {
        return preco;
    }

    public Jogo setPreco(Double preco) {
        this.preco = preco;
        return this;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public Jogo setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
        return this;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public Jogo setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

}
