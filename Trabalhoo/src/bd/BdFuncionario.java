 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bd;

/**
 *
 * @author fcsa
 */
import model.Funcionario;
import java.sql.*;
import javax.swing.JOptionPane;

public class BdFuncionario {
    public int inserir (Funcionario funcionario){
        String sql = "insert into funcionario(nome, data, salarioBase) values(?,?,?)";
        try{
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getDataAdmissao());
            ps.setDouble(3, funcionario.getSalarioBase());
            ps.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        sql = "select MAX(registro) as registro FROM funcionario";
        try{
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt("registro");
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }
        return 0;
    }
}
