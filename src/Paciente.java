public class Paciente implements Comparable<Paciente>{
    private int prioridad;
    private String nombre;


    public Paciente(int prioridad, String nombre) {
        this.prioridad = prioridad;
        this.nombre = nombre;
    }
    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Paciente tiene prioridad: " + prioridad +
                ", Nombre: " + nombre;
    }


    @Override
    public int compareTo(Paciente o) {
        if(this.prioridad < o.getPrioridad())
            return -1;
        else
            return 1;
    }




}
