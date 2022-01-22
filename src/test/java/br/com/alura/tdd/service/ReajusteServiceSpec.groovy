package br.com.alura.tdd.service

import br.com.alura.tdd.modelo.Desempenho
import builders.FuncionarioBuilder
import spock.lang.Specification
import spock.lang.Unroll

class ReajusteServiceSpec extends Specification {

    def service = new ReajusteService()
    def funcionario = FuncionarioBuilder.aFuncionario().withSalario(new BigDecimal(2000)).build()

    @Unroll
    def "funcionario com salario de 2000 e desempenho #desempenho deve ter o salario reajustudo para #salarioNovo"() {
        given: "reajuste"
        service.concederReajuste(funcionario, desempenho)

        expect: "salario reajustudo deve ser igual ao #salarioNovo"
        funcionario.getSalario().equals(salarioNovo)

        where:
            desempenho          | salarioNovo
            Desempenho.A_DESEJAR|new BigDecimal("2060.00")
            Desempenho.BOM      |new BigDecimal("2300.00")
            Desempenho.OTIMO    |new BigDecimal("2400.00")
    }

}
