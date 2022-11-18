import java.math.BigDecimal;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, String dataNascimento, String salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = new BigDecimal(salario);
        this.funcao = funcao;
        System.out.println(this.toString());
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public double getSalarioDouble() {
		return (this.salario).doubleValue();
	}

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void aumentoSalario(float porcentagem) {
        BigDecimal porc = new BigDecimal(String.valueOf(porcentagem/100));
        BigDecimal aumento = this.salario.multiply(porc);
        this.salario = this.salario.add(aumento);
    }
}
