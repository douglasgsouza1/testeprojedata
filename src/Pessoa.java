import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Pessoa {
    private String nome;
	private LocalDate dataNascimento;

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

    public static boolean DataValida(String strDate) {
        String FormatoData = "dd/mm/aaaa";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FormatoData).withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }
}
