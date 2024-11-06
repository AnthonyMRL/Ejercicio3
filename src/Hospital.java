import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Hospital {
    private PriorityQueue<Paciente> listaPacientes;

    public Hospital(){
        listaPacientes=new PriorityQueue<Paciente>();
    }


    public void encolar(Paciente dato){
        listaPacientes.add(dato);
    }

    public Paciente atender() throws Exception{
        if(listaPacientes.isEmpty())
            throw new Exception("No existen elementos");
        return listaPacientes.remove();
    }

    public List<Paciente> listarPacientes(){
        return listaPacientes.stream().collect(Collectors.toList());
    }


}
