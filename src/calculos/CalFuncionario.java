package calculos;

import utilitarios.AusenciaBean;
import utilitarios.HoraExtraBean;

public class CalFuncionario {
   
    private double carga_horaria_total;
    private double valor_hora;
    private double periodo_horas;
    private double valor_hx;
    private double valor_total;
    private double valor_total_hx;
    
    //HoraExtraBean hxb = new HoraExtraBean();
    
    public void calcularDiasUteis(HoraExtraBean hxb){
        
        //multiplicando a carga horário do funcionário por cinco e calculando o valor da hora do funcionário --> recebe o salário e divide pela quantidade total da carga horária
        setValor_hora(hxb.getSalario() / (hxb.getCarga_horaria() * 5));
        
        //recebendo o período da hora extra informada pelo usuário e transformando em horas
        setPeriodo_horas((hxb.getHx_periodo() / 60));
        
        //calculando o valor da hora extra --> valor da hora multiplicado por 0,5
        setValor_hx((this.getValor_hora() * 5/10));
        
        //valor da hora extra multiplicado pelo tempo/periodo
        setValor_total((this.getValor_hx() * this.getPeriodo_horas()));
        
        //somando a hora do funcionário mais a hora extra (50%)
        setValor_total_hx((this.getValor_total() + (this.getValor_hora() * this.getPeriodo_horas())));        

        //enviando o resultado para bean
        hxb.setHx_total(this.getValor_total_hx());
         
    }
    
    public void calcularDiasNaoUteis(HoraExtraBean hxb){
    
         //multiplicando a carga horário do funcionário por cinco e calculando o valor da hora do funcionário --> recebe o salário e divide pela quantidade total da carga horária
        setValor_hora(hxb.getSalario() / (hxb.getCarga_horaria() * 5));
        
        //recebendo o período da hora extra informada pelo usuário e transformando em horas
        setPeriodo_horas((hxb.getHx_periodo() / 60));
           
        //valor da hora extra multiplicado pelo tempo/periodo
        setValor_total((this.getValor_hora() * this.getPeriodo_horas()));
        
        //somando a hora do funcionário mais a hora extra (100%)
        setValor_total_hx((this.getValor_total() * 2));        

        //enviando o resultado para bean
        hxb.setHx_total(this.getValor_total_hx());   
    
    }
    
    public void calcularAusenciaJustificada(AusenciaBean ab){
        
        //multiplicando a carga horário do funcionário por cinco e calculando o valor da hora do funcionário --> recebe o salário e divide pela quantidade total da carga horária
        setValor_hora(ab.getSalario() / (ab.getCarga_horaria() * 5));
        //recebendo o período da ausência informada pelo usuário e transformando em horas
        setPeriodo_horas((ab.getAs_periodo() / 60));
        //multiplica o periodo da ausência com o valor da hora(ou seja não desconta nada, paga a hora normal da ausência)
        ab.setAs_total((this.getPeriodo_horas() * this.getValor_hora()));
        
    }
    
    public void calcularAusenciaNaoJustificada(AusenciaBean ab){
    
         //multiplicando a carga horário do funcionário por cinco e calculando o valor da hora do funcionário --> recebe o salário e divide pela quantidade total da carga horária
        setValor_hora(ab.getSalario() / (ab.getCarga_horaria() * 5));
        
        //recebendo o período da ausência informada pelo usuário e transformando em horas
        setPeriodo_horas((ab.getAs_periodo() / 60));
           
        //valor da hora extra multiplicado pelo tempo/periodo
        setValor_total((this.getValor_hora() * this.getPeriodo_horas()));
        
        //subtrai o valor da hora ausente com o salário
        ab.setAs_total((this.getValor_total() - ab.getSalario()));        
  
        }

    public double getCarga_horaria_total() {
        return carga_horaria_total;
    }

    public void setCarga_horaria_total(double carga_horaria_total) {
        this.carga_horaria_total = carga_horaria_total;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public double getPeriodo_horas() {
        return periodo_horas;
    }

    public void setPeriodo_horas(double periodo_horas) {
        this.periodo_horas = periodo_horas;
    }

    public double getValor_hx() {
        return valor_hx;
    }

    public void setValor_hx(double valor_hx) {
        this.valor_hx = valor_hx;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public double getValor_total_hx() {
        return valor_total_hx;
    }

    public void setValor_total_hx(double valor_total_hx) {
        this.valor_total_hx = valor_total_hx;
    }
    
}
