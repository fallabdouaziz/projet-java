package test;

import sn.isi.dao.AllClassImpl;
import sn.isi.dao.IAllClass;
import sn.isi.dao.IRoles;
import sn.isi.dao.LoginDao;
import sn.isi.dao.RolesImpl;
import sn.isi.entities.Roles;
import sn.isi.entities.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*LoginDao d= new LoginDao();
		User user= new User();
		user.setEmail("fall@gmail.com");
		user.setPassword("passer");
		if(d.getLogin("fall@gmai.com")!=null && d.getPassword("passer")!=null) {
			System.out.println("bakhna");
		}
		else {
			System.out.println("bakhoullllllll");
		}*/
		IRoles roledao= new RolesImpl();
		for (Roles roles : roledao.getAll()) {
			System.out.println("id : "+roles.getId());
			System.out.println("nom "+roles.getNom());
		}
	}

}
