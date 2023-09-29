import java.util.Scanner;
public class Aplicacao 
{
    public static void main(String[] args) 
    {
        int opcao, opcaoMedicamento, quantidadeDisponivel, diagnostico; //Aqui eu declarei as variaveis inteiras que serao utilizadas nos metodos abaixo. 
        String medicamentoIndicado;
        Scanner in = new Scanner(System.in); //Criacao do objeto Scanner para leitura de dados do usuario.
        CadastroPaciente cadastro = new CadastroPaciente(); //Criei uma instancia da classe CadastroPaciente pq sem ela nao seria possivel chamar os metodos.
        
        //Abaixo foram declarados e inicializados os quatro medicamentos que estao no enunciado do TF.
        Medicamento covixUltra = new Medicamento ("CovixUltra", 100);
        Medicamento zicox = new Medicamento ("Zicox", 100);
        Medicamento chikTop = new Medicamento ("ChikTop", 100);
        Medicamento denguenit = new Medicamento ("Denguenit", 100);
        do 
        {
            System.out.println("------------------MENU--------------------");
            System.out.println("Escolha uma opção:\n 1 - ADICIONAR PACIENTE\n 2 - REMOVER PACIENTE\n 3 - MOSTRAR TODOS OS LEITOS\n 4 - MOSTRAR LEITOS OCUPADOS\n 5 - MOSTRAR PACIENTES EM ORDEM ALFABÉTICA\n 6 - MOSTRAR PORCENTAGEM DE DOENÇA\n 7 - ENCERRAR O PROGRAMA ");
            System.out.println("------------------------------------------");
            opcao = in.nextInt();
            in.nextLine();
            switch(opcao) 
            {
                case 1:
                    System.out.print("Nome: ");
                    String nome = in.nextLine();
                    System.out.print("CPF: ");
                    String cpf = in.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = in.nextLine();
                    System.out.print("Diagnostico: (1 - Covid, 2 - Zica, 3 - Chikungunya, 4 - Dengue) - ");
                    diagnostico = in.nextInt();
                    in.nextLine();
                    
                    do //Laco pra evitar que o usuario digite uma opcao invalida.
                    {
                        if (diagnostico < 1 || diagnostico > 4) 
                        {
                            System.out.println("Diagnostico invalido! Escolha de 1-4.");
                            diagnostico = in.nextInt();
                        }
                    }   while (diagnostico < 1 || diagnostico > 4);
                    System.out.print("Medicamento indicado: (1 - CovixUltra, 2 - Zicox, 3 - ChikTop, 4 - Denguenit) - ");
                    opcaoMedicamento = in.nextInt();
                    in.nextLine();
                    do //Laco pra evitar que o usuario digite uma opcao invalida.
                    {
                        if (opcaoMedicamento < 1 || opcaoMedicamento > 4) 
                        {
                            System.out.println("Medicamento invalido! Escolha de 1 a 4.");
                            opcaoMedicamento = in.nextInt();
                        }
                    } while (opcaoMedicamento < 1 || opcaoMedicamento > 4);
                    
                    switch (opcaoMedicamento) 
                    {
                        case 1:
                            medicamentoIndicado = covixUltra.getNomeMedicamento();
                            break;
                        case 2:
                            medicamentoIndicado = zicox.getNomeMedicamento();
                            break;
                        case 3:
                            medicamentoIndicado = chikTop.getNomeMedicamento();
                            break;
                        case 4:
                            medicamentoIndicado = denguenit.getNomeMedicamento();
                            break;
                        default:
                            medicamentoIndicado = "Sem medicamento";
                            break;
                    }
                    System.out.print("Quantidade de caixas: ");
                    int quantidadeCaixasIndicadas = in.nextInt();
                    in.nextLine();
                    Paciente paciente = new Paciente(nome, cpf, telefone, diagnostico, medicamentoIndicado, quantidadeCaixasIndicadas); //O objeto Paciente eh criado com os parametros digitados pelo usuario.
                    int quantidadeCaixas;
                        switch (opcaoMedicamento) //Esse switch serve p/atualizar o estoque de medicamentos conforme a quantidade de caixas solicitadas.
                    {
                        case 1:
                            quantidadeDisponivel = covixUltra.getQuantidadeCaixas(); //Essa variavel foi criada p/manter o conteudo da quantidade em estoque do remedio (100) 
                            if (quantidadeDisponivel >= 1) //Enquanto a quantidade for maior ou igual a 1 pq nao eh possivel indicar um remedio que nao tem nenhuma quantidade
                            {
                                if (paciente.getQuantidadeCaixasIndicadas() > quantidadeDisponivel) //Se a quantidade indicada ao paciente for maior q o estoque do medicamento
                                                                                                    //Eh adicionado oq restou no estoque, foi uma solucao para contornar esse problema.
                                {
                                    System.out.println("Quantidade indisponivel! Sera indicado oq sobrou no estoque!");
                                    paciente.setQuantidadeCaixasIndicadas(covixUltra.getQuantidadeCaixas());
                                }
                                quantidadeCaixas = quantidadeDisponivel - paciente.getQuantidadeCaixasIndicadas();
                                covixUltra.setQuantidadeCaixas(quantidadeCaixas);
                            }
                            else 
                            {
                                System.out.println("Nao ha mais estoque desse medicamento, nao eh possivel adicionar paciente!");
                                return;
                            }
                            break;
                        case 2:
                            quantidadeDisponivel = zicox.getQuantidadeCaixas(); 
                            if (quantidadeDisponivel >= 1) 
                            {
                                if (paciente.getQuantidadeCaixasIndicadas() > quantidadeDisponivel) 
                                {
                                    System.out.println("Quantidade indisponivel! Sera indicado oq sobrou no estoque!");
                                    paciente.setQuantidadeCaixasIndicadas(zicox.getQuantidadeCaixas());
                                }
                                quantidadeCaixas = quantidadeDisponivel - paciente.getQuantidadeCaixasIndicadas();
                                zicox.setQuantidadeCaixas(quantidadeCaixas);
                            }
                            else 
                            {
                                System.out.println("Nao ha mais estoque desse medicamento, nao eh possivel adicionar paciente!");
                                return;
                            }
                            break;
                            
                        case 3:
                            quantidadeDisponivel = chikTop.getQuantidadeCaixas(); 
                            if (quantidadeDisponivel >= 1) 
                            {
                                if (paciente.getQuantidadeCaixasIndicadas() > quantidadeDisponivel) 
                                {
                                    System.out.println("Quantidade indisponivel! Sera indicado oq sobrou no estoque!");
                                    paciente.setQuantidadeCaixasIndicadas(chikTop.getQuantidadeCaixas());
                                }
                                quantidadeCaixas = quantidadeDisponivel - paciente.getQuantidadeCaixasIndicadas();
                                chikTop.setQuantidadeCaixas(quantidadeCaixas);
                            }
                            else 
                            {
                                System.out.println("Nao ha mais estoque desse medicamento, nao eh possivel adicionar paciente!");
                                return;
                            }
                            break;
                            
                        case 4:
                            quantidadeDisponivel = denguenit.getQuantidadeCaixas(); 
                            if (quantidadeDisponivel >= 1) 
                            {
                                if (paciente.getQuantidadeCaixasIndicadas() > quantidadeDisponivel) 
                                {
                                    System.out.println("Quantidade indisponivel! Sera indicado oq sobrou no estoque!");
                                    paciente.setQuantidadeCaixasIndicadas(denguenit.getQuantidadeCaixas());
                                }
                                quantidadeCaixas = quantidadeDisponivel - paciente.getQuantidadeCaixasIndicadas();
                                denguenit.setQuantidadeCaixas(quantidadeCaixas);
                            }
                            else 
                            {
                                System.out.println("Nao ha mais estoque desse medicamento, nao eh possivel adicionar paciente!");
                                return;
                            }
                            break;
                            
                    }
                    cadastro.adicionaPaciente(paciente); //Eh chamado o metodo adicionaPaciente que recebe o objeto Paciente (criado pelo usuario)
                    break;
                    
                case 2:
                    System.out.print("Digite o CPF do paciente que deseja remover: ");
                    cpf = in.nextLine();
                    cadastro.removePaciente(cpf);
                    break;
                    
                case 3:
                    System.out.println("Todos os leitos:");
                    cadastro.mostraVetor();
                    break;
                    
                case 4:
                    cadastro.mostraPosicoesOcupadas();
                    break;
                    
                case 5:
                    System.out.println("Pacientes por ordem alfabetica:");
                    cadastro.ordenaAlfabeticamente();
                    break;
                    
                case 6:
                    System.out.print("Escolha a doenca que deseja saber a porcentagem (1 - Covid, 2 - Zica, 3 - Chikungunya, 4 - Dengue) - ");
                    int escolhaDoenca = in.nextInt();
                    do //Laco pra evitar que o usuario digite uma opcao invalida.
                    {
                        if (escolhaDoenca < 1 || escolhaDoenca > 4) 
                        {
                            System.out.print("Opcao invalida! Escolha de 1 a 4.");
                            escolhaDoenca = in.nextInt();
                        }
                    } while (escolhaDoenca < 1 || escolhaDoenca > 4);
                    double porcentagem = cadastro.calculaPorcentagemDoenca(escolhaDoenca);
                    System.out.println("A porcentagem de pacientes com essa doenca eh: " + porcentagem + "%");
                    break;
                    
                case 7:
                    System.out.println("Encerrando programa...");
                    break;
                    default:
                    System.out.println("Opçao invalida! Escolha de 1 - 7.");
                    break;
            }
        }while(opcao != 7); //Deve ser diferente de 7 pq a opcao 7 encerra o programa.
        
        //Quando a opçao for 7 o programa eh encerrado e exibe o estoque de medicamentos atualizado
        System.out.println("\nEstoque de Medicamentos: ");
        System.out.println("\nCovixUltra sobraram " + covixUltra.getQuantidadeCaixas() + " caixas!");
        System.out.println("\nZicox sobraram " + zicox.getQuantidadeCaixas() + " caixas!");
        System.out.println("\nChikTop sobraram " + chikTop.getQuantidadeCaixas() + " caixas!");
        System.out.println("\nDenguenit sobraram " + denguenit.getQuantidadeCaixas() + " caixas!");
        cadastro.imprimeGirafa(); //Metodo p/ imprimir uma girafa.
    }
}