package Vista;

import BaseDatos.IBaseDatos;
import BaseDatos.LugarParqueoDao;
import BaseDatos.PropietarioDao;
import BaseDatos.ServicioDao;
import BaseDatos.TarifaDao;
import BaseDatos.VehiculoDao;
import controlador.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Parqueadero {

    private static ControladorLugarParqueo ctrLugarParqueo;
    private static ControladorPropietario ctrPropietario;
    private static ControladorServicio ctrServicio;
    private static ControladorTarifa ctrTarifa;
    private static ControladorVehiculo ctrVehiculo;

    public Parqueadero() {
        IBaseDatos mLugarParqueo = new LugarParqueoDao();
        IBaseDatos mPropietario = new PropietarioDao();
        IBaseDatos mServicio = new ServicioDao();
        IBaseDatos mTarifa = new TarifaDao();
        IBaseDatos mVehiculo = new VehiculoDao();

        ctrLugarParqueo = new ControladorLugarParqueo(mLugarParqueo);
        ctrPropietario = new ControladorPropietario(mPropietario, mServicio);
        ctrServicio = new ControladorServicio(mServicio, mTarifa, mPropietario, mLugarParqueo);
        ctrTarifa = new ControladorTarifa(mTarifa);
        ctrVehiculo = new ControladorVehiculo(mVehiculo, mServicio, mPropietario);
    }

    public static void main(String[] args) {
        new Parqueadero();
        System.out.println("--------------------Parqueadero--------------------");
        int opcion = 0;

        do {
            System.out.println("\n1. Ingresar Vehiculo");
            System.out.println("2. Retirar Vehiculo");
            System.out.println("3. Consultar Vehiculo");
            System.out.println("4. Consultar Dueño");
            System.out.println("5. Consultar Fecha");
            System.out.println("6. Crear Tarifa");
            System.out.println("7. Cerrar Programa\n");

            System.out.print("Digite la opcion correspondiente al numeral: ");

            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            System.out.println("");
            
            String placa = null;
            String descripcion = null;
            String nombre = null;
            String correo = null;
            String subMenu = null;
            String sfecha = null;
            String sfecha2 = null;
            String shora = null;
            String shora2 = null;
            int ubicacion = 0;
            int valorMinuto = -1;
            boolean transaccion;
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDate fecha = null;
            LocalTime hora = null;
            LocalDate fecha2 = null;
            LocalTime hora2 = null;

            switch (opcion) {
                
                case 1:
                    System.out.print("Ingrese la placa del Vehiculo: ");
                    placa = sc.next();
                    System.out.print("\nIngrese una descripcion del vehiculo: ");
                    descripcion = sc.next();
                    System.out.print("\nIngrese el lugar de parqueo del vehiculo: ");
                    ubicacion = sc.nextInt();
                    transaccion = ingresarVehiculo(ubicacion, placa, descripcion);
                    if (transaccion) {
                        System.out.println("\nEl vehiculo se registro exitosamente!\n");
                    }else{
                        System.out.println("\nNo se pudo registrar el vehiculo\n");
                    }
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    break;
                
                case 2:
                    System.out.print("Ingrese la placa del Vehiculo a retirar: ");
                    placa = sc.next();
                    System.out.print("\nDesea agregar datos de propietario (si=Y, no=N): ");
                    subMenu = sc.next();
                    if (subMenu.equalsIgnoreCase("y")) {
                        System.out.print("\nDigite el nombre del propietario: ");
                        nombre = sc.next();
                        System.out.print("\nDigite un correo electronico");
                        correo = sc.next();
                        transaccion = registrarPropietario(nombre, correo);
                        if (transaccion) {
                            System.out.println("El Propietario se registro exitosamente!\n");
                        }else{
                            System.out.println("No se pudo registrar el propietario\n");
                        }
                    }
                    System.out.println("Valor servicio a cancelar: $"+retirarVehiculo(placa, correo));
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    break;
                
                case 3:
                    System.out.print("Ingrese la placa del Vehiculo a buscar: ");
                    placa = sc.next();
                    System.out.println("\n"+obtenerRegistrosVehiculo(placa));
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    break;
                
                case 4:
                    System.out.print("\nDigite un correo electronico: ");
                    correo = sc.next();
                    System.out.println("\n"+obtenerRegistrosPropietario(correo));
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    break;
                
                case 5:
                    System.out.print("Ingrese una Fecha: p.e("+LocalDate.now()+", yyyy-MM-dd) ");
                    sfecha = sc.next();
                    LocalDate ld = LocalDate.parse(sfecha);
                    System.out.println("\n"+obtenerRegistrosFecha(ld));
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    break;
                
                case 6:
                    System.out.print("Ingrese una fecha de inicio para la tarifa p.e (yyyy-MM-dd) ");
                    sfecha= sc.next();
                    fecha = LocalDate.parse(sfecha);
                    System.out.print("Ingrese una hora de inicio para la tarifa p.e (HH:mm:ss) ");
                    shora= sc.next();
                    hora = LocalTime.parse(shora);
                    System.out.print("\nIngrese una fecha de expiracion para la tarifa p.e (yyyy-MM-dd)");
                    sfecha2= sc.next();
                    fecha2 = LocalDate.parse(sfecha2);
                    System.out.print("Ingrese una hora de expiracion para la tarifa p.e (HH:mm:ss) ");
                    shora2= sc.next();
                    hora2 = LocalTime.parse(shora2);
                    System.out.print("\nDigite el valor por minuto de la tarifa: $");
                    valorMinuto = sc.nextInt();
                    System.out.print("\nIngrese el tipo de tarifa a crear: ");
                    descripcion = sc.next();
                    transaccion = crearTarifa(fecha, hora2, fecha, hora, opcion, correo);
                    if (transaccion) {
                        System.out.println("La tarifa se registro exitosamente!\n");
                    }else{
                        System.out.println("No se pudo registrar la tarifa\n");
                    }
                    System.out.println(".-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    break;

                default:
                    System.out.println("Digite un numero entre 1 y 7 de las opciones validas mostradas");
                    break;
            }

        } while (opcion != 7);
    }

    public static boolean ingresarVehiculo(int idLugarParqueo, String placa, String descripcion) {       
        boolean transaccion;
        boolean servicio=ctrServicio.CrearServicio(LocalDate.now(), LocalTime.now(), placa, idLugarParqueo);
        boolean estadoLP =ctrLugarParqueo.actualizarEstadoLugarParqueo(idLugarParqueo, 2);
        boolean registroV = ctrVehiculo.registrarVehiculo(placa, descripcion);
        if (servicio && estadoLP && registroV) {
            transaccion = false;
        }else{
            System.out.println("servicio "+servicio+" estadoLugarParqueo "+estadoLP+" registroVehiculo "+registroV);
            transaccion = true;
        }
        return transaccion;
    }

    public static double retirarVehiculo(String placa, String correo) {
        return ctrServicio.liquidarServicio(LocalDate.now(), placa, correo);
    }

    public static boolean registrarPropietario(String nombre, String correo) {
        return ctrPropietario.registrarPropietario(nombre, correo);
    }

    public static String buscarLugarParqueo(String placa) {
        return ctrServicio.obtenerLugarParqueo(placa);
    }

    public static String obtenerRegistrosPropietario(String correo) {
        return ctrPropietario.obtenerDatosPropietario(correo);
    }

    public static String obtenerRegistrosFecha(LocalDate fecha) {
        return ctrServicio.listarServicios(fecha).toString();
    }

    public static String obtenerRegistrosVehiculo(String placa) {
        return ctrVehiculo.obtenerDatosVehiculo(placa);
    }

    public static boolean crearTarifa(LocalDate inicio, LocalTime hInicio, LocalDate expira, LocalTime hExpira, int valor, String tipo) {
        return ctrTarifa.crearTarifa(inicio, hInicio, expira, hExpira, valor, tipo);
    }
}
