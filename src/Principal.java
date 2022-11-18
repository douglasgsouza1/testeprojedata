import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import java.util.HashMap;

public class Principal {

        private static ArrayList<Funcionario> funcionarios = new ArrayList<>();

        public static void addTabela() {
                System.out.println(
                                "Inserindo os dados...");

                String[] nomes = { "Maria", "João", "Caio", "Miguel", "Alice", "Heitor", "Arthur", "Laura",
                                "Heloísa", "Helena" };

                String[] datas = { "18/10/2000", "12/05/1990", "02/05/1961", "14/10/1988", "05/01/1995",
                                "19/11/1999", "31/03/1993", "08/07/1994", "24/05/2003", "02/09/1996" };

                String[] salarios = { "2009.44", "2284.38", "9836.14", "19119.88", "2234.68", "1582.72", "4071.84",
                                "3017.45", "1606.85", "2799.93" };

                String[] funcoes = { "Operador", "Operador", "Coordenador", "Diretor", "Recepcionista",
                                "Operador", "Contador", "Gerente", "Eletricista", "Gerente" };

                try {
                        for (int i = 0; i < nomes.length; i++) {
                                Funcionario funcionario = new Funcionario(nomes[i], datas[i], salarios[i],
                                                funcoes[i]);
                                funcionarios.add(funcionario);
                        }
                        System.out.println("Inclusão realizada com sucesso.");

                } catch (Exception e) {
                        System.out.println("Erro na inclusão.");
                }

        }

        public static void RemoveFunc(String nome) {
                System.out.println("Removendo o funcionário João.");
                for (int i = 0; i < funcionarios.size(); i++) {
                        Funcionario func = funcionarios.get(i);
                        if (func.getNome().equalsIgnoreCase(nome)) {
                                funcionarios.remove(func);
                                System.out.println("Funcionário removido com sucesso.");
                        }
                }
        }

        public static void ImprimeDados() {
                System.out.println("Imprimindo os dados.");
                System.out.printf("%7s %20s %15s %17s", "NOME", "DATA NASCIMENTO", "SALARIO", "FUNÇÃO");
                System.out.println();
                for (Funcionario funcionario : funcionarios) {
                        System.out.printf("%7s %20s %15s %17s", funcionario.getNome(),
                                        formatarData(funcionario.getDataNascimento()),
                                        formatarSalario(funcionario.getSalario()),
                                        funcionario.getFuncao());
                        System.out.println();
                }
        }

        private static String formatarData(LocalDate data) {
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                return formato.format(data);
        }

        private static String formatarSalario(BigDecimal salario) {
                DecimalFormat df = new DecimalFormat(",###.##");
                return df.format(salario);
        }

        private static void AumentoSalario(float porcentagem) {
                for (Funcionario funcionario : funcionarios) {
                        funcionario.aumentoSalario(porcentagem);
                }
                System.out.println("Mostrando tabela com novos valores.");
                ImprimeDados();
        }

        private static void AgrupandoTabela() {
                Map<String, ArrayList<String>> ordenarFunc = new HashMap<>();
                for (Funcionario funcionario : funcionarios) {
                        if (ordenarFunc.get(funcionario.getFuncao()) == null) {
                                ArrayList<String> nomes = new ArrayList<>();
                                nomes.add(funcionario.getNome());
                                ordenarFunc.put(funcionario.getFuncao(), nomes);
                        } else {
                                ArrayList<String> nomes = ordenarFunc.get(funcionario.getFuncao());
                                nomes.add(funcionario.getNome());
                                ordenarFunc.put(funcionario.getFuncao(), nomes);
                        }
                }
                System.out.println(ordenarFunc);
        }

        private static void Aniversario(int mes) {
                Map<Integer, String> mesesAno = new HashMap<>();

                int[] meses = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
                String[] nomeMeses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto",
                                "Setembro", "Outubro", "Novembro", "Dezembro" };

                for (int i = 0; i < meses.length; i++) {
                        mesesAno.put(meses[i], nomeMeses[i]);
                }

                System.out.printf("Aniversários no mês de %s: ", mesesAno.get(mes));

                ArrayList<String> aniversariantes = new ArrayList<>();

                for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getDataNascimento().getMonthValue() == mes) {
                                aniversariantes.add(funcionario.getNome());
                        }
                }

                System.out.println(aniversariantes.toString());
        }

        private static void MaiorIdade() {
                Funcionario maisVelho = funcionarios.get(0);
                for (Funcionario funcionario : funcionarios) {
                        if (funcionario.getDataNascimento().isBefore(maisVelho.getDataNascimento())) {
                                maisVelho = funcionario;
                        }
                }
                String nome = maisVelho.getNome();
                LocalDate dataNascimento = maisVelho.getDataNascimento();

                LocalDate agora = LocalDate.now();
                int idade = agora.compareTo(dataNascimento);

                System.out.printf("Nome: %s, Idade: %s anos.\n", nome, idade);
        }

        public static void OrdemAlfabetica() {
                ArrayList<String> nomes = new ArrayList<>();
                for (Funcionario funcionario: funcionarios) {
                        nomes.add(funcionario.getNome());
                }
                nomes.sort(null);
                System.out.println(nomes);
        }

        public static void TotalSalario() {
                BigDecimal soma = new BigDecimal("0");
                for (Funcionario funcionario: funcionarios) {
                        soma = soma.add(funcionario.getSalario());
                }
                System.out.println("Soma de todos os salários R$ " + formatarSalario(soma));
        }

        private static void SalarioMinimo() {
                double ValorSM = 1212.00;
                for (Funcionario funcionario: funcionarios) {
                    System.out.printf("Nome: %s - Quantidade de Salário Mínimos: %.2f", funcionario.getNome(), funcionario.getSalarioDouble()/ValorSM);
                    System.out.println();
                }
        }

        public static void main(String[] args) {
                System.out.println("3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela.");
                addTabela();

                System.out.println("3.2 – Remover o funcionário 'João' da lista.");
                RemoveFunc("João");

                System.out.println("3.3 – Imprimir todos os funcionários com todas suas informações.");
                ImprimeDados();

                System.out.println(
                                "3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.");
                AumentoSalario(10);

                System.out.println(
                                "3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a 'função' e o valor a 'lista de funcionários'");
                AgrupandoTabela();

                System.out.println("3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.");
                Aniversario(10);
                Aniversario(12);

                System.out.println(
                                "3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.");
                MaiorIdade();

                System.out.println("3.10 – Imprimir a lista de funcionários por ordem alfabética.");
                OrdemAlfabetica();

                System.out.println("3.11 – Imprimir o total dos salários dos funcionários.");
                TotalSalario();

                System.out.println("3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.");
                SalarioMinimo();
        }
}
