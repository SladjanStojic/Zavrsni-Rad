package Registracija;

import Model.User;

public interface IProxyR {
	
	void dodajNovogZaposlenog(User u, int id_role);
	
	void registruj(User u);

}
