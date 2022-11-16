import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Pessoa {
    private String nome;
	private LocalDate dataNascimento;

    private final static String FormatoData = "dd/mm/aaaa";

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static String DataValida(String strDate) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FormatoData).withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return "Data válida";
        } catch (DateTimeException e) {
            return "Data inválida";
        }
    }
}
