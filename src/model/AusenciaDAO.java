
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utilitarios.AusenciaBean;
import utilitarios.Conexao;

public class AusenciaDAO {
    
    private Connection con = Conexao.abrirConexao();
    AusenciaBean ab = new AusenciaBean();
    
    public void registraAusencia (AusenciaBean ab){
    
        String sql = "insert into TB_AUSENCIA (AUSENCIA_DATA, AUSENCIA_PERIODO, AUSENCIA_OBSERVACAO, ID_AS_FUNC, ID_AS_USUARIO, AUSENCIA_VALOR)"
                + "VALUES ('" + ab.getAs_data() + "', " + ab.getAs_periodo()+ ", '" + ab.getAs_obs() + "' , " + ab.getId_func() + ", 1,'"
                + ab.getHora_ausencia() + "');";
        
        try{
            
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Ausência cadastrada com sucesso!", "Cadastro de Ausência", JOptionPane.INFORMATION_MESSAGE);
        
        
        }catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }      
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
