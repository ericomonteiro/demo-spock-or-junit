package br.com.alura.tdd.service

import builders.FuncionarioBuilder
import spock.lang.Specification
import spock.lang.Unroll

class BonusServiceSpec extends Specification {

    def service = new BonusService()

    def "funcionarios com salario superior a RS 10.000,00 nao podem receber bonus"() {
        when: "o funcionario possui salario superior a 10001"
        def funcionarioSalarioAlto = FuncionarioBuilder.aFuncionario().withSalario(new BigDecimal(10001)).build()

        and: "tentamos calcular o bonus desse funcionario"
        service.calcularBonus(funcionarioSalarioAlto)

        then: "uma excecao deve ser lancada impedindo que o bonus seja calculada"
        def ex = thrown(IllegalArgumentException)

        and: "a excecao deve conter uma mensagem informando o motivo do erro correto"
        ex.getMessage() == "Funcionario com salario maior do que R\$10000 nao pode receber bonus!"
    }

    @Unroll
    def "funcionario com salario #salario o bonus deve ser #bonusEsperado"() {
        when: "o funcionario possui salario igual a #salario"
        def funcionario = FuncionarioBuilder.aFuncionario().withSalario(new BigDecimal(salario)).build()

        and: "tentamos calcular o bonus desse funcionario"
        def bonus = service.calcularBonus(funcionario)

        then: "nenhuma excecao deve ser lancada"
        noExceptionThrown()

        and: "o bonus deve ser igual a #bonusExpected"
        bonus == bonusEsperado

        where:
        salario       << [2500, 10000]
        bonusEsperado << [250, 1000]
    }

}
