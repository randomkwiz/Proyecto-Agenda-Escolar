import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Validar {
    /*
    INTERFAZ
     */
    public NotaImpl pedirValidarNota(){
        UsuarioImpl usuario = pedirValidarNombreUsuario();
        Modulo modulo = pedirValidarModulo();
        double calificacion = pedirValidarCalificacion();
        String observaciones = pedirObservaciones();
        GregorianCalendar fecha = pedirValidarFecha();

        NotaImpl nota = new NotaImpl(usuario,modulo,calificacion,observaciones,fecha);
        return nota;
    }

    public UsuarioImpl pedirValidarNombreUsuario(){
        //TODO hacer este metodo

        return new UsuarioImpl("Angela V");
    }


    /*
     * INTERFAZ
     * Comentario: muestra en pantalla, pide y valida la opcion de una lista de valores de un enum
     * Signatura:  public Modulo pedirValidarModulo()
     * Precondiciones:
     * Entradas:
     * Salidas: el enum elegido por el usuario
     * Postcondiciones: asociado al nombre se devuelve el enum elegido por el usuario
     *
     * */
    public Modulo pedirValidarModulo() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        Modulo value = Modulo.NULL;
        try {

            do {
                for (int i = 1; i < Modulo.values().length; i++) {
                    System.out.println(i + ". " + Modulo.values()[i]);
                }
                System.out.println("-------------------------------------------------------------------------------");

                opcion = sc.nextInt();
            } while (opcion < 0 || opcion >= Modulo.values().length);
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }

        if (opcion != 0) {
            for (int i = 1; i < Modulo.values().length; i++) {
                if (Modulo.values()[i].ordinal() == opcion) {
                    value = Modulo.values()[i];
                }
            }

        }
        System.out.println("El modulo elegido es: " + value.name());


        return value;
    }





    public double pedirValidarCalificacion(){
        Scanner sc = new Scanner(System.in);
        double nota = 0;
        do {
            System.out.println("Introduce calificación (0-10): ");
            nota = sc.nextDouble();
        }while (nota < 0 || nota > 10);
        return nota;
    }

    public String pedirObservaciones(){
        Scanner sc = new Scanner(System.in);
        String observaciones = " ";
        System.out.println("Introduce observaciones: ");
        observaciones = sc.nextLine();
        return observaciones;
    }


    /*
     * INTERFAZ
     * Signatura: public GregorianCalendar pedirFechaInicioCiclo()
     * Comentario: pide y valida una fecha, o devuelve la fecha actual si el usuario no desea establecer otra fecha.
     * Precondiciones:
     * Entradas:
     * Salidas: fecha GregorianCalendar
     * Postcondiciones: Asociado al nombre devuelve una fecha valida o devuelve la fecha actual si el usuario no desea establecer otra fecha.
     * */
    public GregorianCalendar pedirValidarFecha() {
        GregorianCalendar fecha = new GregorianCalendar();
        GregorianCalendar fechaCorrecta = new GregorianCalendar();
        Scanner sc = new Scanner(System.in);
        int dia, mes, anyo;
        try {
            do {
                do {
                    System.out.println("Introduce 0 en los tres campos para establecer la fecha por defecto (actual)");
                    System.out.print("Dia: ");
                    dia = sc.nextInt();
                    System.out.print("Mes: ");
                    mes = sc.nextInt();
                    System.out.print("Año: ");
                    anyo = sc.nextInt();

                    fechaCorrecta.set(GregorianCalendar.YEAR, anyo);
                    fechaCorrecta.set(GregorianCalendar.MONTH, mes - 1);    //va de 0 a 11
                    fechaCorrecta.set(GregorianCalendar.DATE, dia);

                } while (fechaCorrecta.get(Calendar.YEAR) != anyo ||
                        fechaCorrecta.get(Calendar.MONTH) != (mes-1) ||
                        fechaCorrecta.get(Calendar.DAY_OF_MONTH) != dia)
                ;

                if (dia != 0 && mes != 0 && anyo != 0) {
                    fechaCorrecta.set(GregorianCalendar.YEAR, anyo);
                    fechaCorrecta.set(GregorianCalendar.MONTH, mes - 1);    //va de 0 a 11
                    fechaCorrecta.set(GregorianCalendar.DATE, dia);
                }
            } while (fecha.after(new GregorianCalendar()));
        } catch (InputMismatchException e) {
            System.out.println("Opcion no contemplada");
        }


        return fecha;

    }

}
