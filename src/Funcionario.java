import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, String salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = new BigDecimal(salario);
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/mm/aaaa");
        String salarioStr = String.valueOf(this.getSalario());
        double salarioLong = Double.valueOf(salarioStr);
        DecimalFormat df = new DecimalFormat(",###.##");

        return "Nome: " + this.getNome() + ", Data Nascimento: "
                + formato.format(this.getDataNascimento()) + ", Salário: " + df.format(salarioLong)
                + ", Função: " + this.getFuncao();
    }
}
