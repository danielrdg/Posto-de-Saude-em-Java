public class Paciente 
{
    private String nome;
    private String cpf; // CPF e telefone foram definidos como String pq CPF tem traço e ponto e telefone pode ter parenteses para o DDD/DDI.
    private String telefone;
    private int diagnostico;
    private String medicamentoIndicado;
    private int quantidadeCaixasIndicadas;
    public Paciente(String nome, String cpf, String telefone, int diagnostico, String medicamentoIndicado, int quantidadeCaixasIndicadas) //Constructor do objeto Paciente
    {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.diagnostico = diagnostico;
        this.medicamentoIndicado = medicamentoIndicado;
        this.quantidadeCaixasIndicadas = quantidadeCaixasIndicadas;
    }
    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    public String getCpf() 
    {
        return cpf;
    }
    public void setCpf() 
    {
        this.cpf = cpf;
    }
    public String getTelefone()    
    {
        return telefone;
    }
    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }
    public String getDiagnostico() 
    {
        switch(diagnostico) 
        {
            case 1: 
                return "Covid";
            case 2:
                return "Zica";
            case 3:
                return "Chikungunya";
            case 4:
                return "Dengue";
            default:
                return "Diagnostico desconhecido";
        }
    }
    public void setDiagnostico(int diagnostico) 
    {
        this.diagnostico = diagnostico;
    }
    public String getMedicamentoIndicado() 
    {
        return medicamentoIndicado;
    }
    public void setMedicamentoIndicado(String medicamentoIndicado) 
    {
        this.medicamentoIndicado = medicamentoIndicado;
    }
    public int getQuantidadeCaixasIndicadas() 
    {
        return quantidadeCaixasIndicadas;
    }
    public void setQuantidadeCaixasIndicadas(int quantidadeCaixasIndicadas) 
    {
        this.quantidadeCaixasIndicadas = quantidadeCaixasIndicadas;
    }
    
    public String toString() //Metodo toString para impressao formatada do objeto Paciente
    {
        return "\nNome = " + getNome() + 
               "\nCPF = " + getCpf() + 
               "\nTelefone = " + getTelefone() + 
               "\nDiagnostico = " + getDiagnostico() +  
               "\nMedicamento indicado = " + getMedicamentoIndicado() + 
               "\nQuantidade de caixas indicadas = " + getQuantidadeCaixasIndicadas();
    }
}