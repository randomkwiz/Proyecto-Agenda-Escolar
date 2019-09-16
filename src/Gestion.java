import java.sql.*;

public class Gestion {

    /*
     * INTERFAZ
     * Comentario: Inserta un objeto Nota en la BBDD del programa.
     * Signatura: public boolean insertarNotaEnBBDD(NotaImpl nota)
     * Precondiciones:
     * Entradas: objeto de tipo NotaImpl
     * Salidas: un boolean
     * Postcondiciones: asociado al nombre devuelve un boolean que sera true si la nota se ha insertado correctamente
     *                   y false si ha habido algun problema. Si el objeto nota pasado como parametro de entrada
     *                  no estuviera bien construido o fuera nulo, saltaria excepcion.
     * */
    public boolean insertarNotaEnBBDD(NotaImpl nota) {
        boolean exito = false;
        try {

            // Define la fuente de datos para el driver
            String sourceURL = "jdbc:sqlserver://localhost";
            String usuario = "agendaEscolar";
            String password = "agendaEscolar";
            String miSelect = "INSERT INTO NOTA (USUARIO, MODULO, CALIFICACION, FECHA, OBSERVACIONES) " +
                    "VALUES" + "(?,?,?,?,?)";

            //Mas info sobre Prepared Statement: https://www.arquitecturajava.com/jdbc-prepared-statement-y-su-manejo/

            // Crear una conexion con el DriverManager

            Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);
            //Preparo el prepared statement indicando que son cada ? del select
            PreparedStatement preparedStatement = connexionBaseDatos.prepareStatement(miSelect);
            preparedStatement.setString(1, nota.getNombreUsuario());
            preparedStatement.setString(2, nota.getNombreModulo());
            preparedStatement.setDouble(3, nota.getCalificacion());
            if (nota.getFecha() != null) {
                preparedStatement.setDate(4, new java.sql.Date(nota.getFecha().getTimeInMillis()));
            } else {
                preparedStatement.setDate(4, null);
            }
            preparedStatement.setString(5, nota.getObservaciones());
            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            exito = true;


            // Cerrar
            preparedStatement.close();
            connexionBaseDatos.close();


        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return exito;
    }


}
