package ecommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ecommerce.business.abstracts.UserService;
import ecommerce.core.GoogleService;
import ecommerce.dataAccess.abstracts.UserDao;
import ecommerce.entities.concretes.User;

public class UserManager implements UserService {

	private List<String> emailList = new ArrayList<String>();
	private List<String> passwordList = new ArrayList<String>();
	
	private UserDao userDao;
	private GoogleService googleService;
	
	public UserManager(UserDao userDao, GoogleService googleService) {
		super();
		this.userDao=userDao;
		this.googleService=googleService;
	}
	
	public boolean isEmailValid(String email) {
		
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);

		return matcher.matches();
		
		}
	
	public boolean isEmailValidOnClick(String email) {
		return true;
	}

	@Override
	public void register(User user) {
		
		// parola kontrol
		if (user.getPassword().length() < 6 || user.getPassword() == null) {
			System.out.println("Parolanız en az 6 karakterden oluşmalıdır");
			return;
		}
		// var olan email kullanýmý
		if (emailList.contains(user.getEmail())) {
			System.out.println("Bu email daha önce kullanıldı");
			return;
		}
		// ad ve soyad en az 3 karakter içermeli
		if (user.getName().length() < 3 || user.getLastName().length() < 3) {
			System.out.println("Ad ve soyad en az 3 karakterden oluşmalıdır");
			return;
		}else {
			System.out.println("Doğrulama linkini " + user.getEmail() + " mail adresine gönderildi");
		}
		
		if (isEmailValid(user.getEmail())) {
			System.out.println("Kayýt iþlemi tamamlandý");
			emailList.add(user.getEmail());
			passwordList.add(user.getPassword());
			this.userDao.add(user);
			this.googleService.registerToSystem(" ONAYLANDI");
		
		}else {
			
			System.out.println("Hesap bilgilerinizi kontrol ediniz");
			
		}
		
	}

	@Override
	public void login(String email, String password) {
		
		if(emailList.contains(email) && passwordList.contains(password)) {
			System.out.println("Sisteme giriş başarılı");
		} 
		else {
			System.out.println("Email veya parolanız hatalı. Lütfen kontrol ediniz.");
		}
		
		
	}
}
