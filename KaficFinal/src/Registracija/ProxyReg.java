package Registracija;

import Kontroler.Kontroler;
import Model.User;

public class ProxyReg implements IProxyR{

	@Override
	public void registruj(User u) {
		// TODO Auto-generated method stub
		Kontroler.getInstanca().registrujNovogKorisnika(u);
	}
	@Override
	public void dodajNovogZaposlenog(User u, int id_role) {
		// TODO Auto-generated method stub
		Kontroler.getInstanca().registrujNovogZaposlenog(u,id_role);
	}

}
