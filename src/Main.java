import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Data Início [dd/MM/yyyy]: ");
        String data1 = scan.nextLine();
        LocalDate dataInicio = LocalDate.parse(data1, dtf);

        System.out.print("Data Fim [dd/MM/yyyy]: ");
        String data2 = scan.nextLine();
        LocalDate dataFim = LocalDate.parse(data2, dtf);

        Long semanas = null;
        Long dias = null;
        Long aux = 0L;

        Long diasEntre = ChronoUnit.DAYS.between(dataInicio, dataFim);

        while(semanas == null && dias == null) {
            if(diasEntre % 7 != 0) {
                diasEntre -= 1;
                aux += 1;
            } else {
                semanas = diasEntre/7;
                dias = aux;
            }
        }

        String singularPlural;

        if(dias > 1) {
            singularPlural = " dias";
        } else {
            singularPlural = " dia";
        }

        System.out.println("Entre a data " + dataInicio.format(dtf) + " e a data " + dataFim.format(dtf) + " se passaram " + semanas + " semanas e " + dias + singularPlural);

        scan.close();
    }
}