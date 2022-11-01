package ifpr.pgua.eic.listatelefonica.models.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ifpr.pgua.eic.listatelefonica.models.Contato;
import ifpr.pgua.eic.listatelefonica.models.FabricaConexoes;
import ifpr.pgua.eic.listatelefonica.models.results.Result;

public class JDBCContatoDAO implements ContatoDAO {

    private FabricaConexoes fabricaConexoes;

    public JDBCContatoDAO(FabricaConexoes fabricaConexoes) {
        this.fabricaConexoes = fabricaConexoes;
    }

    @Override
    public Result inserir(Contato contato) {
        
        try {
            
            Connection con = fabricaConexoes.getConnection();

            PreparedStatement pstm = con.prepareStatement("INSERT INTO contatos (nome, email, telefone) VALUES(?,?,?)");

            pstm.setString(1, contato.getNome());
            pstm.setString(2, contato.getEmail());
            pstm.setString(3, contato.getTelefone());

            pstm.executeUpdate();

            pstm.close();
            con.close();

            return Result.success("contato cadastrado");

        } catch (SQLException e) {
            return Result.fail(e.getMessage());
        }
    }

    @Override
    public List<Contato> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
