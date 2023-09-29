public class CadastroPaciente 
{
    private Paciente pacientes[];
    public CadastroPaciente() 
    {
        pacientes = new Paciente[10];
    }
    public void adicionaPaciente(Paciente paciente)
    {
        int cont= 0;
        for (int i = 0; i < pacientes.length; i++) 
        {
            if (pacientes[i] == null) //Verifica se a posicao do vetor esta vazia
            {
                pacientes[i]=paciente;
                System.out.println("Paciente adicionado com sucesso!");
                cont++;
                break; //O break eh necessario pq sem ele o metodo nao sairia do laço e adicionaria o mesmo paciente em todas as posiçoes vazias do vetor.
            }
            else 
            {
                System.out.println("Nao foi possível adicionar o paciente, o cadastro esta cheio!"); //Se nenhuma posicao percorrida estiver null (vazia)
            }
            if (pacientes[i].getCpf().equals(paciente.getCpf())) //Verificando se um paciente com esse CPF ja esta no vetor
            {
                System.out.println("Esse paciente ja foi cadastrado!"); //Se estiver,printa que o paciente ja foi cadastrado
                break;
            }
        }
    }
    public void removePaciente (String cpf) 
    {
        int cont= 0;
        for (int i = 0; i < pacientes.length; i++) 
        {
            if(pacientes[i] != null && pacientes[i].getCpf().equals(cpf)) //Se percorrendo o vetor e o indice (i) ter um CPF igual ao do paciente que estamos comparando, ele remove o paciente.
                                                                          // Isso é feito para evitar que o usuario tenha que digitar todas as informaçoes novamente para consultar um paciente.
            {
                pacientes[i] = null;
                System.out.println("Paciente removido com sucesso!");
                cont++;
                break; //O break eh necessario pq estamos verificando um paciente especifico,depois de encontra-lo nao tem pq continuar percorrendo o vetor.
            }
        }
        if(cont==0) 
        {
            System.out.println("Paciente com esse CPF nao esta cadastrado!");
        }
    }
    public void mostraVetor() 
    {
        for(int i = 0; i < pacientes.length; i++) 
        {
            if (pacientes[i] == null) //Se a posicao estiver vazia ele imprime que nao existe paciente nessa posiçao, portanto ela esta disponivel para adicionar um paciente.
                                      // Fiz isso para evitar que seja impresso NULL em todas as posiçoes que nao possuem um paciente (melhorar o entendimento do programa p o usuario).
            {
                System.out.println("\nLeito " + (i + 1) + "\nSem nenhum paciente, leito disponivel!");
            }
            else if (pacientes[i] != null) 
            {
                System.out.println("\nLeito " + (i + 1) + "\nCom o paciente: " + pacientes[i]); // O i+1 eh usado para imprimir a posiçao que o objeto paciente esta, ao inves de imprimir o indice.
            }
        }
    }
    public void mostraPosicoesOcupadas() 
    {
        int cont=0; //Contador para contar quantos pacientes tem no vetor
        for(int i = 0; i < pacientes.length; i++)
        {
            if (pacientes[i] != null) //Verificando se o vetor nao esta vazio,ou seja,sem pacientes
            {
                System.out.println("Os leitos ocupados sao\n\nLeito " + (i + 1) + pacientes[i]); //O i+1 eh usado para imprimir a posiçao que o objeto paciente esta, ao inves de imprimir indice.
                cont++; 
            }
        }
        if(cont==0) //Se nao tiver nenhum paciente,imprime que nao ha pacientes cadastrados
        {
            System.out.println("Nao ha pacientes cadastrados!");
        }
    }
    public void ordenaAlfabeticamente()
    {
        int cont= 0;
        for (int i = 0; i < pacientes.length; i++) 
        {
            for (int j = 0; j < pacientes.length; j++) 
            {
                if (pacientes[j] != null && pacientes[j+1] != null && pacientes[j].getNome().compareToIgnoreCase(pacientes[j+1].getNome()) > 0) //[j+1] = posicao [j] = indice
                {
                    Paciente aux= pacientes[j];
                    pacientes[j]= pacientes[j+1];
                    pacientes[j+1]= aux;
                    cont++;
                }
            }
        }
        if(cont==0) 
        {
            System.out.println("Nao ha pacientes cadastrados!");
        }
    }
    public double calculaPorcentagemDoenca(int escolhaDoenca) 
    {
        double totalDePacientes = 0;
        double pacientesComDoenca = 0;
        String nomeDoenca;
        switch (escolhaDoenca) 
        {
            case 1:
                nomeDoenca = "Covid";
                break;
            case 2:
                nomeDoenca = "Zica";
                break;
            case 3:
                nomeDoenca = "Chikungunya";
                break;
            case 4: 
                nomeDoenca = "Dengue";
                break;
            default:
                nomeDoenca = "Doenca invalida! Escolha uma das listadas.";
                break;
        }
        for (int i = 0; i < pacientes.length; i++) 
        {
            if (pacientes[i]!=null) 
            {
                totalDePacientes++;
                if (pacientes[i].getDiagnostico().equals(nomeDoenca))  
                {
                    pacientesComDoenca++;
                }
            }
        }
        if (totalDePacientes>0) //Esse if eh necessario pq se o total de pacientes for menor que zero nao tem como calcular a porcentagem
        {
            return (pacientesComDoenca/totalDePacientes * 100);
        }
        else System.out.println("Nao ha pacientes cadastrados!"); //Se o total for zero entao ele imprime que ainda nao foram cadastrados pacientes.
        return 0; //Esse return foi pq o BlueJ nao estava compilando ate eu retornar algum valor.
    }
    
     public static void imprimeGirafa() {
        System.out.println("\n          ▓▓  ░░              ");
        System.out.println("          ██░░░░██            ");
        System.out.println("      ░░░░░░░░██████          ");
        System.out.println("    ░░░░██░░░░░░██            ");
        System.out.println("    ░░░░░░░░░░░░████          ");
        System.out.println("      ░░░░░░░░░░██            ");
        System.out.println("            ░░▓▓████          ");
        System.out.println("            ░░░░██            ");
        System.out.println("            ▓▓░░████          ");
        System.out.println("            ░░░░██    ████    ");
        System.out.println("            ▓▓░░████░░██      ");
        System.out.println("            ░░░░░░░░░░░░      ");
        System.out.println("            ░░▓▓░░░░▓▓░░      ");
        System.out.println("            ░░░░    ░░░░      ");
    }
}