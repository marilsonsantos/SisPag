package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.TelaPrincipal;
import utilitarios.Conexao;
import utilitarios.EmpresaBean;
import view.CadastroUsuario;

public class EmpresaDAO {

    private int TotEmpresa;

    private Connection con = Conexao.abrirConexao();

    EmpresaBean eb = new EmpresaBean();
    UsuarioDAO udao = new UsuarioDAO();
    CadastroUsuario cu = new CadastroUsuario();
    TelaPrincipal tp = new TelaPrincipal();

    public void cadastrar(EmpresaBean eb) {

        //inserindo os dados no bd
        String sql = "INSERT INTO TB_EMPRESA (EMPRESA_NOME, EMPRESA_ENDERECO, EMPRESA_NUM, EMPRESA_COMPLEMENTO, EMPRESA_BAIRRO,"
                + "EMPRESA_MUNICIPIO, EMPRESA_PAIS, EMPRESA_UF, EMPRESA_TELEFONE1, EMPRESA_TELEFONE2, EMPRESA_CEP, EMPRESA_CNPJ, EMPRESA_INSC_ESTADUAL, EMPRESA_CHAVE_SEG)"
                + "VALUES ('" + eb.getNome() + "' ,'" + eb.getEndereco() + "', " + eb.getNumero() + ", '" + eb.getComplemento() + "', '" + eb.getBairro() + "', '" + eb.getMunicipio()
                + "', '" + eb.getPais() + "', '" + eb.getUf() + "', '" + eb.getTelefone1() + "', '" + eb.getTelefone2() + "', '" + eb.getCep() + "', '" + eb.getCnpj() + "', '" + eb.getInsc_estadual() + "', '"
                + eb.getChave_seg() + "');";

        try {

            //testando validação de campos inteiros... nao deu certo
            String numero = String.valueOf(eb.getNumero());
            String telefone1 = String.valueOf(eb.getTelefone1());
            String cep = String.valueOf(eb.getCep());
            String cnpj = String.valueOf(eb.getCnpj());
            String insc_estadual = String.valueOf(eb.getInsc_estadual());

            //validando se os campos estão preenchidos    
            if ((eb.getNome().equals("")) || (eb.getEndereco().equals("")) || (eb.getBairro().equals("")) || (eb.getMunicipio().equals(""))
                    || (eb.getPais().equals("")) || (eb.getChave_seg().equals("")) || (eb.getUf().equals("")) || (numero.equals(""))
                    || (telefone1.equals("")) || (cep.equals("")) || (cnpj.equals("")) || (insc_estadual.equals(""))) {

                JOptionPane.showMessageDialog(null, "Campo não preenchido!", "Cadastro da Empresa", JOptionPane.INFORMATION_MESSAGE);

            } else {

                //se todos os campos obrigatórios estiverem preenchidos, o cadadastro é feito e o sistema se inicia
                PreparedStatement ps = getCon().prepareStatement(sql);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Empresa cadastrada com sucesso!", "Cadastro da Empresa", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {

            Conexao.fecharConexao(getCon());

        }

    }

    public void PossuiEmpresa() {

        String sql = "SELECT count(*) FROM TB_EMPRESA;";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            rs.next();

            //para iniciar o sistema, deve haver apenas um cadastro da empresa no bd
            setTotEmpresa(rs.getInt(1));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        } finally {

            Conexao.fecharConexao(getCon());

        }

    }

    public void exibeEmpresa(EmpresaBean eb) {

        String sql = "SELECT * FROM TB_EMPRESA WHERE ID_EMPRESA = 1";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            rs.next();

            //UsuarioBean recebendo os valores do bd
            eb.setNome(rs.getString("EMPRESA_NOME"));
            eb.setEndereco(rs.getString("EMPRESA_ENDERECO"));
            eb.setNumero(rs.getInt("EMPRESA_NUM"));
            eb.setComplemento(rs.getString("EMPRESA_COMPLEMENTO"));
            eb.setBairro(rs.getString("EMPRESA_BAIRRO"));
            eb.setMunicipio(rs.getString("EMPRESA_MUNICIPIO"));
            eb.setPais(rs.getString("EMPRESA_PAIS"));
            eb.setUf(rs.getString("EMPRESA_UF"));
            eb.setCep(rs.getString("EMPRESA_CEP"));
            eb.setCnpj(rs.getString("EMPRESA_CNPJ"));
            eb.setInsc_estadual(rs.getString("EMPRESA_INSC_ESTADUAL"));
            eb.setTelefone1(rs.getString("EMPRESA_TELEFONE1"));
            eb.setTelefone2(rs.getString("EMPRESA_TELEFONE2"));
            eb.setChave_seg(rs.getString("EMPRESA_CHAVE_SEG"));

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void validaCadastro(EmpresaBean eb) {

        //validando chave de segurança já cadastrada
        String chave_seg = (JOptionPane.showInputDialog(null, "Confirmar Chave de Segurança", "CONFIRMAR", JOptionPane.INFORMATION_MESSAGE));

        if (chave_seg.equals(eb.getChave_seg())) {

            udao.controleUsuario();
            int ControleUsuario = udao.getTotUsuario();

            if (ControleUsuario == 0) {

                cu.setVisible(true);

            } else {

                tp.setVisible(true);

            }

        } else {

            JOptionPane.showMessageDialog(null, "Chave de segurança incorreta!", "Atenção!", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public void alterarEmpresa(EmpresaBean eb) {

        //alterando dados da empresa
        String sql = "UPDATE TB_EMPRESA SET EMPRESA_NOME = '" + eb.getNome() + "', EMPRESA_ENDERECO = '" + eb.getEndereco() + "', EMPRESA_NUM = "
                + eb.getNumero() + ", EMPRESA_BAIRRO = '" + eb.getBairro() + "', EMPRESA_MUNICIPIO = '" + eb.getMunicipio() + "', EMPRESA_PAIS = '"
                + eb.getPais() + "', EMPRESA_UF = '" + eb.getUf() + "', EMPRESA_COMPLEMENTO = '" + eb.getComplemento() + "', EMPRESA_CEP = "
                + eb.getCep() + ", EMPRESA_CNPJ = " + eb.getCnpj() + ", EMPRESA_INSC_ESTADUAL = " + eb.getInsc_estadual() + ", EMPRESA_TELEFONE1 = "
                + eb.getTelefone1() + ", EMPRESA_TELEFONE2 = " + eb.getTelefone2() + ", EMPRESA_CHAVE_SEG = '" + eb.getNova_chave() + "';";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Empresa alterada com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

        }

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public int getTotEmpresa() {
        return TotEmpresa;
    }

    public void setTotEmpresa(int TotEmpresa) {
        this.TotEmpresa = TotEmpresa;
    }

}
