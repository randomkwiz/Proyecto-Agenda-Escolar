import java.util.GregorianCalendar;

public class TestGestion {
    public static void main(String[] args) {
        UsuarioImpl usuario = new UsuarioImpl("Angela V");
        NotaImpl nota = new NotaImpl(usuario, Modulo.SISTEMAS_GESTION_EMPRESARIAL, 0.0, "Tema 1", new GregorianCalendar());
        Gestion gestion = new Gestion();

        gestion.insertarNotaEnBBDD(nota);

    }
}
