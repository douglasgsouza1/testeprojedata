import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Pessoa {
    private String nome;
	private LocalDate dataNascimento;

    private final static String FormatoData = "dd/mm/aaaa";

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }


    public static String DataValida(String strDate) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FormatoData).withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate.parse(strDate, dateTimeFormatter);
            return "Data válida";
        } catch (DateTimeException e) {
            return "Data inválida";
        }
    }

    @Override
  public String toString() {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern(FormatoData);
    return "Nome: " + this.nome + ", Data Nascimento: " + formato.format(this.dataNascimento);  
  }
}
