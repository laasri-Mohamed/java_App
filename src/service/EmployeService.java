package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Employe;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;

public class EmployeService implements IDao<Employe> {

	@Override
	public boolean create(Employe o) {
		String sql = "insert into Employe values (null, '" + o.getNom() + "','" + o.getPrenom() + "' ," + o.getSalaire()
				+ " )";
		try {
			Statement statement = Connexion.getInstance().getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(Employe o) {
		String sql = "delete from employe where id  = " + o.getId();
		try {
			Statement statement = Connexion.getInstance().getConnection().createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override 
    
	public boolean update(Employe o) {
	
		String sql ="UPDATE employe SET nom= ? , prenom= ?,salaire = ? where id = ?";
		try {
			PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql);
                        ps.setString(1, o.getNom());
                        ps.setString(2, o.getPrenom());
                        ps.setDouble(3, o.getSalaire());
                        ps.setInt(4, o.getId());
			if(ps.executeUpdate() == 1);
                            return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
		
	

	@Override
	public List<Employe> findAll() {
		List<Employe> employes = new ArrayList<Employe>();
		String sql = "select * from employe";
		try {
			Statement statement = Connexion.getInstance().getConnection().createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				employes.add(new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDouble("salaire")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employes;
	}

	@Override
	public Employe findById(int id) {
		Employe employe = null;
		String sql = "select * from employe where id = " + id;
		try {
			Statement statement = Connexion.getInstance().getConnection().createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				employe = new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDouble("salaire"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return employe;
	}

}
