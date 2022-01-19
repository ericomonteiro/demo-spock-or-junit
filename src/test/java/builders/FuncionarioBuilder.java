package builders;

import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class FuncionarioBuilder {
    private String nome;
    private LocalDate dataAdmissao;
    private BigDecimal salario;

    private FuncionarioBuilder() {
    }

    public static FuncionarioBuilder aFuncionario() {
        return new FuncionarioBuilder();
    }

    public FuncionarioBuilder withNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FuncionarioBuilder withDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
        return this;
    }

    public FuncionarioBuilder withSalario(BigDecimal salario) {
        this.salario = salario;
        return this;
    }

    public Funcionario build() {
        return new Funcionario(nome, dataAdmissao, salario);
    }
}
