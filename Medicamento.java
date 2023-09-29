public class Medicamento 
{
    private String nomeMedicamento;
    private int quantidadeCaixas;
    
    public Medicamento (String nomeMedicamento, int quantidadeCaixas) //Constructor do objeto Medicamento
    {
        this.nomeMedicamento = nomeMedicamento;
        this.quantidadeCaixas = quantidadeCaixas;
    }
    public String getNomeMedicamento() 
    {
        return nomeMedicamento;
    }
    public void setNome(String nome) 
    {
        this.nomeMedicamento = nomeMedicamento;
    }
    public int getQuantidadeCaixas() 
    {
        return quantidadeCaixas;
    }
    public void setQuantidadeCaixas(int quantidadeCaixas)   
    {
        this.quantidadeCaixas = quantidadeCaixas;
    }
}