import java.util.ArrayList;

public class Empresa {

    private String cuit;
    private String razonSocial;
    private ArrayList<Empleado> empleados;


    public Empresa(String cuit, String razonSocial, ArrayList<Empleado> empleados){
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.empleados = empleados;
    }

    public Empresa() {
    this.empleados = new ArrayList<>();
    }

    public String getCuit() {return cuit;}

    public void setCuit(String cuit) {this.cuit = cuit;}

    public String getRazonSocial() {return razonSocial;}

    public void setRazonSocial(String razonSocial) {this.razonSocial = razonSocial;}

    public ArrayList<Empleado> getEmpleados() {return empleados;}

    //public void setEmpleados(ArrayList<Empleado> empleados) {this.empleados = empleados;}
    public void agregarEmpleado(Empleado empleado){
        this.empleados.add(empleado);}






}




