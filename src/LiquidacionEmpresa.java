import java.util.ArrayList;
import java.util.Scanner;

public class LiquidacionEmpresa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //declarar "nivelesAcademicos" de tipo ArrayList<NivelAcademico>
        ArrayList<NivelAcademico> nivelAcademicos = new ArrayList<>();


        //como se debe hacer
        nivelAcademicos.add(new NivelAcademico(10, "Secundario Completo", 10));
        nivelAcademicos.add(new NivelAcademico(20, "Universitario Completo", 30));
        nivelAcademicos.add(new NivelAcademico(30, "Maestria Completo", 40));
        nivelAcademicos.add(new NivelAcademico(40, "Doctorado Completo", 50));

        //crear una instancia de la clase Empresa
        Empresa empresa = new Empresa();

        System.out.println("Ingrese datos de la empresa:  ");


        //validar antes de guardar cuit
        boolean validarCuit = false;

        while (!validarCuit) {

            System.out.println("Ingrese cuit de la empresa : ");
            String cuit = sc.nextLine();

            if (cuit.length() == 11) {
                validarCuit = true;
                empresa.setCuit(cuit);
            } else {
                System.out.println("el cuit debe tener 11 digitos, intente de nuevo");
            }
        }

        //crear para pedir de nuevo la razon social
        boolean validarRazonSocial = false;

        while (!validarRazonSocial) {
            System.out.println("Ingrese razon social de la empresa : : ");
            String rs = sc.nextLine();

            //validamos antes de guardar
            if (!rs.isEmpty()) {
                //pasamos a true el parametro booleano
                validarRazonSocial = true;
                empresa.setRazonSocial(rs);
            } else {
                //mostramos la razon de porque no es valido, e ingrese de nuevo
                System.out.println("La razon social no debe estar vacia, intentelo de nuevo.");
            }

        }


        //parametro para carga de empleados
        boolean exitEmpleados = false;

        //variables de la clase empleado
        String nombreCompleto = "";
        int legajo = 0;
        double salario = 0.0;
        NivelAcademico nivelAcademico = null;

        while (!exitEmpleados) {

            //carga de empleados en el arraylist de la empresa

            //parametro para validar nombre completo
            boolean validarNombreCompleto = false;

            //validacion nombre completo
            while (!validarNombreCompleto) {

                System.out.println("Ingrese nombre completo; ");
                nombreCompleto = sc.nextLine();

                if (nombreCompleto.isEmpty()) {
                    //mostrar mensaje de por que no es valido
                    System.out.println("no se permite nombre completo vacio, por favor intente de nuevo.");
                } else {

                    //validar nombre completo
                    validarNombreCompleto = true;
                }
            }


            //parametro para validar legajo
            boolean validarLegajo = false;
            boolean legajoExistente;


            //validacion legajo
            while (!validarLegajo) {
                System.out.println("Ingrese legajo: ");
                String legajoTexto = sc.nextLine();


                if (legajoTexto.isEmpty()) {
                    System.out.println("No se permite legajo vacio, intente de nuevo");
                } else {
                    legajo = Integer.parseInt(legajoTexto);
                }

                legajoExistente = false;

                for (Empleado empleado : empresa.getEmpleados()) {
                    if (empleado.getLegajo() == legajo) {
                        //cambiar parametro booleano
                        legajoExistente = true;
                        break;
                    }
                }

                //mostramos por consola
                if (legajoExistente) {
                    System.out.println("el legajo ingresado ya existe, intente de nuevo.");
                } else {
                    System.out.println("legajo ingresado valido");
                    validarLegajo = true;
                }


            }


            //parametro para validar salario
            boolean validarSalario = false;

            //validacion Salario
            while (!validarSalario) {
                System.out.println("Ingrese su salario: ");
                salario = sc.nextDouble();
                sc.nextLine();

                if (salario > 0) {
                    //validar salario
                    validarSalario = true;
                } else {
                    System.out.println("Salario no valido, debe ser mayor a cero. Intente de nuevo: ");

                }
            }

            //parametro para validar codigo academico
            boolean validarCodigo = false;
            boolean codigoExistente = false;

            //validacion Nivel Academico
            while (!validarCodigo) {
                System.out.println("Ingrese el codigo de nivel academico: ");
                int codigo = sc.nextInt();
                sc.nextLine(); // limpia el buffer

                for (NivelAcademico nivel : nivelAcademicos) {
                    if (nivel.getCodigo() == codigo) {
                        codigoExistente = true;
                        nivelAcademico = nivel;
                        break;

                    }
                }

                if (codigoExistente) {
                    System.out.println("codigo ingresado valido.");
                    validarCodigo = true;

                } else {
                    System.out.println("el codigo ingresado no existe, intente de nuevo");
                }
            }

            //agregar empleado a la ArrayList
            Empleado empleado = new Empleado(nombreCompleto, legajo, salario, nivelAcademico);
            //agregamos el empleado a la lista de la empresa
            empresa.agregarEmpleado(empleado);

            boolean validarSalidaEmpleados = false;
            while (!validarSalidaEmpleados) {
                //preguntar si desea agregar otro empleado
                System.out.println("Desea agregar otro empleado? s/n");
                String salida = sc.nextLine();
                sc.nextLine();//limpia buffer

                //validar salida
                if (salida.equalsIgnoreCase("n")) {
                    System.out.println("saliendo de la carga de empleados....");
                    exitEmpleados = true;//sale de la carga
                    validarSalidaEmpleados = true;

                } else if (salida.equalsIgnoreCase("s")) {
                    System.out.println("Agregando nuevo empleado...");
                    validarSalidaEmpleados = true;

                } else {
                    System.out.println("opcion no valida, intente de nuevo");
                }
            }

        }
        //mostrar reporte
        mostrarReporte(empresa);
    }


    private static void mostrarReporte(Empresa empresa){
        System.out.println("----------REPORTE DE LA EMPRESA----------");
        System.out.println("Empresa: "+empresa.getRazonSocial());
        System.out.println("CUIT: "+empresa.getCuit());
        System.out.println("----------EMPLEADOS----------");

        //variables
        double sumaSalarios =0;
        Empleado mejorEmpleado = null;

       //creamos un for each para leer los empleados que estan dentro de la lista
        for (Empleado empleado:empresa.getEmpleados()){

            //guardamos el valor de retorno del metodo que esta en la clase Empleado
             double salarioTotal = empleado.salarioTotalCalculado();

             sumaSalarios += salarioTotal;

            if (mejorEmpleado == null || salarioTotal > mejorEmpleado.salarioTotalCalculado()) {
                mejorEmpleado = empleado;
            }



            System.out.printf("Nombre Completo: %s\n", empleado.getNombreCompleto());
            System.out.printf("Salario: $ %.2f\n", salarioTotal);
            System.out.printf("Nivel Educativo: %s (Porcentaje Aumento: %.0f%%)\n",
                    empleado.getNivelAcademico().getNivel(),
                    empleado.getNivelAcademico().getPorcentajeAumento());
            System.out.println("---------------------------------------------------------------------");
        }

        double promedioSalarios = sumaSalarios / empresa.getEmpleados().size();

        System.out.println("\nResumen:");
        System.out.printf("El promedio de los salarios de la empresa es: $ %.2f\n", promedioSalarios);

        if (mejorEmpleado != null) {
            System.out.println("El empleado con mejor salario es:");
            System.out.printf("Nombre Completo: %s\n", mejorEmpleado.getNombreCompleto());
            System.out.printf("Salario: $ %.2f\n", mejorEmpleado.salarioTotalCalculado());
            System.out.printf("Nivel Educativo: %s (Porcentaje Aumento: %.0f%%)\n",
                    mejorEmpleado.getNivelAcademico().getNivel(),
                    mejorEmpleado.getNivelAcademico().getPorcentajeAumento());
            }
        }

    }





