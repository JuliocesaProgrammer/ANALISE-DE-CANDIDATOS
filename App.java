import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args){
        String[] candidatos = {"Julio", "Marcia", "Julia", "Paulo", "Gustavo"};
        for(String candidato: candidatos){ 
            entrandoEmContato(candidato); 
        }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }else{
                System.out.println("Contato Realizado com Sucesso");
            }
        }while(continuarTentando && tentativasRealizadas < 3);
        if(atendeu){
            System.out.println("Conseguimos Contato com " + candidato + " NA " + tentativasRealizadas + " Tentativa ");
        }else{
            System.out.println("Não conseguimos contato com " + candidato + " NA " + tentativasRealizadas + " Tentativa ");
        }
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String[] candidatos = {"Julio", "Marcia", "Julia", "Paulo", "Gustavo"};
        System.out.println("Imprimindo a lista de candidatos, informando o indice do elemento:");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidado de número é " + (i + 1) + " É " + candidatos[i]);
        }
    }
    static void selecaoDeCandidatos(){
        String[] candidatos = {"Julio", "Marcia", "Julia", "Paulo", "Gustavo", "Gustava", "Pedra", "Petunia", "Cris", "Catia"};

        int candidatosSelecionados = 0;
        int candidatoatual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoatual < candidatos.length) {
            String candidato = candidatos[candidatoatual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " Foi selecionado para a vaga ");
                candidatosSelecionados++;
            }
            candidatoatual++;
        }
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    public static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        }else if (salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRAPRO");
        }else{
            System.out.println("NÃO LIGAR PARA O CANDIDATO");
        }
    }
}