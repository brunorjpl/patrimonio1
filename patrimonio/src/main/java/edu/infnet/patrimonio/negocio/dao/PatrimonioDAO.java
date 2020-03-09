package edu.infnet.patrimonio.negocio.dao;

import edu.infnet.patrimonio.modelo.Patrimonio;

public class PatrimonioDAO extends JpaDAO<Patrimonio, Integer> {
	
	public PatrimonioDAO() {
		super(Patrimonio.class);
	}

}
