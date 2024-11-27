import java.util.ArrayList;

public class Empleado {
    private String nombreCompleto;
    private int legajo;
    private double salario;
    private NivelAcademico nivelAcademico;


    public Empleado(String nombreCompleto, int legajo, double salario, NivelAcademico nivelAcademico){
        this.nombreCompleto = nombreCompleto;
        this.legajo = legajo;
        this.salario = salario;
        this.nivelAcademico = nivelAcademico;
    }

    public String getNombreCompleto() {return nombreCompleto;}

    public void setNombreCompleto(String nombreCompleto) {this.nombreCompleto = nombreCompleto;}

    public int getLegajo() {return legajo;}

    public void setLegajo(int legajo) {this.legajo = legajo;}

    public double getSalario() {return salario;}

    public void setSalario(double salario) {this.salario = salario;}

    public NivelAcademico getNivelAcademico() {return nivelAcademico;}

    public void setNivelAcademico(NivelAcademico nivelAcademico) {this.nivelAcademico = nivelAcademico;}

    //METODO para calcular el salario total
    ///\retorna el salario total del empleado que será equivalente a la suma del salario
    ///\asignado al empleado más el aumento correspondiente por el nivel académico que tiene

    public double salarioTotalCalculado(){
        return salario + (salario * (nivelAcademico.getPorcentajeAumento()/100));
    }




}
