/*
* Analisis Programa
* Programa Agenda Escolar básico. Sirve para introducir manualmente
* mis notas de 2º CFGS DAM y que se guarden en una base de datos.
* Más adelante se ampliará para que sea una app completamente funcional con login y
* otras funcionalidades como el horario.
* */

/*
PSEUDO CODIGO
inicio
    pedirValidarUsuarioRegistradoCuentaNueva
    si es cuenta nueva
        crearCuentaNueva
    sino
        repetir
            iniciarSesion
            mostrarMenuPedirValidarOpcionMenu
            si opcion no es salir
                segun opcion menu
                    caso 1: ver notas
                    caso 2: introducir nota
                    caso 3: eliminar nota
                fin segun
            fin si
        mientras(opcion no sea salir)
    fin si
fin
 */
public class main {
    public static void main(String[] args) {
        boolean isCuentaNueva = false;
        int opcion = 0, int opcionMenu = 0;

        //pedirValidarUsuarioRegistradoCuentaNueva

        if (isCuentaNueva){
            //crearCuentaNueva
        }else{
            do{
                //iniciarSesion
                //mostrarMenuPedirValidarOpcionMenu

                if (opcion != 0 ){
                    switch (opcionMenu){
                        case 1:
                            //verNotas
                            break;
                        case 2:
                            //introducirNota
                            break;
                        case 3:
                            //eliminarNota
                            break;
                    }

                }
            }while(opcion != 0);

        }
    }
}
