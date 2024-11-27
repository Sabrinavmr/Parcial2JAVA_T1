    Examen Parcial 2

Codifique las siguientes clases Java: 

Clase: NivelAcademico
Atributos: código (int), nivel (String), porcentajeAumento (double)

Clase: Empleado
Atributos: nombreCompleto (String), legajo (int), salario (double), nivelAcademico
(NivelAcademico)

Clase: Empresa
Atributos: cuit (String), razonSocial (String), empleados (ArrayList<Empleado>)

Clase: LiquidacionEmpresa (clase que posee el método main)

////////////

Lógica a Implementar:
En la clase LiquidacionEmpresa deberá declarar una variable “nivelesAcademicos” de tipo
ArrayList<NivelAcademico> que permita contener los siguientes niveles académicos:

Código           Nivel             Porcentaje de Aumento
  10     Secundario Completo             10
  20     Universitario Completo          30
  30     Maestría Completo               40
  40     Doctorando Completo             50
  
ArrayList<NivelAcademico> nivelesAcademicos = new ArrayList<NivelAcademico>();
 NivelAcademico na = new NivelAcademico(10, "Secundario Completo", 10);
 
 nivelesAcademicos.add(na);
 na = new NivelAcademico(20, "Universitario Completo", 30);
 nivelesAcademicos.add(na);
 na = new NivelAcademico(30, "Maestría Completo", 40);
 nivelesAcademicos.add(na);
 na = new NivelAcademico(40, "Doctorando Completo", 50);
 nivelesAcademicos.add(na);
 
1- En la clase LiquidacionEmpresa cree una instancia de la clase Empresa y solicite inicialmente
los datos de la empresa, validando que razonSocial no sea vacío y que cuit tenga 11 dígitos.

2- Posteriormente comenzara la creación y carga de los empleados de la empresa en el
ArrayList, validando nombre completo y legajo no vacío, salario mayor a cero y para el nivel
académico se deberá solicitar el código del nivel académico, buscar ese código en el array
“nivelesAcademicos” creado anteriormente y asignarlo, en caso de que el código no exista
emitir el mensaje “El código ingresado no existe, intente nuevamente” y vuelva a solicitar
el código. El paso número 2 se repetirá hasta que el usuario indique que no quiere continuar
cargando empleados validando que el legajo del nuevo empleado a cargar no haya sido
cargado anteriormente, si ese fuese el caso emitir el mensaje “El legajo ingresado ya fue
cargado anteriormente” y solicite ingresar nuevamente el legajo.

3- Agregue a la clase Empleado el método:
public double salarioTotalCalculado(){}
que retorna el salario total del empleado que será equivalente a la suma del salario
asignado al empleado más el aumento correspondiente por el nivel académico que tiene.

4- Finalmente mostrar por pantalla la siguiente información, mostrando al pie del informe el
promedio de los salarios de los empleados y el empleado con mejor salario:

Empresa: XXXXX
CUIT: XXXXXXXXXXX
------------------------Empleados------------------------------
Nombre Completo: XXXXXX
Salario: $ XXXXXX
Nivel Educativo: XXXXXX (Porcentaje Aumento XX %)
---------------------------------------------------------------------
Nombre Completo: XXXXXX
Salario: $ XXXXXX
Nivel Educativo: XXXXXX (Porcentaje Aumento XX %)
---------------------------------------------------------------------
………..
Resumen:
El promedio de los salarios de la empresa es: $ XXXXXX
El empleado con mejor salario es:
Nombre Completo: XXXXXX
Salario: $ XXXXXX
Nivel Educativo: XXXXXX (Porcentaje Aumento XX %)
