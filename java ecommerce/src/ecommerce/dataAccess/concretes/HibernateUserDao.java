package ecommerce.dataAccess.concretes;

import java.util.List;

import ecommerce.dataAccess.abstracts.UserDao;
import ecommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println(user.getName() + user.getLastName() + " adlı kullanıcı başarıyla eklendi");
	}

	@Override
	public void update(User user) {
		System.out.println(user.getName() + user.getLastName() + " adlı kullanıcı başarıyla güncellendi");
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getName() + user.getLastName() + " adlı kullanıcı başarıyla silindi");
	}

	@Override
	public User get(int id) {
		return null;
	}

	@Override
	public List<User> getAll() {
		return null;
	}

}
