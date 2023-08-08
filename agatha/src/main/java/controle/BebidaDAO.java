package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Bebida;

public class BebidaDAO {
	
	public boolean inserir(Bebida b) {
		Conexao c = Conexao.getInstancia();
		Connection con = c.conectar();
		
		String query = "INSERT INTO";
		
	
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt (1, b.getIdbebida());
			ps.setString (2,b.getMarca());
			ps.executeUpdate();

			c.fecharConexao();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		return true;
	}

}
