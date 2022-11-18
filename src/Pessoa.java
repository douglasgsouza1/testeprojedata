import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    private final static String FormatoData = "dd/MM/uuuu";

    public Pessoa(String nome, String dataNascimento) {
        this.nome = nome;
        this.dataNascimento = this.converterDate(dataNascimento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = this.converterDate(dataNascimento);
    }

    private LocalDate converterDate(String strData) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(FormatoData);
        LocalDate data = LocalDate.parse(strData, formato);
        return data;
    }

}
