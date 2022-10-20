package service;

import beans.Employe;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.Machine;
import connexion.Connexion;
import dao.IDao;
import java.util.ArrayList;

public class MachineService implements IDao<Machine> {

	EmployeService es = new EmployeService();

	@Override
	public boolean create(Machine o) {
		try {
			String req = "insert into machine values(null, ?, ?, ?, ?, ?)";
			PreparedStatement pr = Connexion.getInstance().getConnection().prepareStatement(req);
			pr.setString(1, o.getReference());
			pr.setString(2, o.getMarque());
			pr.setDate(3, new Date(o.getDateAchat().getTime()));
			pr.setDouble(4, o.getPrix());
			pr.setInt(5, o.getEmploye().getId());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Machine o) {
		try {
			String req = "delete from machine where id  = ?";
			PreparedStatement pr = Connexion.getInstance().getConnection().prepareStatement(req);
			pr.setInt(1, o.getId());
			if (pr.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Machine o) {
		String sql ="UPDATE  machine SET reference = ?, marque = ?, dateAchat= ?, prix = ?, employe = ?  where id = ?";
		try {
			PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(sql);
                        ps.setString(1, o.getReference());
                        ps.setString(2, o.getMarque());
                        ps.setDate(3, new Date(o.getDateAchat().getTime()));
                        ps.setDouble(4, o.getPrix());
                        ps.setInt(5, o.getEmploye().getId());
                        ps.setInt(6, o.getId());
			if(ps.executeUpdate() == 1);
                            return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Machine> findAll() {
		List<Machine> machines = new ArrayList<Machine>();
		String sql = "select * from machine";
		try {
			PreparedStatement statement = Connexion.getInstance().getConnection().prepareStatement(sql);
                        
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getString("marque"), rs.getDate("dateAchat"), rs.getDouble("prix"), es.findById(rs.getInt("employe"))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return machines;
	}
	
	public List<Machine> returnMachines(Employe o) {
		List<Machine> machines = new ArrayList<Machine>();
		try {
			String req = "select * from machine where employe = ?";
			PreparedStatement pr = Connexion.getInstance().getConnection().prepareStatement(req);
			pr.setInt(1, o.getId());
			ResultSet rset = pr.executeQuery();
			while (rset.next())
				machines.add(new Machine(rset.getInt("id"), rset.getString("reference"), rset.getString("marque"),
						rset.getDate("dateAchat"), rset.getDouble("prix"), es.findById(rset.getInt("employe"))));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return machines;
	}
        public List<Machine> getMachineByDates(String d1,String d2){
		//SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		
		List<Machine> machs = new ArrayList<>();
		String str = "select * from machine where dateAchat between ? and ?";
		try {
		PreparedStatement ps = Connexion.getInstance().getConnection().prepareStatement(str);
		ps.setString(1,d1);
		ps.setString(2,d2);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			machs.add(new Machine(rs.getInt("id"),rs.getString("reference"),
					rs.getString("marque"),rs.getDate("dateAchat"),rs.getDouble("prix"), es.findById(rs.getInt("employe"))));
		}
		}
		catch(SQLException e) {e.printStackTrace();}
		return machs;
	}
	@Override
	public Machine findById(int id) {
		try {
			String req = "select * from machine where id = ?";
			PreparedStatement pr = Connexion.getInstance().getConnection().prepareStatement(req);
			pr.setInt(1, id);
			ResultSet rs = pr.executeQuery();
			if (rs.next())
				return new Machine(rs.getInt("id"), rs.getString("reference"), rs.getString("marque"),
						rs.getDate("dateAchat"), rs.getDouble("prix"), es.findById(rs.getInt("employe")));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
