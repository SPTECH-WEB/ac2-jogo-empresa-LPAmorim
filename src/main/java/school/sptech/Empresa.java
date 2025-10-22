package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.JogoInvalidoException;
import school.sptech.exception.JogoNaoEncontradoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Jogo> jogos = new ArrayList<>();

    public Empresa() {
    }

    public void adicionarJogo(Jogo jogo) throws JogoInvalidoException {
        if (jogo == null){
            throw new JogoInvalidoException("Valor de jogo invalido!");
        } else if (jogo.getCodigo() == null || jogo.getCodigo().isEmpty()){
            throw new JogoInvalidoException("Código do jogo invalido!");
        } else  if (jogo.getNome() == null || jogo.getNome().isEmpty()){
            throw new JogoInvalidoException("Nome do jogo invalido!");
        } else if (jogo.getGenero() == null || jogo.getGenero().isEmpty()){
            throw new JogoInvalidoException("Gênero do jogo invalido!");
        } else if (jogo.getPreco() == null || jogo.getPreco() <= 0 ){
            throw new JogoInvalidoException("Preço do jogo invalido!");
        } else if (jogo.getAvaliacao() == null || jogo.getAvaliacao() < 0
                || jogo.getAvaliacao() > 5){
            throw new JogoInvalidoException("Avaliação do jogo invalido!");
        } else if (jogo.getDataLancamento() == null ||
                jogo.getDataLancamento().isAfter(LocalDate.now()) ) {
            throw new JogoInvalidoException("Nome do jogo invalido!");
        }

        jogos.add(jogo);
    }

    public Jogo buscarJogoPorCodigo(String codigo)
            throws JogoNaoEncontradoException, ArgumentoInvalidoException {
        if (codigo == null || codigo.isEmpty()){
            throw new ArgumentoInvalidoException();
        }

        for (Jogo j : jogos){
            if (j.getCodigo().equalsIgnoreCase(codigo)){
                return j;
            }
        }

        throw new JogoNaoEncontradoException("Jogo não encontrado");
    }

    public void removerJogoPorCodigo(String codigo)
            throws ArgumentoInvalidoException, JogoNaoEncontradoException
    {
        if (codigo == null || codigo.isEmpty()){
            throw new ArgumentoInvalidoException();
        } else if (jogos == null || jogos.isEmpty()){
            throw new ArgumentoInvalidoException();
        }

        int contadorBefore = jogos.size();
        for (int i = 0; i < jogos.size(); i++){
            if (jogos.get(i).getCodigo().equalsIgnoreCase(codigo)){
                jogos.remove(i);
            }
        }

        int contadorAfter = jogos.size();
        if (contadorBefore == contadorAfter){
            throw new JogoNaoEncontradoException();
        }
    }

    public Jogo buscarJogoComMelhorAvaliacao()
            throws JogoNaoEncontradoException
    {
        if (jogos.isEmpty()){
            throw new JogoNaoEncontradoException("Jogo não encontrado");
        }

        List<Jogo> jogosMelhoresAvaliados = new ArrayList<>();

        double maiorAvaliacao = jogos.get(0).getAvaliacao();
        for (Jogo j : jogos){
            if (j.getAvaliacao() >= maiorAvaliacao){
                maiorAvaliacao = j.getAvaliacao();
                jogosMelhoresAvaliados.add(j);
            }
        }

        Jogo jogoMelhorAvaliado = jogosMelhoresAvaliados.get(0);
        LocalDate jogoMaisRecente = jogoMelhorAvaliado.getDataLancamento();
        if (jogosMelhoresAvaliados.size() > 1){
            for (Jogo j : jogosMelhoresAvaliados){
                if (j.getDataLancamento().isAfter(jogoMaisRecente)){
                    jogoMelhorAvaliado = j;
                }
            }
        }

        return jogoMelhorAvaliado;
    }

    public List<Jogo> buscarJogoPorPeriodo
            (LocalDate dataInicio, LocalDate dataFim)
            throws ArgumentoInvalidoException {
        if (dataInicio == null || dataFim == null ||
                dataFim.isBefore(LocalDate.now()) ||
                dataInicio.isBefore(LocalDate.now())
        ){
            throw new ArgumentoInvalidoException("Datas inseridas invalidas");
        }


        List<Jogo> listaDeJogos = new ArrayList<>();
        for (Jogo j : jogos){
            if (j.getDataLancamento().isAfter(dataInicio)
                    && j.getDataLancamento().isBefore(dataFim)) {
                listaDeJogos.add(j);
            }
        }

        return listaDeJogos;
    }

    public List<Jogo> getJogos() {
        return jogos;
    }

    public String getNome() {
        return nome;
    }

    public Empresa setNome(String nome) {
        this.nome = nome;
        return this;
    }

}
